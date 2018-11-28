package com.mishenkin.java15.domain.entity;

import com.mishenkin.java15.common.constants.PersonPropertyErrors;

import javax.persistence.*;
import java.util.*;

/**
 * класс-модель в котором описаны все поля из проперти файла
 * и геттеры и сеттеры для них
 * Created by Александр on 30.10.2018.
 */
@Entity
@Table(name = "summary")
public class PersonalData {
    @Id
    @GeneratedValue
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
    @Column(columnDefinition = "CHAR(255)")
    private String[] email;

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
    @Column(columnDefinition = "VARCHAR(255)")
    private String[] target;

    /**
     * Свойство - опыт работы
     */
    @Column(columnDefinition = "VARCHAR(1000)")
    private String[] experiences;

    /**
     * Свойство - образование
     */
    @Column(columnDefinition = "VARCHAR(1000)")
    private String[] educations;

    /**
     * Свойство - дополнительное образование
     */
    @Column(columnDefinition = "VARCHAR(255)")
    private String[] additionalEducations;

    /**
     * Свойство - скилы
     */
    @Column(columnDefinition = "VARCHAR(255)")
    private String[] skills;

    /**
     * Свойство - примеры кода
     */
    @Column(columnDefinition = "VARCHAR(1000)")
    private String[] examplesCode;

    //конструктор
    public PersonalData(
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
    }

    public PersonalData(){
        this(null,null,null,null,null,null,null,null,null,null,null);
    }

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

    public String[] getEmail() {
        return email;
    }

    public void setEmail(String[] email) {
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

    public String[] getTarget() {
        return target;
    }

    public void setTarget(String[] target) {
        this.target = target;
    }

    public String[] getExperiences() {
        return experiences;
    }

    public void setExperiences(String[] experiences) {
        this.experiences = experiences;
    }

    public String[] getEducations() {
        return educations;
    }

    public void setEducations(String[] educations) {
        this.educations = educations;
    }

    public String[] getAdditionalEducations() {
        return additionalEducations;
    }

    public void setAdditionalEducations(String[] additionalEducations) {
        this.additionalEducations = additionalEducations;
    }

    public String[] getSkills() {
        return skills;
    }

    public void setSkills(String[] skills) {
        this.skills = skills;
    }

    public String[] getExamplesCode() {
        return examplesCode;
    }

    public void setExamplesCode(String[] examplesCode) {
        this.examplesCode = examplesCode;
    }

    @Override //переопределяем метод equals для сравнения объекьлв
    public boolean equals(Object otherObject){
        //если объекты равны = true
        if (this==otherObject) return true;

        //если сравниваемый объект null тода false
        if (otherObject == null) return false;

        //если классы разные то false
        if (getClass()!= otherObject.getClass()) return false;

        //приводим объект к типу PersonalData
        PersonalData other = (PersonalData) otherObject;

        //сравниваем все поля объекта
        return Objects.equals(this.FIO, other.FIO)
                && Objects.equals(DOB, other.DOB)
                && Arrays.equals(this.email, other.email)
                && Arrays.equals(this.target, other.target)
                && Arrays.equals(this.experiences, other.experiences)
                && Arrays.equals(this.educations, other.educations)
                && Arrays.equals(this.additionalEducations, other.additionalEducations)
                && Arrays.equals(this.examplesCode, other.examplesCode)
                && Arrays.equals(this.skills, other.skills)
                && Objects.equals(this.skype, other.skype)
                && Objects.equals(this.avatar, other.avatar)
                ;
    }

    //-------------------- приводим данные из массивов проперти к коллекциям

    public ArrayList<String> getEmailList(){
        ArrayList<String> emailList = new ArrayList<>();
        if (email==null) emailList.add(PersonPropertyErrors.EMAIL_ERROR[0]);
        else  Collections.addAll(emailList, email);
        return emailList;
    }

    public ArrayList<String> getTargetList(){
        ArrayList<String> targetList = new ArrayList<>();
        if (target==null) targetList.add(PersonPropertyErrors.TARGET_ERROR[0]);
        else Collections.addAll(targetList, target);
        return targetList;
    }

    public ArrayList<String> getExperiencesList(){
        ArrayList<String> experiencesList = new ArrayList<>();
        if (experiences == null) experiencesList.add(PersonPropertyErrors.EXPERIENCE_ERROR[0]);
        else   Collections.addAll(experiencesList, experiences);
        return experiencesList;
    }

    public ArrayList<String> getEducationsList(){
        ArrayList<String> educationsList = new ArrayList<>();
        if (educations==null) educationsList.add(PersonPropertyErrors.EDUCATION_ERROR[0]);
        else Collections.addAll(educationsList, educations);
        return educationsList;
    }

    public ArrayList<String> getAdditionalEducationsList(){
        ArrayList<String> additionalEducationList = new ArrayList<>();
        if (additionalEducations==null) additionalEducationList.add(PersonPropertyErrors.ADDITIONAL_EDUCATION_ERROR[0]);
        else Collections.addAll(additionalEducationList, additionalEducations);
        return additionalEducationList;
    }

    public ArrayList<String> getSkillsList(){
        ArrayList<String> skillsList = new ArrayList<>();
        if (skills==null) skillsList.add(PersonPropertyErrors.SKILLS_ERROR[0]);
        else Collections.addAll(skillsList,skills);
        return skillsList;
    }

    public ArrayList<String> getCodeExaplesList(){
        ArrayList<String> codeExampleList = new ArrayList<>();
        if (examplesCode == null) codeExampleList.add(PersonPropertyErrors.CODE_EXAMPLES_ERROR[0]);
        else Collections.addAll(codeExampleList, examplesCode);
        return codeExampleList;
    }

    public HashMap<String, String> getSkillsMap(){
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

    public void setPersonalData(PersonalData personalData){
        if (!personalData.getFIO().equals(PersonPropertyErrors.FIO_ERROR))
            this.setFIO(personalData.getFIO());
        if (!personalData.getDOB().equals(PersonPropertyErrors.DOB_ERROR))
            this.setDOB(personalData.getDOB());
        /*if (personalData.getEmail()[0].isEmpty())
            this.setEmail(PersonPropertyErrors.EMAIL_ERROR);*/
        if (!personalData.getEmail()[0].equals(PersonPropertyErrors.EMAIL_ERROR[0]))
            this.setEmail(personalData.getEmail());
        if (!personalData.getSkype().equals(PersonPropertyErrors.SKYPE_ERROR))
            this.setSkype(personalData.getSkype());
        if (!personalData.getAvatar().equals(PersonPropertyErrors.AVATAR_ERROR))
            this.setAvatarPath(personalData.getAvatar());
        if (!personalData.getTarget()[0].equals(PersonPropertyErrors.TARGET_ERROR[0]))
            this.setTarget(personalData.getTarget());
        if(!personalData.getExperiences()[0].equals(PersonPropertyErrors.EXPERIENCE_ERROR[0]))
            this.setExperiences(personalData.getExperiences());
        if (!personalData.getEducations()[0].equals(PersonPropertyErrors.EDUCATION_ERROR[0]))
            this.setEducations(personalData.getEducations());
        if (!personalData.getAdditionalEducations()[0].equals(PersonPropertyErrors.ADDITIONAL_EDUCATION_ERROR[0]))
            this.setAdditionalEducations(personalData.getAdditionalEducations());
        if (!personalData.getSkills()[0].equals(PersonPropertyErrors.SKILLS_ERROR[0]))
            this.setSkills(personalData.getSkills());
        if (!personalData.getExamplesCode()[0].equals(PersonPropertyErrors.CODE_EXAMPLES_ERROR[0]))
            this.setExamplesCode(personalData.getExamplesCode());
    }
}
