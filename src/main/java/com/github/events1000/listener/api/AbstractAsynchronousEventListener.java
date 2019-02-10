package com.github.events1000.listener.api;

import com.github.events1000.api.EventTopic;

public abstract class AbstractAsynchronousEventListener extends AbstractEventListener implements AsynchronousEventListener {

	public AbstractAsynchronousEventListener(final EventTopic topic) {

		super(topic);
	}
}
