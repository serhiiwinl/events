package com.mycompany.events.experimental.trackers;

import com.mycompany.events.experimental.events.EventDispatcher;

/**
 * Created by sliubetskyi on 3/30/16.
 */
public abstract class BaseTrackerEventsDispatcher extends EventDispatcher implements ITracker {
    @Override
    public final void init(Object data) {
        initTracker(data);
        subscribeForEvents();
    }

    public abstract void subscribeForEvents();
    public abstract void initTracker(Object data);

}
