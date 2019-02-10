package com.github.events1000.listener.api;

import com.github.events1000.api.EventTopic;

public abstract class AbstractSynchronousEventListener extends AbstractEventListener implements SynchronousEventListener {

	public AbstractSynchronousEventListener(final EventTopic topic) {

		super(topic);
	}
}
