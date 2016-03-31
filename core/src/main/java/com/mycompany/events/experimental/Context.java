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
    public void addEventHandler(String eventType, IEventHandler handler) {
        for (IEventDispatcher dispatcher : getDispatchers()) {
            dispatcher.addEventHandler(eventType,handler);
        }
    }

    @Override
    public void removeEventHandler(String eventType) {
        for (IEventDispatcher dispatcher : getDispatchers()) {
            dispatcher.removeEventHandler(eventType);
        }
    }

    @Override
    public void dispatchEvent(Event event) {
        for (IEventDispatcher dispatcher : getDispatchers()) {
            if (dispatcher.hasEventHandler(event.name)) {
                dispatcher.dispatchEvent(event);
            }
        }
    }

    @Override
    public boolean hasEventHandler(String eventType) {
        for (IEventDispatcher dispatcher : getDispatchers()) {
            return dispatcher.hasEventHandler(eventType);
        }
        return false;
    }
}
