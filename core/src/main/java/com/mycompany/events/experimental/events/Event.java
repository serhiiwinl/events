package com.mycompany.events.experimental.events;

/**
 * Created by sliubetskyi on 3/29/16.
 */
public class Event<T> {

    public static final String LOGIN = "login";
    public static final String APP_START = "app_start";
    public static final String REGISTER = "register";
    public static final String UNREGISTER = "unregister";
    public static final String LOGIN_WITH_DATA = "login_with_data";
    public static final String UNREGISTER_WITH_DATA = "unregister_with_data";

    private final String name;

    public T getData() {
        return data;
    }

    private final T data;

    public String getName() {
        return name;
    }

    public Event(String name) {
        this (name, null);
    }

    public Event(String name, T data) {
        if (name == null) {
            this.name = "";
        } else {
            this.name = name;
        }
        this.data = data;
    }


}
