package com.mishenkin.java15.service;

import com.mishenkin.java15.domain.entity.PersonalData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


/**
 * Создать класс - PropertyService с методом отвечающим за получение данных ,
 * сделать его Spring бином, заинжектить в него PropertyReader и в методе получения
 * данных сервиса вызвать метод чтения данных класса PropertyReader
 * Created by Александр on 20.11.2018.
 */
@Component
public class PropertyService {
    @Autowired
    @Qualifier("propertyReader")
    private PropertyReader reader;

    /**
     * метод принимающий путь к файлу проперти и возвращающий объект содержащий данные из файла проперти
     * @param propertyFilePath путь к проперти файлу
     * @return PersonalData
     */
    public PersonalData getPropertyDataByPropertyReader(String propertyFilePath){
        reader.setPropertyFilePath(propertyFilePath);
        Thread readerThread = new Thread(reader);
        readerThread.start();
        try {
            readerThread.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return reader.getPersonalData();
    }
}
