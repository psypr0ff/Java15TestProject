package com.mishenkin.java15.controller;

import com.mishenkin.java15.repository.ResumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Александр on 03.12.2018.
 */

@Controller
public class MainController {
    @Autowired
    private ResumeRepository resumeRepository;

    @RequestMapping("/")
    public String listRest(Model model){
        return "rest";
    }

    @RequestMapping("/resume/{id}")
    public String restResume(Model model, @PathVariable Long id){
        model.addAttribute("id", resumeRepository.getOne(id).getId());
        return "restresume";
    }
}
