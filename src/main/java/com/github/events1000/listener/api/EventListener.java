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

	void visit(Event e);
}
