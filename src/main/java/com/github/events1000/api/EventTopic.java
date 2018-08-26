package com.github.events1000.api;

import com.github.events1000.impl.SimpleEventTopic;

public interface EventTopic {

    String getName();

    EventTopic getParent();

    static EventTopic get(String name) {
	return new SimpleEventTopic(name);
    }

}
