package com.roman.AirHockey.Main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static final int WIDTH = 400;
    public static final int HEIGHT = 600;


    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("springConfig.xml");
        context.getBean("mainFrameBean");
    }
}