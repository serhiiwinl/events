package com.mycompany.events.experimental.events;

/**
 * Created by sliubetskyi on 3/30/16.
 */
public class DataEvent extends Event {
    public static final String LOGIN_WITH_DATA = "login_with_data";
    public static final String UNREGISTER_WITH_DATA = "unregister_with_data";
    public Object data;

    public DataEvent(String name, Object data) {
        super(name);
        this.data = data;
    }

}
