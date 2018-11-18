package com.mishenkin.java15;

import com.mishenkin.java15.controller.PropertyReader;
import com.mishenkin.java15.view.HtmlView;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * класс запускающий web-приложение
 * Created by Александр on 15.11.2018.
 */
@RestController
@SpringBootApplication
public class SpringMain {

    @RequestMapping("/")
    String htmlData(){
        PropertyReader propertyReader = new PropertyReader("B:\\Users\\Александр\\IdeaProjects\\Java15TestProject\\src\\main\\resources\\1.properties");
        propertyReader.run();
        HtmlView htmlView = new HtmlView(propertyReader.getPersonalData());
        return htmlView.htmlData();
    }

    public static void main(String[] args){
        //OutputService outputService = new OutputServiceImpl(propertyReader.getPersonalData());
        //System.out.println();
        //outputService.htmlData();
        SpringApplication.run(SpringMain.class, args);
    }
}
