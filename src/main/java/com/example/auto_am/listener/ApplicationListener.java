package com.example.auto_am.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ApplicationListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Welcome");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Bye");
    }
}
