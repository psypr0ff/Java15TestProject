package com.mishenkin.java15;

import com.mishenkin.java15.service.api.OutputService;
import com.mishenkin.java15.service.impl.OutputServiceImpl;

/**
 * Created by Александр on 30.10.2018.
 */
public class Main {
    public static void main(String[] args) {
        OutputService outputService = new OutputServiceImpl("input.properties");
        outputService.createHtmlFile("output1.html");
    }
}
