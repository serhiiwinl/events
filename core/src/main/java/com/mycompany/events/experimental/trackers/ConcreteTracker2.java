package com.mycompany.events.experimental.trackers;

import com.mycompany.events.experimental.events.IEventHandler;
import com.mycompany.events.experimental.events.Event;


/**
 * Created by sliubetskyi on 3/30/16.
 */
public class ConcreteTracker2 extends BaseTrackerEventsDispatcher implements IEventHandler {
    @Override
    public void subscribeForEvents() {
        addEventHandler(Event.LOGIN, null, this);
    }

    @Override
    public void initTracker(Object data) {
        System.out.println("ConcreteTracker2 initTracker");
    }

    @Override
    public void handle(Event event) {
        System.out.println(event.getName() + " for ConcreteTracker2");
    }

    @Override
    public void stop(Object data) {
        removeEventHandler(Event.LOGIN);
    }
}
