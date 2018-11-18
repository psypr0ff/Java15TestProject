package com.mishenkin.java15;

import com.mishenkin.java15.service.PropertyReader;
import com.mishenkin.java15.domain.entity.PersonalData;
import com.mishenkin.java15.view.HtmlView;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * класс запускающий web-приложение
 * Created by Александр on 15.11.2018.
 */
@RestController
@SpringBootApplication
public class SpringMain {
    private static final String PROPERTY_FILE_PATH_ONE =
            "src/main/resources/1.properties";
    private static final String PROPERTY_FILE_PATH_TWO =
            "src/main/resources/2.properties";

    //создаем строку выводящую ответ
    @RequestMapping("/")
    String htmlData(){
        PersonalData personalData = new PersonalData();

        //создаем два объекта-потока PropertyReader для чтения двух разных проперти
        //файлов, передав им в параметрах имя необходимого проперти файла
        PropertyReader propertyReader1 = new PropertyReader(PROPERTY_FILE_PATH_ONE);
        PropertyReader propertyReader2 = new PropertyReader(PROPERTY_FILE_PATH_TWO);

        //запускаем потоки
        propertyReader1.run();
        propertyReader2.run();

        propertyReader2.getPersonalData().getAdditionalEducationsList().forEach(System.out::println);
        //передаем результаты
        personalData.setPersonalData(propertyReader1.getPersonalData());
        personalData.setPersonalData(propertyReader2.getPersonalData());

        //формируем строку с HTML данными
        HtmlView htmlView = new HtmlView(personalData);
        System.out.println(htmlView.htmlData());
        return htmlView.htmlData();
    }

    public static void main(String[] args){
        SpringApplication.run(SpringMain.class, args);
    }
}
