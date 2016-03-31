package com.mycompany.events.experimental.trackers;

import com.mycompany.events.experimental.events.DataEvent;
import com.mycompany.events.experimental.events.IEventHandler;
import com.mycompany.events.experimental.events.Event;


/**
 * Created by sliubetskyi on 3/30/16.
 */
public class ConcreteTracker2 extends BaseTrackerEventsDispatcher implements IEventHandler {
    @Override
    public void subscribeForEvents() {
        addEventHandler(Event.LOGIN, this);
    }

    @Override
    public void init(Object data) {
        System.out.println("ConcreteTracker2 init");
    }

    @Override
    public void handle(Event event) {
        System.out.println(event.name + " for ConcreteTracker2");
    }

    @Override
    public void stopTracking(Object data) {
        removeEventHandler(Event.LOGIN);
    }
}
