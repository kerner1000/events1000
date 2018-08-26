package com.github.events1000.impl;

import com.github.events1000.api.EventTopic;

public class SimpleEventTopic implements EventTopic {

    private final String name;

    private final EventTopic parent;

    public SimpleEventTopic(final String name, EventTopic parent) {
	super();
	this.name = name;
	this.parent = parent;
    }

    public SimpleEventTopic(final String name) {
	this(name, null);
    }

    @Override
    public String getName() {
	return name;
    }

    @Override
    public EventTopic getParent() {
	return parent;
    }

}
