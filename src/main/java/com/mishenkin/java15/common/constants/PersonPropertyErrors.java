package com.mishenkin.java15.common.constants;

/**
 * хранилище сообщений об ошибках
 * Created by Александр on 18.11.2018.
 */
public interface PersonPropertyErrors {
    String FIO_ERROR = "имя не указано";
    String DOB_ERROR = "не указана дата рождения";
    String[] EMAIL_ERROR = new String[]{"не указан email"};
    String SKYPE_ERROR = "не указан skype";
    String AVATAR_ERROR = "' alt='не указана ссылка на автар'";
    String[] TARGET_ERROR = new String[]{"цели не указаны"};
    String[] EXPERIENCE_ERROR = new String[]{"опыт не указан"};
    String[] EDUCATION_ERROR = new String[]{"образование не указано"};
    String[] ADDITIONAL_EDUCATION_ERROR = new String[]{"доп образование не указано"};
    String[] SKILLS_ERROR = new String[]{"навыки не указаны"};
    String[] CODE_EXAMPLES_ERROR = new String[]{"примеры кода отсутствуют"};
}
