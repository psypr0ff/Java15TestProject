package com.mishenkin.java15.domain.entity;

import com.mishenkin.java15.common.constants.PersonPropertyErrors;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

/**
 * Created by Александр on 28.11.2018.
 */
@Entity
public class Summary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Long id;

    /**
     * Свойство - Фамилия Имя Отчество
     */
    private String FIO;

    /**
     * Свойство - дата рождения
     */
    private String DOB;

    /**
     * Свойство - электронная почта
     */
    //@Column(columnDefinition = "CHAR(255)")
    private String email;

    /**
     * Свойство - скайп
     */
    private String skype;

    /**
     * Свойство - ссылка на аватарку
     */
    private String avatar;

    /**
     * Свойство - цель
     */
  /*  @Column
    @Type(type = "text")*/
    private String target;

    /**
     * Свойство - опыт работы
     */
    /*@Column
    @Type(type = "text")*/
    private String experiences;

    /**
     * Свойство - образование
     */
/*    @Column(columnDefinition = "VARCHAR(255)")*/
    private String educations;

    /**
     * Свойство - дополнительное образование
     */
    /*@Column(columnDefinition = "VARCHAR(255)")*/
    private String additionalEducations;

    /**
     * Свойство - скилы
     */
   /* @Column(columnDefinition = "VARCHAR(255)")*/
    private String skills;

    /**
     * Свойство - примеры кода
     */
  /*  @Column(columnDefinition = "VARCHAR(255)")*/
    private String examplesCode;

    //конструктор
/*    public PersonalData(
            String FIO,
            String DOB,
            String[] email,
            String skype,
            String avatar,
            String[] target,
            String[] experiences,
            String[] educations,
            String[] additionalEducations,
            String[] skills,
            String[] examplesCode) {
        this.FIO = FIO;
        this.DOB = DOB;
        this.email = email;
        this.skype = skype;
        this.avatar = avatar;
        this.target = target;
        this.experiences = experiences;
        this.educations = educations;
        this.additionalEducations = additionalEducations;
        this.skills = skills;
        this.examplesCode = examplesCode;
    }*/

/*    public PersonalData(){
        this(null,null,null,null,null,null,null,null,null,null,null);
    }*/

    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    private String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatarPath(String avatar) {
        this.avatar = avatar;
    }

    private String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    private String getExperiences() {
        return experiences;
    }

    public void setExperiences(String experiences) {
        this.experiences = experiences;
    }

    private String getEducations() {
        return educations;
    }

    public void setEducations(String educations) {
        this.educations = educations;
    }

    private String getAdditionalEducations() {
        return additionalEducations;
    }

    public void setAdditionalEducations(String additionalEducations) {
        this.additionalEducations = additionalEducations;
    }


    private String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    private String getExamplesCode() {
        return examplesCode;
    }

    public void setExamplesCode(String examplesCode) {
        this.examplesCode = examplesCode;
    }


    private ArrayList<String> getSkillsList(){
        ArrayList<String> skillsList = new ArrayList<>();
        if (skills==null) skillsList.add(PersonPropertyErrors.SKILLS_ERROR[0]);
        else Collections.addAll(skillsList,skills.split(";"));
        return skillsList;
    }

    private HashMap<String, String> getSkillsMap(){
        HashMap<String, String> skillsMap = new HashMap<>();
        if (!getSkillsList().isEmpty()) {
            getSkillsList().forEach(e ->{
                if (e.split(":").length>1) {
                    skillsMap.put(e.split(":")[0].trim(), e.split(":")[1].trim());
                } else skillsMap.put(e,"0");
            });
        }
        return skillsMap;
    }

    public HashMap<String,String> getSortedSkillsMap(){
        return getSkillsMap().entrySet()
                .stream()
                .sorted(Map.Entry.<String,String>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));
    }

    public String[] getEmailArray(){
        return getEmail().split(";");
    }

    public String[] getExperienceArray(){
        return  getExperiences().split(";");
    }

    public String[] getTargetArray(){
        return getTarget().split(";");
    }

    public String[] getEducationArray(){
        return getEducations().split(";");
    }

    public String[] getAdditionalEducationArray(){
        return getAdditionalEducations().split(";");
    }

    public String[] getCodeExampleArray(){
        return getExamplesCode().split(";");
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
