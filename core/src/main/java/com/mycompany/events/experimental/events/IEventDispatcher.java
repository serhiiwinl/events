package com.mycompany.events.experimental.events;

/**
 * Created by sliubetskyi on 3/30/16.
 */
public interface IEventDispatcher {
    public void addEventHandler(String eventType, IEventHandler handler);
    public void removeEventHandler(String eventType);
    public boolean hasEventHandler(String eventType);
    public void dispatchEvent(Event event);
}
