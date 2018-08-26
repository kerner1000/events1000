package com.github.events1000.impl;

import java.util.Objects;

import com.github.events1000.api.EventTopic;

public class SimpleEventTopic implements EventTopic {

    @Override
    public int hashCode() {
	return Objects.hash(getName(), getParent());
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj) {
	    return true;
	}
	if (obj == null) {
	    return false;
	}
	if (!(obj instanceof SimpleEventTopic)) {
	    return false;
	}
	SimpleEventTopic other = (SimpleEventTopic) obj;
	return Objects.equals(this.name, other.name) && Objects.equals(this.parent, other.parent);
    }

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
