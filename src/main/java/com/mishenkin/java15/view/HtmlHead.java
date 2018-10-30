package com.mishenkin.java15.view;

import com.mishenkin.java15.domain.entity.PersonalData;

/**
 * Created by Александр on 31.10.2018.
 */
public class HtmlHead {
    private String head;

    public HtmlHead(PersonalData personalData){
        this.head = "<!DOCTYPE html>" +
                "<html>" +
                "<head>" +
                //подключаем bootstrap3
                "<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css\">" +
                "<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css\">" +
                "<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js\"></script>" +
                "<meta http-equiv='Content-Type' content='text/html; charset=UTF-8' />" +
                "<title>" +
                //указываем в заголовке Ф.И.О.
                personalData.getFIO() +
                "</title>" +
                "</head>";
    }

    public String getHead(){
        return this.head;
    }
}
