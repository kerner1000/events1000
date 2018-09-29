package com.github.events1000.listener.api;

import com.github.events1000.api.Event;
import com.github.events1000.api.EventTopic;

public interface EventListener {

	/**
	 * Gets the {@link EventTopic} for this listener.
	 * 
	 * @return the {@link EventTopic} for this listener
	 */
	EventTopic getTopic();

	/**
	 * Visits an event. Returns {@code true}, if the event was consumed, {@code false} otherwise.
	 *
	 * @param e
	 *            the event to visit
	 * @return {code true} if the event was consumed, {@code false} otherwise
	 */
	boolean visit(Event e);
}
