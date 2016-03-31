package com.mycompany.events.experimental.trackers;

import com.mycompany.events.experimental.events.EventDispatcher;
import com.mycompany.events.experimental.events.IEventDispatcher;
import com.mycompany.events.experimental.events.IEventHandler;
import com.mycompany.events.experimental.events.Event;


import java.util.HashMap;

/**
 * Created by sliubetskyi on 3/30/16.
 */
public abstract class BaseTrackerEventsDispatcher extends EventDispatcher implements ITracker {
    @Override
    public final void startTracking(Object data) {
        init(data);
        subscribeForEvents();
    }

    public abstract void subscribeForEvents();
    public abstract void init(Object data);

}
