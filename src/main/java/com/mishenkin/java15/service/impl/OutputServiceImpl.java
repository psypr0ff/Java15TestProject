package com.mishenkin.java15.service.impl;

import com.mishenkin.java15.dao.repository.PersonRepository;
import com.mishenkin.java15.dao.repository.impl.PersonRepositoryFromPropertyFileImpl;
import com.mishenkin.java15.domain.entity.PersonalData;
import com.mishenkin.java15.service.api.OutputService;
import com.mishenkin.java15.view.HtmlView;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.log4j.Logger;

/**
 * Created by Александр on 30.10.2018.
 */
public class OutputServiceImpl implements OutputService{
    private PersonalData personalData;

    //org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(OutputServiceImpl.class);
    private static final Logger log = Logger.getLogger(OutputServiceImpl.class);


    /**
     * Метод для подключения .properties файла
     * @param propertyFilePath - путь к .properties файла
     */
    public OutputServiceImpl(String propertyFilePath){
        PersonRepository personRepository = new PersonRepositoryFromPropertyFileImpl(
                getClass().getClassLoader().getResourceAsStream(propertyFilePath)
        );
        this.personalData = personRepository.getPersonalData();
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
                new String[]{"skills"},
                new String[]{"codes"});
    }

    @Override
    public void createHtmlFile(String outputHttpFilePath){
        HtmlView html = new HtmlView(personalData);
        if (this.personalData != null){
            try {
                File file = new File(outputHttpFilePath);
                if(!file.exists()){
                    file.createNewFile();
                }
                try (FileWriter writer = new FileWriter(outputHttpFilePath, false)){
                    for (String e:html.getHtml())
                        writer.write(e);
                    writer.flush();
                    log.info(outputHttpFilePath+" file created");
                }
            }
            catch(IOException ex){
                //System.out.println(ex.getMessage());
                log.error("Ошибка ввода вывода");
            }
        }
    }
}
