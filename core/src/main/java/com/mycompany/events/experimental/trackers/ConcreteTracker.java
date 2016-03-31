package com.mycompany.events.experimental.trackers;

import com.mycompany.events.experimental.events.IEventHandler;
import com.mycompany.events.experimental.events.DataEvent;
import com.mycompany.events.experimental.events.Event;


/**
 * Created by sliubetskyi on 3/30/16.
 */
public class ConcreteTracker extends BaseTrackerEventsDispatcher {

    @Override
    public void init(Object data) {
        System.out.println("ConcreteTracker init");
    }

    @Override
    public void subscribeForEvents() {
        addEventHandler(DataEvent.LOGIN_WITH_DATA, new IEventHandler<DataEvent>() {
            @Override
            public void handle(DataEvent event) {
                System.out.println(event.name + " for ConcreteTracker");
                System.out.println("data : " + event.data);
            }
        });

        addEventHandler(DataEvent.UNREGISTER_WITH_DATA, new IEventHandler<DataEvent>() {
            @Override
            public void handle(DataEvent event) {
                System.out.println(event.name + " for ConcreteTracker");
                System.out.println("data : " + event.data);
            }
        });

        addEventHandler(Event.UNREGISTER, new IEventHandler() {
            @Override
            public void handle(Event event) {
                System.out.println(event.name + " for ConcreteTracker");
            }
        });

        addEventHandler(Event.APP_START, new IEventHandler() {
            @Override
            public void handle(Event event) {
                System.out.println(event.name + " for ConcreteTracker");
            }
        });
    }

    @Override
    public void stopTracking(Object data) {
        removeEventHandler(Event.UNREGISTER);
        removeEventHandler(Event.APP_START);
        removeEventHandler(DataEvent.LOGIN_WITH_DATA);
    }
}
