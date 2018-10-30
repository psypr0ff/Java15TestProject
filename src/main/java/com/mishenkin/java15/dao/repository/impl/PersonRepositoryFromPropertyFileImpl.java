package com.mishenkin.java15.dao.repository.impl;

import com.mishenkin.java15.common.constants.PersonPropertyKeys;
import com.mishenkin.java15.dao.repository.PersonRepository;
import com.mishenkin.java15.domain.entity.PersonalData;

import java.io.FileNotFoundException;
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
    private Properties personDataFile;

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
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public PersonalData getPersonalData(){
        PersonalData personalData = null;
        if (this.personDataFile != null) personalData = new PersonalData(
                personDataFile.getProperty(PersonPropertyKeys.FIO),
                personDataFile.getProperty(PersonPropertyKeys.DOB),
                personDataFile.getProperty(PersonPropertyKeys.EMAIL),
                personDataFile.getProperty(PersonPropertyKeys.SKYPE),
                personDataFile.getProperty(PersonPropertyKeys.AVATAR),
                personDataFile.getProperty(PersonPropertyKeys.TARGET),
                personDataFile.getProperty(PersonPropertyKeys.EXPERIENCES),
                personDataFile.getProperty(PersonPropertyKeys.EDUCATIONS),
                personDataFile.getProperty(PersonPropertyKeys.ADDITIONAL_EDUCATIONS),
                personDataFile.getProperty(PersonPropertyKeys.SKILLS),
                personDataFile.getProperty(PersonPropertyKeys.EXAMPLES_CODE)
                );
        return personalData;
    }
}
