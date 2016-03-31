package com.mycompany.events.experimental.events;

/**
 * Created by sliubetskyi on 3/29/16.
 */
public class Event {

    public static final String LOGIN = "login";
    public static final String APP_START = "app_start";
    public static final String REGISTER = "register";
    public static final String UNREGISTER = "unregister";

    public String name;

    public Event(String name) {
        this.name = name;
    }


}
