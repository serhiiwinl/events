package com.mycompany.events.experimental;

import com.mycompany.events.experimental.events.Event;
import com.mycompany.events.experimental.events.IEventDispatcher;
import com.mycompany.events.experimental.events.IEventHandler;
import com.mycompany.events.experimental.trackers.BaseTrackerEventsDispatcher;
import com.mycompany.events.experimental.trackers.ConcreteTracker;
import com.mycompany.events.experimental.trackers.ConcreteTracker2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sliubetskyi on 3/30/16.
 */
public class Context implements IEventDispatcher {
    private static volatile  Context instance;
    private List<BaseTrackerEventsDispatcher> trackers;
    private List<IEventDispatcher> dispatchers;

    private Context() {
    }

    public static Context getInstance() {
        if (instance == null) {
            synchronized (Context.class) {
                if(instance == null) {
                    instance = new Context();
                }
            }
        }
        return instance;
    }

    public List<BaseTrackerEventsDispatcher> getTrackers() {
        if (this.trackers == null) {
            this.trackers = new ArrayList<>();
            this.trackers.add(new ConcreteTracker());
            this.trackers.add(new ConcreteTracker2());
        }
        return this.trackers;
    }

    public List<IEventDispatcher> getDispatchers() {
        if (this.dispatchers == null) {
            this.dispatchers = new ArrayList<>();
            this.dispatchers.addAll(getTrackers());
        }
        return this.dispatchers;
    }

    @Override
    public <T> void dispatchEvent(Event<T> event, Class<T> dataType) {
        for (IEventDispatcher dispatcher : getDispatchers()) {
            if (dispatcher.hasEventHandler(event.getName())) {
                dispatcher.dispatchEvent(event, dataType);
            }
        }
    }

    @Override
    public <T> void addEventHandler(String eventType, Class<T> dataType, IEventHandler<Event<T>> handler) {
        for (IEventDispatcher dispatcher : getDispatchers()) {
            dispatcher.addEventHandler(eventType, dataType, handler);
        }
    }

    @Override
    public void addEventHandler(String eventType, IEventHandler handler) {
        for (IEventDispatcher dispatcher : getDispatchers()) {
            dispatcher.addEventHandler(eventType, handler);
        }
    }

    @Override
    public void removeEventHandler(String eventType, IEventHandler handler) {
        for (IEventDispatcher dispatcher : getDispatchers()) {
            dispatcher.removeEventHandler(eventType, handler);
        }
    }

    @Override
    public <T> void removeEventHandler(String eventType, Class<T> dataType, IEventHandler<Event<T>> handler) {
        for (IEventDispatcher dispatcher : getDispatchers()) {
            dispatcher.removeEventHandler(eventType, dataType, handler);
        }
    }

    @Override
    public boolean hasEventHandler(String eventType) {
        return this.hasEventHandler(eventType, null);
    }

    @Override
    public boolean hasEventHandler(String eventType, Class<? extends Object> dataType) {
        for (IEventDispatcher dispatcher : getDispatchers()) {
            return dispatcher.hasEventHandler(eventType, dataType);
        }
        return false;
    }

    @Override
    public <T> void dispatchEvent(Event<T> event) {
        this.dispatchEvent(event, null);
    }
}
