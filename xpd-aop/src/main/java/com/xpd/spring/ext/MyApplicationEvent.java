package com.xpd.spring.ext;

import org.springframework.context.ApplicationEvent;

//@Async
public class MyApplicationEvent extends ApplicationEvent {
    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public MyApplicationEvent(Object source) {
        super(source);
    }

    @Override
    public Object getSource() {
        System.out.println("MyApplicationEvent .....");
        return super.getSource();
    }
}
