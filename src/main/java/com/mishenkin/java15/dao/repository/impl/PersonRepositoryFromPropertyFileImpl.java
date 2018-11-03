package com.mishenkin.java15.dao.repository.impl;

import com.mishenkin.java15.common.constants.PersonPropertyKeys;
import com.mishenkin.java15.dao.repository.PersonRepository;
import com.mishenkin.java15.domain.entity.PersonalData;
import org.apache.log4j.Logger;

import java.io.*;
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
                    personDataFile.getProperty(PersonPropertyKeys.FIO,"имя не указано"),
                    personDataFile.getProperty(PersonPropertyKeys.DOB, "дата рождения не указана"),
                    personDataFile.getProperty(PersonPropertyKeys.EMAIL, "электронная почта не указвна").split(";"),
                    personDataFile.getProperty(PersonPropertyKeys.SKYPE, "skype не указан"),
                    personDataFile.getProperty(PersonPropertyKeys.AVATAR, "' alt='не указана ссылка на автар'"),
                    personDataFile.getProperty(PersonPropertyKeys.TARGET, "цели не указаны").split(";"),
                    personDataFile.getProperty(PersonPropertyKeys.EXPERIENCES,"опыт не указан").split(";"),
                    personDataFile.getProperty(PersonPropertyKeys.EDUCATIONS, "образование не указано").split(";"),
                    personDataFile.getProperty(PersonPropertyKeys.ADDITIONAL_EDUCATIONS, "доп образование не указано").split(";"),
                    personDataFile.getProperty(PersonPropertyKeys.SKILLS, "навыки не указаны").split(";"),
                    personDataFile.getProperty(PersonPropertyKeys.EXAMPLES_CODE, "примеры кода отсутствуют").split(";")
            );
            log.info("Reading data from property file");
            return personalData;
    }
}
