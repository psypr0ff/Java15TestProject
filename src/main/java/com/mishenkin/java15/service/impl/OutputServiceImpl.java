package com.mishenkin.java15.service.impl;

import com.mishenkin.java15.dao.repository.PersonRepository;
import com.mishenkin.java15.dao.repository.impl.PersonRepositoryFromPropertyFileImpl;
import com.mishenkin.java15.domain.entity.PersonalData;
import com.mishenkin.java15.service.api.OutputService;
import com.mishenkin.java15.view.HtmlView;
import org.apache.log4j.Logger;

import java.io.*;

/**
 * реализация интерфейса OutputService
 * Created by Александр on 30.10.2018.
 */

public class OutputServiceImpl implements OutputService{
    private final PersonalData personalData;
    private static final Logger log = Logger.getLogger(OutputServiceImpl.class);


    /**
     * Метод для подключения .properties файла
     * @param propertyFilePath - путь к .properties файла
     */
    public OutputServiceImpl(String propertyFilePath){
        //File file = new File(propertyFilePath);
        if (new File(propertyFilePath).exists()){
            PersonRepository personRepository = null;
            try (InputStream fileInputStream = new FileInputStream(propertyFilePath) ){
                personRepository = new PersonRepositoryFromPropertyFileImpl(
                        fileInputStream
                        //getClass().getClassLoader().getResourceAsStream(propertyFilePath)
                        );
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (personRepository != null) {
                this.personalData = personRepository.getPersonalData();
            } else this.personalData = new PersonalData();
        }
        else {
            log.error("Property file not found. Using default values.");
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

    //конструктор по умолчанию
    public OutputServiceImpl(){
        this.personalData = new PersonalData("FIO",
                "DOB",
                new String[]{"email"},
                "skype",
                "avatar",
                new String[]{"target"},
                new String[]{"exp"},
                new String[]{"ed"},
                new String[]{"adEd"},
                new String[]{"skill01:10","skill03:30","skill02:20"},
                new String[]{"codes"});
    }

    public OutputServiceImpl(PersonalData personalData){
        this.personalData= personalData;
    }

    @Override
    public void createHtmlFile(String outputHttpFilePath){
        HtmlView html = new HtmlView(personalData);
        if (this.personalData != null)
        {
            try (FileWriter writer = new FileWriter(outputHttpFilePath, false)){
                //html.getHtml().forEach(tag -> writer.write(tag));
                for (String e:html.getHtml())
                    writer.write(e);
                writer.flush();
                log.info(outputHttpFilePath+" file created");
            }
            catch(IOException ex){
                log.error("Input/output error");
            }
        }
    }
}
