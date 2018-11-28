package com.mishenkin.java15.controller;

import com.mishenkin.java15.domain.entity.PersonalData;
import com.mishenkin.java15.domain.entity.Summary;
import com.mishenkin.java15.dto.ResumeDto;
import com.mishenkin.java15.dto.ResumeRepository;
import com.mishenkin.java15.service.ResumeService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;
import java.util.stream.Collectors;

/**
 * контроллер ResumeController который отдает содержимое резюме
 * ResumeController должен брать из ResumeService
 * ResumeController  должен прокидывать данные из ResumeDto  в resume.html
 * Created by Александр on 23.11.2018.
 */
@Controller
public class ResumeController {
    private static final Logger log = Logger.getLogger(ResumeController.class);

    @Autowired
    private ResumeService resumeService;

    @Autowired
    private ResumeRepository resumeRepository;

    @RequestMapping("/")
    public String getResume(Model model){
        ResumeDto resumeDto = resumeService.getResumeDto();
        model.addAttribute("FIO",resumeDto.FIO);
        model.addAttribute("DOB", resumeDto.DOB);
        model.addAttribute("email", resumeDto.email);
        model.addAttribute("skype", resumeDto.skype);
        model.addAttribute("avatar", resumeDto.avatar);
        model.addAttribute("target", resumeDto.target);
        model.addAttribute("experience", resumeDto.experiences);
        model.addAttribute("education", resumeDto.educations);
        model.addAttribute("addEducation", resumeDto.additionalEducations);
        model.addAttribute("skills", resumeDto.skills);
        model.addAttribute("codeExamples", resumeDto.examplesCode);
        log.info("Get resume data from property file");
        return "resume";
    }

    @RequestMapping("/db")
    public String getResumeFromDb(Model model){
        List<Summary> list = resumeRepository.findAll();
        Summary personalData = list.get(0);
        model.addAttribute("FIO", personalData.getFIO());
        model.addAttribute("DOB", personalData.getDOB());
        model.addAttribute("email", personalData.getEmail().split(";"));
        model.addAttribute("skype", personalData.getSkype());
        model.addAttribute("avatar", personalData.getAvatar());
        model.addAttribute("target", personalData.getTarget().split(";"));
        model.addAttribute("experience", personalData.getExperiences().split(";"));
        model.addAttribute("education", personalData.getEducations().split(";"));
        model.addAttribute("addEducation", personalData.getAdditionalEducations().split(";"));
        /*model.addAttribute("skills", personalData.getSkillsMap());*/
        model.addAttribute("skills", personalData.getSkillsMap().entrySet()
                .stream()
                .sorted(Map.Entry.<String,String>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new)));
        model.addAttribute("codeExamples", personalData.getExamplesCode().split(";"));
        log.info("Get resume data from h2 dataBase");
        return "resume";
    }



}
