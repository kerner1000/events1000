package com.github.events1000.emitter.api;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import com.github.events1000.api.Event;
import com.github.events1000.api.EventTopic;
import com.github.events1000.listener.api.EventListener;

public abstract class AbstractEventEmitter<L extends EventListener> implements EventEmitter<L> {

    private final Map<EventTopic, Queue<L>> listeners;

    public AbstractEventEmitter() {
	this.listeners = new LinkedHashMap<>();
    }

    @Override
    public synchronized void registerEventListener(L listener) {
	Queue<L> queue = listeners.get(listener.getTopic());
	if (queue == null) {
	    queue = new LinkedList<>();
	    listeners.put(listener.getTopic(), queue);
	}
	queue.add(listener);
    }

    @Override
    public synchronized void emit(Event event) {
	Queue<L> queue = listeners.get(event.getTopic());
	if (queue != null) {
	    for (L l : queue) {
	    if (l.visit(event))
		    break;
	    }
	}
    }
}
