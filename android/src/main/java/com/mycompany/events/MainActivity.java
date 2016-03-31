package com.mycompany.events;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.mycompany.events.experimental.Context;
import com.mycompany.events.experimental.events.DataEvent;
import com.mycompany.events.experimental.events.Event;
import com.mycompany.events.experimental.trackers.AppUsageTracker;

public class MainActivity extends Activity {
    private CounterStore counterStore = new CounterStore();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        AppUsageTracker.getInstance().startTracking(new Object());

        final TextView counterTextView = (TextView) findViewById(R.id.counterTextView);
        final Button counterButton = (Button) findViewById(R.id.counterButton);


        counterButton.setOnClickListener((view) -> {
            counterStore.add(1);
            Context.getInstance().dispatchEvent(new Event(Event.APP_START));
            Context.getInstance().dispatchEvent(new Event(Event.LOGIN));
            Context.getInstance().dispatchEvent(new Event(Event.REGISTER));
            Context.getInstance().dispatchEvent(new DataEvent(DataEvent.LOGIN_WITH_DATA, new Object()));
            Context.getInstance().dispatchEvent(new DataEvent(DataEvent.UNREGISTER_WITH_DATA, new Object()));
            counterTextView.setText("Click Nr. " + counterStore.get());
            AppUsageTracker.getInstance().stopTracking(null);
        });
    }
}
