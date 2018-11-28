package com.mishenkin.java15.domain.entity;

import java.util.*;

/**
 * класс-модель в котором описаны все поля из проперти файла
 * и геттеры и сеттеры для них
 * Created by Александр on 30.10.2018.
 */
public class PersonalData {
    /**
     * Свойство - Фамилия Имя Отчество
     */
    private String FIO;

    /**
     * Свойство - дата рождения
     */
    private String DOB;

    //private String phone;

    /**
     * Свойство - электронная почта
     */
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
    private String[] target;

    /**
     * Свойство - опыт работы
     */
    private String[] experiences;

    /**
     * Свойство - образование
     */
    private String[] educations;

    /**
     * Свойство - дополнительное образование
     */
    private String[] additionalEducations;

    /**
     * Свойство - скилы
     */
    private String[] skills;

    /**
     * Свойство - примеры кода
     */
    private String[] examplesCode;

    //конструктор
    public PersonalData(
            String FIO,
            String DOB,
            //String phone,
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
        //this.phone = phone;
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

    /*public String getPhone() {
        return phone;
    }*/

    /*public void setPhone(String phone) {
        this.phone = phone;
    }*/

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
        if (this==otherObject) {
            return true;
        }

        //если сравниваемый объект null тода false
        if (otherObject == null) {
            return false;
        }

        //если классы разные то false
        if (getClass()!= otherObject.getClass()) {
            return false;
        }

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
        Collections.addAll(emailList, email);
        return emailList;
    }

    public ArrayList<String> getTargetList(){
        ArrayList<String> targetList = new ArrayList<>();
        Collections.addAll(targetList, target);
        return targetList;
    }

    public ArrayList<String> getExperiencesList(){
        ArrayList<String> experiencesList = new ArrayList<>();
        Collections.addAll(experiencesList, experiences);
        return experiencesList;
    }

    public ArrayList<String> getEducationsList(){
        ArrayList<String> educationsList = new ArrayList<>();
        Collections.addAll(educationsList, educations);
        return educationsList;
    }

    public ArrayList<String> getAdditionalEducationsList(){
        ArrayList<String> additionalEducationList = new ArrayList<>();
        Collections.addAll(additionalEducationList, additionalEducations);
        return additionalEducationList;
    }

    public ArrayList<String> getSkillsList(){
        ArrayList<String> skillsList = new ArrayList<>();
        Collections.addAll(skillsList,skills);
        return skillsList;
    }

    public ArrayList<String> getCodeExaplesList(){
        ArrayList<String> codeExampleList = new ArrayList<>();
        Collections.addAll(codeExampleList, examplesCode);
        return codeExampleList;
    }
}
