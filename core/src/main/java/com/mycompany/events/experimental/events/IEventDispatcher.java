package com.mycompany.events.experimental.events;

/**
 * Created by sliubetskyi on 3/30/16.
 */
public interface IEventDispatcher {
    public <T> void addEventHandler(String eventType, Class<T> dataType, IEventHandler<Event<T>> handler);

    public void addEventHandler(String eventType, IEventHandler handler);

    public void removeEventHandler(String eventType, IEventHandler handler);
    public <T> void removeEventHandler(String eventType, Class<T> dataType, IEventHandler<Event<T>> handler);

    public boolean hasEventHandler(String eventType);
    public boolean hasEventHandler(String eventType, Class<? extends Object> dataType);

    public <T> void dispatchEvent(Event<T> event);
    public <T> void dispatchEvent(Event<T> event, Class<T> dataType);
}
