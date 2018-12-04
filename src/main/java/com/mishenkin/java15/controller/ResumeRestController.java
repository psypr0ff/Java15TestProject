package com.mishenkin.java15.controller;


import com.mishenkin.java15.domain.entity.Summary;
import com.mishenkin.java15.dto.ResumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * рест контроллер
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
        Summary newSummary = summary;
        newSummary.setId(id);
        //resumeRepository.findById(id).get().setFIO(summary.getFIO());
        //newSummary = resumeRepository.getOne(id);

        return resumeRepository.save(newSummary);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable long id){
        resumeRepository.deleteById(id);
    }

    @PostMapping
    public void saveNewResume(@RequestBody Summary summary){
        resumeRepository.save(summary);
    }
}
