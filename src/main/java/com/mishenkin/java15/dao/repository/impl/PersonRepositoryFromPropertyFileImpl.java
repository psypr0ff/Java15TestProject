package com.mishenkin.java15.dao.repository.impl;

import com.mishenkin.java15.common.constants.PersonPropertyKeys;
import com.mishenkin.java15.dao.repository.PersonRepository;
import com.mishenkin.java15.domain.entity.PersonalData;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
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
        //return properties;
            return null;
    }

    @Override
    public PersonalData getPersonalData(){
        PersonalData personalData = null;
        //try {
            if (this.personDataFile != null) personalData = new PersonalData(
                    personDataFile.getProperty(PersonPropertyKeys.FIO),
                    personDataFile.getProperty(PersonPropertyKeys.DOB),
                    personDataFile.getProperty(PersonPropertyKeys.EMAIL).split(";"),
                    personDataFile.getProperty(PersonPropertyKeys.SKYPE),
                    personDataFile.getProperty(PersonPropertyKeys.AVATAR),
                    personDataFile.getProperty(PersonPropertyKeys.TARGET).split(";"),
                    personDataFile.getProperty(PersonPropertyKeys.EXPERIENCES).split(";"),
                    personDataFile.getProperty(PersonPropertyKeys.EDUCATIONS).split(";"),
                    personDataFile.getProperty(PersonPropertyKeys.ADDITIONAL_EDUCATIONS).split(";"),
                    personDataFile.getProperty(PersonPropertyKeys.SKILLS).split(";"),
                    personDataFile.getProperty(PersonPropertyKeys.EXAMPLES_CODE).split(";")
            );
            return personalData;
        /*}catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }
        return null;*/
    }
}
