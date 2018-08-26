package com.github.events1000.emitter.api;

import java.util.LinkedList;
import java.util.Queue;

import com.github.events1000.api.Event;
import com.github.events1000.listener.api.EventListener;

public abstract class AbstractEventEmitter<L extends EventListener> implements EventEmitter<L> {

    private final Queue<L> listeners;

    public AbstractEventEmitter() {
	this.listeners = new LinkedList<>();
    }

    @Override
    public synchronized void registerEventListener(L listener) {
	listeners.add(listener);
    }

    @Override
    public synchronized void emit(Event event) {
	for (L l : listeners) {
	    if (l.visit(event))
		break;
	}
    }
}
