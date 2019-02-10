package com.github.events1000.api;

import java.util.UUID;

public class SimpleAsynchronousEvent extends AbstractEvent implements AsynchronousEvent {

	public SimpleAsynchronousEvent(final EventTopic topic) {

		super(topic);
	}

	public SimpleAsynchronousEvent(final UUID uuid, final EventTopic topic) {

		super(uuid, topic);
	}
}
