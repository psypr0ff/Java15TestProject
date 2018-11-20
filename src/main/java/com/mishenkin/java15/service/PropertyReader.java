package com.mishenkin.java15.service;

import com.mishenkin.java15.common.constants.PersonPropertyErrors;
import com.mishenkin.java15.dao.repository.PersonRepository;
import com.mishenkin.java15.dao.repository.impl.PersonRepositoryFromPropertyFileImpl;
import com.mishenkin.java15.domain.entity.PersonalData;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * класс создающий поток чтения данных из проперти файла
 * Created by Александр on 15.11.2018.
 */
@Component
public class PropertyReader implements Runnable{
    private PersonalData personalData;

    private  String propertyFilePath;
    private static final Logger log = Logger.getLogger(PropertyReader.class);

    public PropertyReader(){}

    public PropertyReader( String propertyFilePath){
        this.propertyFilePath = propertyFilePath;
    }

    /*public void setPropertyFilePath(String propertyFilePath){
        this.propertyFilePath = propertyFilePath;
    }*/

    @Override
    public void run(){
        log.info("New thread start reading data from "+ propertyFilePath);
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
            this.personalData = new PersonalData(PersonPropertyErrors.FIO_ERROR,
                    PersonPropertyErrors.DOB_ERROR,
                    PersonPropertyErrors.EMAIL_ERROR,
                    PersonPropertyErrors.SKYPE_ERROR,
                    PersonPropertyErrors.AVATAR_ERROR,
                    PersonPropertyErrors.TARGET_ERROR,
                    PersonPropertyErrors.EXPERIENCE_ERROR,
                    PersonPropertyErrors.EDUCATION_ERROR,
                    PersonPropertyErrors.ADDITIONAL_EDUCATION_ERROR,
                    PersonPropertyErrors.SKILLS_ERROR,
                    PersonPropertyErrors.CODE_EXAMPLES_ERROR);
        }
        log.info("Thread is finished reading  data from "+ propertyFilePath);
    }

    public PersonalData getPersonalData(){
        return this.personalData;
    }
}
