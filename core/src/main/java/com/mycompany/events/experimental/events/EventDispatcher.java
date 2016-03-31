package com.mycompany.events.experimental.events;

import java.util.HashMap;

/**
 * Created by sliubetskyi on 3/30/16.
 */
public class EventDispatcher implements IEventDispatcher {
    private final HashMap<String, IEventHandler> eventHandlers = new HashMap<>();

    @Override
    public void addEventHandler(String eventType, IEventHandler handler) {
        this.eventHandlers.put(eventType, handler);
    }

    @Override
    public void removeEventHandler(String eventType) {
        this.eventHandlers.remove(eventType);
    }

    @Override
    public boolean hasEventHandler(String eventType) {
        if (eventHandlers.get(eventType) != null) {
            return true;
        }
        return false;
    }

    @Override
    public void dispatchEvent(Event event) {
        if (hasEventHandler(event.name)) {
            this.eventHandlers.get(event.name).handle(event);
        } else {
            //TODO:remove it late
            System.out.println("no handler for this Event: " + event.name);
        }
    }

}
