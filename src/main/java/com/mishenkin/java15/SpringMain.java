package com.mishenkin.java15;

/*import com.mishenkin.java15.domain.entity.PersonalData;
import com.mishenkin.java15.service.PropertyReader;*/
import com.mishenkin.java15.view.HtmlView;
import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
/*import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResumeRestController;*/

/**
 * класс запускающий web-приложение
 * Created by Александр on 15.11.2018.
 */
//@ResumeRestController
@SpringBootApplication
public class SpringMain {
    private static final Logger log = Logger.getLogger(SpringMain.class);
    private static final String PROPERTY_FILE_PATH =
            "input.properties";
    private static final String OUTPUT_HTML_FILE_PATH =
            "outputLection6.html";

    /* то, что закомментировано - нужно было для домашки к 5 лекции
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
        Thread propertyThread1 = new Thread(propertyReader1);
        Thread propertyThread2 = new Thread(propertyReader2);
        propertyThread1.start();
        propertyThread2.start();
        try {
            propertyThread1.join();
            propertyThread2.join();
        } catch (InterruptedException e) {
            log.error("Main thread is interrupted");
            //e.printStackTrace();
        }

        //propertyReader1.run();
        //propertyReader2.run();


        //передаем результаты
        personalData.setPersonalData(propertyReader1.getPersonalData());
        personalData.setPersonalData(propertyReader2.getPersonalData());

        //формируем строку с HTML данными
        HtmlView htmlView = new HtmlView(personalData);

        return htmlView.htmlData();
    }*/

    public static void main(String[] args){
        ConfigurableApplicationContext context = SpringApplication.run(SpringMain.class, args);
        HtmlView htmlGenerator = context.getBean(HtmlView.class);
        htmlGenerator.generateHtmlFile(PROPERTY_FILE_PATH, OUTPUT_HTML_FILE_PATH);
    }
}
