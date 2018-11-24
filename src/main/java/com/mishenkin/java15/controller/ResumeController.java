package com.mishenkin.java15.controller;

import com.mishenkin.java15.dto.ResumeDto;
import com.mishenkin.java15.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * контроллер ResumeController который отдает содержимое резюме
 * ResumeController должен брать из ResumeService
 * ResumeController  должен прокидывать данные из ResumeDto  в resume.html
 * Created by Александр on 23.11.2018.
 */
@Controller
public class ResumeController {

    @Autowired
    private ResumeService resumeService;

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
        return "resume";
    }
}
