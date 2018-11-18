package com.mishenkin.java15.dao.repository.impl;

import com.mishenkin.java15.common.constants.PersonPropertyErrors;
import com.mishenkin.java15.common.constants.PersonPropertyKeys;
import com.mishenkin.java15.dao.repository.PersonRepository;
import com.mishenkin.java15.domain.entity.PersonalData;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Properties;

/**
 * Реализация репозитория @see {@link PersonRepository}
 * Created by Александр on 30.10.2018.
 */
public class PersonRepositoryFromPropertyFileImpl implements PersonRepository{
    private final Properties personDataFile;
    private static final Logger log = Logger.getLogger(PersonRepositoryFromPropertyFileImpl.class);

    //конструктор
    public PersonRepositoryFromPropertyFileImpl(InputStream configFileInput){
        this.personDataFile = getProperties(configFileInput);
    }

    /**
     * Возвращает объект файла найстроек
     *
     * @param configFileInput - поток файла настроек
     * @return - объект Properties
     */
    private Properties getProperties(InputStream configFileInput){
        Properties properties = new Properties();
        try {
            properties.load(new InputStreamReader(configFileInput, Charset.forName("UTF-8")));
            return properties;
        } catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public PersonalData getPersonalData(){
        PersonalData personalData = null;
            if (this.personDataFile != null) personalData = new PersonalData(
                    personDataFile.getProperty(PersonPropertyKeys.FIO, PersonPropertyErrors.FIO_ERROR),
                    personDataFile.getProperty(PersonPropertyKeys.DOB, PersonPropertyErrors.DOB_ERROR),
                    personDataFile.getProperty(PersonPropertyKeys.EMAIL, PersonPropertyErrors.EMAIL_ERROR[0]).split(";"),
                    personDataFile.getProperty(PersonPropertyKeys.SKYPE, PersonPropertyErrors.SKYPE_ERROR),
                    personDataFile.getProperty(PersonPropertyKeys.AVATAR, PersonPropertyErrors.AVATAR_ERROR),
                    personDataFile.getProperty(PersonPropertyKeys.TARGET, PersonPropertyErrors.TARGET_ERROR[0]).split(";"),
                    personDataFile.getProperty(PersonPropertyKeys.EXPERIENCES,PersonPropertyErrors.EXPERIENCE_ERROR[0]).split(";"),
                    personDataFile.getProperty(PersonPropertyKeys.EDUCATIONS, PersonPropertyErrors.EDUCATION_ERROR[0]).split(";"),
                    personDataFile.getProperty(PersonPropertyKeys.ADDITIONAL_EDUCATIONS, PersonPropertyErrors.ADDITIONAL_EDUCATION_ERROR[0]).split(";"),
                    personDataFile.getProperty(PersonPropertyKeys.SKILLS, PersonPropertyErrors.SKILLS_ERROR[0]).split(";"),
                    personDataFile.getProperty(PersonPropertyKeys.EXAMPLES_CODE, PersonPropertyErrors.CODE_EXAMPLES_ERROR[0]).split(";")
            );
            log.info("Reading data from property file");
            return personalData;
    }
}
