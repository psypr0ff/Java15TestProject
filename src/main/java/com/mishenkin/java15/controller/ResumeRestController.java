package com.mishenkin.java15.controller;


import com.mishenkin.java15.domain.entity.Summary;
import com.mishenkin.java15.dto.ResumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * Created by Александр on 30.11.2018.
 */

@RestController
@Controller
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

    @PostMapping("{id}")
    public Summary updateResumeById(@PathVariable long id, @RequestBody Summary summary){
        resumeRepository.findById(id).get().setFIO(summary.getFIO());
        //resumeRepository.getOne(id)
        return resumeRepository.getOne(id);
    }

    @PostMapping
    public void saveNewResume(@RequestBody Summary summary){
        resumeRepository.save(summary);
    }


}
