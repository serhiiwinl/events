package com.mycompany.events.experimental.trackers;

import com.mycompany.events.experimental.events.Event;
import com.mycompany.events.experimental.events.IEventHandler;


/**
 * Created by sliubetskyi on 3/30/16.
 */
public class ConcreteTracker extends BaseTrackerEventsDispatcher {

    @Override
    public void initTracker(Object data) {
        System.out.println("ConcreteTracker initTracker");
    }

    @Override
    public void subscribeForEvents() {
        addEventHandler(Event.LOGIN_WITH_DATA, new IEventHandler() {
            @Override
            public void handle(Event event) {
                System.out.println(event.getName() + " for ConcreteTracker");
            }
        });

        addEventHandler(Event.LOGIN_WITH_DATA, Integer.class, new IEventHandler<Event<Integer>>() {
            @Override
            public void handle(Event<Integer> event) {
                System.out.println(event.getName() + " for ConcreteTracker");
            }
        });

        addEventHandler(Event.UNREGISTER_WITH_DATA, String.class, new IEventHandler<Event<String>>() {
            @Override
            public void handle(Event event) {
                System.out.println(event.getName() + " for ConcreteTracker");
                System.out.println("data : " + event.getData());
            }
        });

        addEventHandler(Event.UNREGISTER, new IEventHandler<Event>() {
            @Override
            public void handle(Event event) {
                System.out.println(event.getName() + " for ConcreteTracker");
            }
        });

        addEventHandler(Event.APP_START, new IEventHandler() {
            @Override
            public void handle(Event event) {
                System.out.println(event.getName() + " for ConcreteTracker");
            }
        });
    }

    @Override
    public void stop(Object data) {
        removeEventHandler(Event.UNREGISTER);
        removeEventHandler(Event.APP_START);
        removeEventHandler(Event.LOGIN_WITH_DATA);
    }
}
