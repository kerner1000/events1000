package com.github.events1000.api;

import java.util.UUID;

public class AbstractTransportingEvent<T> extends AbstractEvent implements TransportingEvent<T> {

    private final T data;

    AbstractTransportingEvent(UUID uuid, EventTopic topic, T data) {
	super(uuid, topic);
	this.data = data;
    }

    public AbstractTransportingEvent(EventTopic topic, T data) {
	super(topic);
	this.data = data;
    }

    @Override
    public T getData() {
	return data;
    }

}
