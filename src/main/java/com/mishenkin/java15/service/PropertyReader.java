package com.mishenkin.java15.service;

import com.mishenkin.java15.dao.repository.PersonRepository;
import com.mishenkin.java15.dao.repository.impl.PersonRepositoryFromPropertyFileImpl;
import com.mishenkin.java15.domain.entity.PersonalData;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * класс создающий поток чтения данных из проперти файла
 * Created by Александр on 15.11.2018.
 */
public class PropertyReader implements Runnable{
    private PersonalData personalData;

    private final String propertyFilePath;
    private static final Logger log = Logger.getLogger(PropertyReader.class);

    public PropertyReader(String propertyFilePath){
        this.propertyFilePath = propertyFilePath;
    }

    @Override
    public void run(){
        if (new File(propertyFilePath).exists()){
            PersonRepository personRepository = null;
            try (InputStream fileInputStream = new FileInputStream(propertyFilePath) ){
                personRepository = new PersonRepositoryFromPropertyFileImpl(fileInputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (personRepository != null) {
                this.personalData = personRepository.getPersonalData();
            } else this.personalData = new PersonalData();
        }
        else {
            log.error("Property file "+propertyFilePath+" not found. Using default values.");
            this.personalData = new PersonalData("FIO",
                    "DOB",
                    new String[]{"email"},
                    "skype",
                    "avatar",
                    new String[]{"target"},
                    new String[]{"experiences"},
                    new String[]{"educations"},
                    new String[]{"additional educations"},
                    new String[]{"skill01:10","skill03:30","skill02:20"},
                    new String[]{"codes"});
        }
    }

    public PersonalData getPersonalData(){
        return this.personalData;
    }
}
