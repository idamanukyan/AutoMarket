package com.example.auto_am.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.print("Session was created!!! ID:");
        System.out.println(se.getSession().getId());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.print("Session was destroyed!!! ID:");
        System.out.println(se.getSession().getId());

    }
}
