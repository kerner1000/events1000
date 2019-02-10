package com.github.events1000.api;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;

public class AbstractEvent implements Event {

	private final UUID uuid;
	private final EventTopic topic;
	private final AtomicReference<Object> consumer;

	@Override
	public Object getConsumer() {

		return consumer.get();
	}

	@Override
	public void consume(final Object consumer) {

		this.consumer.set(consumer);
	}

	@Override
	public UUID getUUID() {

		return uuid;
	}

	@Override
	public EventTopic getTopic() {

		return topic;
	}

	AbstractEvent(final UUID uuid, final EventTopic topic) {

		super();
		this.uuid = uuid;
		this.topic = topic;
		consumer = new AtomicReference<>(null);
	}

	public AbstractEvent(final EventTopic topic) {

		this(UUID.randomUUID(), topic);
	}
}
