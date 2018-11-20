package com.mishenkin.java15.service;

import com.mishenkin.java15.domain.entity.PersonalData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created by Александр on 20.11.2018.
 */
@Component
public class PropertyService {
    @Autowired
    @Qualifier("propertyReader")
    PropertyReader reader;


    public PersonalData getPropertyDataByPropertyReader(String propertyFilePath){
        reader = new PropertyReader(propertyFilePath);
        reader.run();
        return reader.getPersonalData();
    }
}
