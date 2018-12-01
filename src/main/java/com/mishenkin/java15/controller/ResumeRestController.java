package com.mishenkin.java15.controller;


import com.mishenkin.java15.domain.entity.Summary;
import com.mishenkin.java15.dto.ResumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Александр on 30.11.2018.
 */

@RestController
@RequestMapping("/rest")
public class ResumeRestController {
    @Autowired
    private ResumeRepository resumeRepository;

    @GetMapping
    public List<Summary> getAll(){
        return resumeRepository.findAll();
    }

    @GetMapping("{id}")
    public Optional<Summary> getResumeById(@PathVariable long id){
        return resumeRepository.findById(id);
    }

    @PutMapping("{id}")
    public Summary updateResumeById(@PathVariable long id, @RequestBody Summary summary){
        Summary newSummary = new Summary();
        resumeRepository.findById(id).get().setFIO(summary.getFIO());
        newSummary = resumeRepository.getOne(id);
        return resumeRepository.save(newSummary);
    }

    @PostMapping
    public void saveNewResume(@RequestBody Summary summary){
        /*summary.setId(Long.valueOf(ThreadLocalRandom.current().nextInt()));*/
        resumeRepository.save(summary);
    }

    @Controller
    class ResumeListController{
        /*@RequestMapping("/list")
        public String resumeList(Model model){
            model.addAttribute("summary", getAll());
            return "list";
        }
        @RequestMapping("/list/{id}")
        public String getResume(Model model, @PathVariable Long id){
            Summary personalData = getResumeById(id).get();
            model.addAttribute("FIO", personalData.getFIO());
            model.addAttribute("DOB", personalData.getDOB());
            model.addAttribute("email", personalData.getEmailArray());
            model.addAttribute("skype", personalData.getSkype());
            model.addAttribute("avatar", personalData.getAvatar());
            model.addAttribute("target", personalData.getTargetArray());
            model.addAttribute("experience", personalData.getExperienceArray());
            model.addAttribute("education", personalData.getEducationArray());
            model.addAttribute("addEducation", personalData.getAdditionalEducationArray());
        *//*model.addAttribute("skills", personalData.getSkillsMap());*//*
            model.addAttribute("skills", personalData.getSkillsMap().entrySet()
                    .stream()
                    .sorted(Map.Entry.<String,String>comparingByValue().reversed())
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                            (e1, e2) -> e1, LinkedHashMap::new)));
            model.addAttribute("codeExamples", personalData.getCodeExampleArray());
            return "resume";
        }*/

        @RequestMapping("/list/rest")
        public String listRest(Model model){
            return "rest";
        }

        @RequestMapping("/list/rest/resume/{id}")
        public String restResume(Model model, @PathVariable Long id){
            model.addAttribute("id", resumeRepository.getOne(id).getId());
            return "restresume";
        }
    }
}
