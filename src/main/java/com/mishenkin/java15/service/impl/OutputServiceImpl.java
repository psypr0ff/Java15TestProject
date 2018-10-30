package com.mishenkin.java15.service.impl;

import com.mishenkin.java15.dao.repository.PersonRepository;
import com.mishenkin.java15.dao.repository.impl.PersonRepositoryFromPropertyFileImpl;
import com.mishenkin.java15.domain.entity.PersonalData;
import com.mishenkin.java15.service.api.OutputService;

/**
 * Created by Александр on 30.10.2018.
 */
public class OutputServiceImpl implements OutputService{
    private PersonalData personalData;

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

    @Override
    public void createHtmlFile(String outputHttpFilePath){
        if (this.personalData != null){

        }
    }
}
