package com.xpd.spring.ext;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class ListenerService {

    @EventListener
    public void listener(ApplicationEvent event) {
        System.out.println("ListenerService监听到的: " + event);
    }
}
