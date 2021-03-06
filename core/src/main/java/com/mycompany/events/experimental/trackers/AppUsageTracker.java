package com.mycompany.events.experimental.trackers;

import com.mycompany.events.experimental.Context;

/**
 * Created by sliubetskyi on 3/30/16.
 */
public class AppUsageTracker implements ITracker {

    private static volatile AppUsageTracker instance;

    protected AppUsageTracker() {
    }

    public static AppUsageTracker getInstance() {
        if (instance == null) {
            synchronized (AppUsageTracker.class) {
                if(instance == null) {
                    instance = new AppUsageTracker();
                }
            }
        }
        return instance;
    }

    @Override
    public void init(Object data) {
        for (ITracker tracker : Context.getInstance().getTrackers()) {
            tracker.init(data);
        }
    }

    @Override
    public void stop(Object data) {
        for (ITracker tracker : Context.getInstance().getTrackers()) {
            tracker.stop(data);
        }
    }
}
