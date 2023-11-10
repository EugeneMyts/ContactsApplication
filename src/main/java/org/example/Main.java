package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        if (context.getEnvironment().getActiveProfiles()[0].equals("init")) {
            context.getBean(ContactLoader.class).load();

            System.out.println("Starting..");
        }
        context.getBean(AppService.class).start();
    }
}