package com.mishenkin.java15.view;

import com.mishenkin.java15.domain.entity.PersonalData;
import org.apache.log4j.Logger;

import java.util.ArrayList;

/**
 * класс генерирует содержимое для HTML файла
 * Created by Александр on 31.10.2018.
 */
public class HtmlView {
    private ArrayList<String> html;
    private final PersonalData personalData;
    private static final Logger log = Logger.getLogger(HtmlView.class);

    public HtmlView(PersonalData personalData){
        this.personalData = personalData;
    }

    private void generateHtml(){
        html = new ArrayList<>();
        html.add("<!DOCTYPE html>");
        html.add("<html>");
        html.add("<head>");
        html.add("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css'>");
        html.add("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css'>");
        html.add("<script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js'></script>");
        html.add("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8' />");
        html.add("<title>"+personalData.getFIO()+"</title>");
        html.add("</head>");
        html.add("<body style='background: grey;'>");
        html.add("<div style='background: white; border: solid 1px black; margin-left:15%; margin-right: 15%; margin-top: 1%' >");
        html.add("<div class='row' ><h1><center>Резюме</center></h1></div>");
        html.add("<div class='row center-block' >");
        html.add("<div class='col-md-8' >");
        html.add("<dl class='dl-horizontal' style='margin-bottom: 0;'>" +
                "<dt>Ф.И.О.</dt><dd>" +
                personalData.getFIO() + //пишем ФИО
                "</dd></dl>");
        html.add("<dl class='dl-horizontal' style='margin-bottom: 0;'>" +
                "<dt>Дата рождения</dt><dd>" +
                personalData.getDOB() + //пишем дату рождения
                "</dd></dl>");
        html.add( "<dl class='dl-horizontal' style='margin-bottom: 0;'>" +
                "<dt>email</dt>" +
                "<dd>");
        for (String e:personalData.getEmail()) if (e.length()>1) html.add(e+"<br>");else html.add(e);
        html.add("</dd></dl>");
        html.add("<dl class='dl-horizontal' style='margin-bottom: 0;'>" +
                "<dt>Skype</dt><dd>" +
                personalData.getSkype() + //указываем логин в скайпе
                "</dd></dl>");
        html.add("</div>");
        html.add("<div class='col-md-4'>" +
                //указываем ссылку на аватар
                "<img src='" + personalData.getAvatar() + "' class='center-block' alt='Аватар' height='100'>" +
                "</div>");
        html.add("</div>");
        html.add("<div class='panel panel-default' style='margin: 20px; '>" +
                "<div class='panel-heading'>" +
                "<h3 class='panel-title'>Цель</h3>" +
                "</div>" +
                "<div class='panel-body'>");
        for (String e:personalData.getTarget()) html.add("<li>"+e+"<br>");
        html.add("</div></div>");
        html.add("<div class='panel panel-default' style='margin: 20px; '>" +
                "<div class='panel-heading'>" +
                "<h3 class='panel-title'>Опыт</h3>" +
                "</div>" +
                "<div class='panel-body'>");
        for (String e:personalData.getExperiences()) html.add("<li>"+e+"<br>");
        html.add("</div>" +
                "</div>" +
                "<div class='panel panel-default' style='margin: 20px; '>" +
                "<div class='panel-heading'>" +
                "<h3 class='panel-title'>Образование</h3>" +
                "</div>" +
                "<div class='panel-body'>");
        for (String e:personalData.getEducations()) html.add("<li>"+e+"<br>");
        html.add("</div>" +
                "</div>" +
                "<div class='panel panel-default' style='margin: 20px; '>" +
                "<div class='panel-heading'>" +
                "<h3 class='panel-title'>Доп.образование и курсы</h3>" +
                "</div>" +
                "<div class='panel-body'>");
        for (String e:personalData.getAdditionalEducations()) html.add("<li>"+e+"<br>");
        html.add("</div>" +
                "</div>" +
                "<div class='panel panel-default' style='margin: 20px; '>" +
                "<div class='panel-heading'>" +
                "<h3 class='panel-title'>Навыки</h3>" +
                "</div>" +
                "<div class='panel-body'>");
        for (String e:personalData.getSkills()) html.add("<li>"+e+"<br>");
        html.add("</div>" +
                "</div>" +
                "<div class='panel panel-default' style='margin: 20px; '>" +
                "<div class='panel-heading'>" +
                "<h3 class='panel-title'>Пример кода</h3>" +
                "</div>" +
                "<div class='panel-body'>");
        for (String e:personalData.getExamplesCode()) html.add("<li><a href="+e+">"+e+"</a><br>");
        html.add("</div>" +
                "</div>" +
                "</div>" +
                "</body>" +
                "</html>");
        log.info("Generating html data");
    }

    public ArrayList<String> getHtml(){
        generateHtml();
        return this.html;
    }
}
