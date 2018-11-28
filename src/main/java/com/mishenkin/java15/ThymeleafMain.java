package com.mishenkin.java15;

import com.mishenkin.java15.service.PropertyReader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * класс запускающий web-приложение
 * Created by Александр on 24.11.2018.
 */

@SpringBootApplication
public class ThymeleafMain {
    //путь к проеперти файлу
    private static final String PROPERTY_FILE_PATH =
            "src/main/resources/input.properties";
    public static void main(String[] args){
        ApplicationContext context = SpringApplication.run(ThymeleafMain.class);

        //получаем бин класса получающего данные из проперти файла и пускаем поток на чтение
        PropertyReader propertyReader = context.getBean(PropertyReader.class);
        propertyReader.setPropertyFilePath(PROPERTY_FILE_PATH);
        Thread propertyThread = new Thread(propertyReader);
        propertyThread.start();
        try{
            propertyThread.join();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
