package com.github.events1000.listener.api;

import com.github.events1000.api.Event;
import com.github.events1000.api.EventTopic;

public abstract class AbstractEventListener implements EventListener {

	private final EventTopic topic;

	public AbstractEventListener(final EventTopic topic) {

		super();
		this.topic = topic;
	}

	@Override
	public final synchronized void visit(final Event e) {

		if((e.getConsumer() == null) && topicsMatching(getTopic(), e.getTopic()))
			handle(e);
	}

	public static boolean topicsMatching(final EventTopic t1, final EventTopic t2) {

		EventTopic t11 = t2;
		EventTopic t22 = t2;
		while(t11 != null) {
			while(t22 != null) {
				if(t11.equals(t22))
					return true;
				t22 = t2.getParent();
			}
			t11 = t1.getParent();
		}
		return false;
	}

	protected abstract void handle(Event e);

	@Override
	public EventTopic getTopic() {

		return topic;
	}
}
