package com.mishenkin.java15.controller;


import com.mishenkin.java15.domain.entity.Summary;
import com.mishenkin.java15.domain.entity.Tags;
import com.mishenkin.java15.repository.ResumeRepository;
import com.mishenkin.java15.repository.TagsRepository;
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
    @Autowired
    private TagsRepository tagsRepository;

    @GetMapping
    public List<Summary> getAll(){
        return resumeRepository.findAll();
    }

    /*@GetMapping("/tag/{id}")
    public List<Tags> getTagsById(@PathVariable long id){
        return tagsRepository.findBySummaryId(id);
    }*/

    @GetMapping("/tag")
    public List<Tags> getAllTags(){
        return tagsRepository.findAll();
    }

    @GetMapping("{id}")
    public Optional<Summary> getResumeById(@PathVariable long id){
        return resumeRepository.findById(id);
    }

    @PutMapping("{id}")
    public Summary updateResumeById(@PathVariable Long id, @RequestBody Summary summary){
        Summary newSummary = summary;
        newSummary.setId(id);
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
