package com.mycompany.events.experimental.events;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by sliubetskyi on 3/30/16.
 */
public class EventDispatcher implements IEventDispatcher {
    private final ConcurrentHashMap<String, IEventHandler> eventHandlers = new ConcurrentHashMap<>();

    @Override
    public <T> void addEventHandler(String eventType, Class<T> dataType, IEventHandler<Event<T>> handler) {
        String eventKey = eventType;
        if (dataType != null) {
            eventKey += dataType.getCanonicalName();
        }
        this.eventHandlers.put(eventKey, handler);
    }

    @Override
    public void addEventHandler(String eventType, IEventHandler handler) {
        if (eventType != null)
            this.eventHandlers.remove(eventType);
    }

    @Override
    public void removeEventHandler(String eventType, IEventHandler handler) {
        if (eventType != null) {
            this.eventHandlers.remove(eventType);
        }
    }

    @Override
    public <T> void removeEventHandler(String eventType, Class<T> dataType, IEventHandler<Event<T>> handler) {
        //TODO:
        String eventKey = eventType;
        if (dataType != null) {
            eventKey += dataType.getCanonicalName();
        }
        this.eventHandlers.remove(eventKey);
    }

    @Override
    public boolean hasEventHandler(String eventType, Class<? extends Object> dataType) {
        if (dataType == null)
            return false;
        else return hasEventHandler(eventType + dataType.getCanonicalName());
    }

    @Override
    public <T> void dispatchEvent(Event<T> event) {
        this.dispatchEvent(event, null);
    }

    @Override
    public boolean hasEventHandler(String eventKey) {
        if (eventHandlers.get(eventKey) != null) {
            return true;
        }
        return false;
    }

    @Override
    public <T extends Object> void dispatchEvent(Event<T> event, Class<T> dataType) {
        String eventKey = "";
        if (event != null) {
            eventKey = event.getName();
        }
        if (dataType != null) {
            eventKey += dataType.getCanonicalName();
        }
        if (hasEventHandler(eventKey)) {
            this.eventHandlers.get(event.getName()).handle(event);
        } else {
            //TODO:remove it late
            System.out.println("no handler for this Event: " + event.getName());
        }
    }

    protected final void removeEventHandler(String eventType) {
        if (eventType != null) {
            this.eventHandlers.remove(eventType);
        }
    }

    protected final void removeEventHandler(String eventType, Class<? extends Object> dataType) {
        String eventKey = "";
        if (eventType != null) {
            eventKey = eventType;
        }
        if (dataType != null) {
            eventKey += dataType.getCanonicalName();
        }
        this.eventHandlers.remove(eventKey);
    }

}
