package com.github.events1000.impl;

import com.github.events1000.api.EventTopic;

public class SimpleEventTopic implements EventTopic {

    private final String name;

    private EventTopic parent;

    public SimpleEventTopic(final String name) {
	super();
	this.name = name;
    }

    @Override
    public String getName() {
	return name;
    }

    @Override
    public EventTopic getParent() {
	return parent;
    }

    public void setParent(final EventTopic parent) {
	this.parent = parent;
    }

}
