package com.mycompany.events.experimental.trackers;

/**
 * Created by sliubetskyi on 3/30/16.
 */
public interface ITracker {
    public void startTracking(Object data);
    public void stopTracking(Object data);
}
