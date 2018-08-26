package com.github.events1000.api;

import java.util.UUID;

public class AbstractEvent implements Event {

    private final UUID uuid;

    private final EventTopic topic;

    public UUID getUUID() {
	return uuid;
    }

    public EventTopic getTopic() {
	return topic;
    }

    AbstractEvent(UUID uuid, EventTopic topic) {
	super();
	this.uuid = uuid;
	this.topic = topic;
    }

    public AbstractEvent(EventTopic topic) {
	this(UUID.randomUUID(), topic);
    }

}
