package com.github.events1000.api;

import java.util.UUID;

public class SimpleSynchronousEvent extends AbstractEvent implements SynchronousEvent {

    SimpleSynchronousEvent(UUID uuid, EventTopic topic) {
	super(uuid, topic);
    }

    public SimpleSynchronousEvent(EventTopic topic) {
	super(topic);
    }

    

}
