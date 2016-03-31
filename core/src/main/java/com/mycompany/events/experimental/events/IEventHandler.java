package com.mycompany.events.experimental.events;

import com.mycompany.events.experimental.events.Event;


/**
 * Created by sliubetskyi on 3/30/16.
 */
public interface IEventHandler<T extends Event> {
    public abstract void handle(T event);
}
