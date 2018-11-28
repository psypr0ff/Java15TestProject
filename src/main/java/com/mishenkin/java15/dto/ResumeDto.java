package com.mishenkin.java15.dto;

import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * объект ResumeDto с простыми полями
 * Created by Александр on 24.11.2018.
 */
/*@Component*/
public class ResumeDto {
    /**
     * Свойство - Фамилия Имя Отчество
     */
    public String FIO;

    /**
     * Свойство - дата рождения
     */
    public String DOB;

    /**
     * Свойство - электронная почта
     */
    public String[] email;

    /**
     * Свойство - скайп
     */
    public String skype;

    /**
     * Свойство - ссылка на аватарку
     */
    public String avatar;

    /**
     * Свойство - цель
     */
    public String[] target;

    /**
     * Свойство - опыт работы
     */
    public String[] experiences;

    /**
     * Свойство - образование
     */
    public String[] educations;

    /**
     * Свойство - дополнительное образование
     */
    public String[] additionalEducations;

    /**
     * Свойство - скилы
     */
    public Map<String, String> skills;

    /**
     * Свойство - примеры кода
     */
    public String[] examplesCode;
}
