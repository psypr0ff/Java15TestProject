package com.mishenkin.java15.service;

import com.mishenkin.java15.domain.entity.PersonalData;
import com.mishenkin.java15.dto.ResumeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * ResumeService должен отдавать объект ResumeDto с простыми полями
 * Created by Александр on 23.11.2018.
 */
@Component
public class ResumeService {
    /*@Autowired
    private ResumeDto resumeDto;*/

    @Autowired
    private PropertyReader propertyReader;

    /**
     * метод возвращает объект ResumeDto c простыми полями
     * @return ResumeDto
     */
    public ResumeDto getResumeDto(){
        ResumeDto resumeDto = new ResumeDto();
        PersonalData personalData = propertyReader.getPersonalData();
        resumeDto.FIO = personalData.getFIO();
        resumeDto.DOB = personalData.getDOB();
        resumeDto.email = personalData.getEmail();
        resumeDto.skype = personalData.getSkype();
        resumeDto.avatar = personalData.getAvatar();
        resumeDto.target = personalData.getTarget();
        resumeDto.experiences = personalData.getExperiences();
        resumeDto.educations = personalData.getEducations();
        resumeDto.additionalEducations = personalData.getAdditionalEducations();
        resumeDto.skills = personalData
                .getSkillsMap()
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String,String>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                    (e1, e2) -> e1, LinkedHashMap::new));
        resumeDto.examplesCode = personalData.getExamplesCode();
        return resumeDto;
    }

 /*   public ResumeDto getResumeDtoFromDB(){

        return
    }*/
}
