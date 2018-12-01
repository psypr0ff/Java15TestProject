package com.mishenkin.java15.view;

import com.mishenkin.java15.domain.entity.PersonalData;
import com.mishenkin.java15.service.PropertyService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * класс генерирует содержимое для HTML файла
 * Created by Александр on 31.10.2018.
 */
@Component
public class HtmlView {
    private ArrayList<String> html;
    private  PersonalData personalData;
    private static final Logger log = Logger.getLogger(HtmlView.class);

    @Autowired
    @Qualifier("propertyService")
    private PropertyService propertyService;

    public HtmlView(){}

    public HtmlView(PersonalData personalData){
        this.personalData = personalData;
    }

    /**
     * метод генерирующий содержимое HTML файла
     */
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
        personalData.getEmailList().forEach(e->{
            if (e.length()>1)
                html.add(e+"<br>");
            else html.add(e);
        });
        //for (String e:personalData.getEmailArray()) if (e.length()>1) html.add(e+"<br>");else html.add(e);
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
        personalData.getTargetList().forEach(e->html.add("<li>"+e+"<br>"));
        //for (String e:personalData.getTargetList()) if(e.length()>1) html.add("<li>"+e+"<br>"); else html.add(e);
        html.add("</div></div>");
        html.add("<div class='panel panel-default' style='margin: 20px; '>" +
                "<div class='panel-heading'>" +
                "<h3 class='panel-title'>Опыт</h3>" +
                "</div>" +
                "<div class='panel-body'>");
        personalData.getExperiencesList().forEach(e->html.add("<li>"+e+"<br>"));
        //for (String e:personalData.getExperiencesList()) html.add("<li>"+e+"<br>");
        html.add("</div>" +
                "</div>" +
                "<div class='panel panel-default' style='margin: 20px; '>" +
                "<div class='panel-heading'>" +
                "<h3 class='panel-title'>Образование</h3>" +
                "</div>" +
                "<div class='panel-body'>");
        personalData.getEducationsList().forEach(e->html.add("<li>"+e+"<br>"));
        //for (String e:personalData.getEducationsList()) html.add("<li>"+e+"<br>");
        html.add("</div>" +
                "</div>" +
                "<div class='panel panel-default' style='margin: 20px; '>" +
                "<div class='panel-heading'>" +
                "<h3 class='panel-title'>Доп.образование и курсы</h3>" +
                "</div>" +
                "<div class='panel-body'>");
        personalData.getAdditionalEducationsList().forEach(e->html.add("<li>"+e+"<br>"));
        //for (String e:personalData.getAdditionalEducationsList()) html.add("<li>"+e+"<br>");
        html.add("</div>" +
                "</div>" +
                "<div class='panel panel-default' style='margin: 20px; '>" +
                "<div class='panel-heading'>" +
                "<h3 class='panel-title'>Навыки</h3>" +
                "</div>" +
                "<div class='panel-body'>");
        if (!personalData.getSkillsMap().isEmpty())
        personalData
                .getSkillsMap()
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String,String>comparingByValue().reversed())
                .forEach(e->html.add("<li>"+e.getKey()+": "+e.getValue()+"<br>"));
       else personalData.getSkillsList().forEach(e->html.add("<li>"+e+"<br>"));
        //for (String e:personalData.getSkillsList()) html.add("<li>"+e+"<br>");
        html.add("</div>" +
                "</div>" +
                "<div class='panel panel-default' style='margin: 20px; '>" +
                "<div class='panel-heading'>" +
                "<h3 class='panel-title'>Пример кода</h3>" +
                "</div>" +
                "<div class='panel-body'>");
        personalData.getCodeExaplesList().forEach(e->html.add("<li><a href="+e+">"+e+"</a><br>"));
       // for (String e:personalData.getCodeExaplesList()) html.add("<li><a href="+e+">"+e+"</a><br>");
        html.add("</div>" +
                "</div>" +
                "</div>" +
                "</body>" +
                "</html>");
        log.info("Generating html data");
    }

    /**
     * метод возвращающий сгенерированно содержимое для HTML файла в виде списка строк
     * @return
     */
    public ArrayList<String> getHtml(){
        generateHtml();
        return this.html;
    }


    /**
     * метод возвращающий сгенерированно содержимое для HTML файла в виде одной строки
     * @return
     */
    public String htmlData(){
        return this.getHtml().stream().map(e-> e).collect(Collectors.joining());
    }

    /**
     * метод генерирующий HTML файл
     * @param inputPath путь к файлу проперти с данными
     * @param outputPath путь куда будет сохраняться сгенерированный файл
     */
    public void generateHtmlFile(String inputPath, String outputPath){
        PersonalData personalData = propertyService.getPropertyDataByPropertyReader(inputPath);
        if (personalData!=null) {
            try (FileWriter writer = new FileWriter(outputPath)) {
                writer.write(new HtmlView(personalData).htmlData());
                writer.flush();

            }catch (IOException e){
                log.error("Generating HTML Error");
            }
        }
        else log.error("Generating HTML Error, personal data is null");
    }

}
