package com.github.events1000.emitter.api;

import java.util.Queue;

import com.github.events1000.api.Event;
import com.github.events1000.listener.api.SynchronousEventListener;

public class SimpleSynchronousEventEmitter extends AbstractEventEmitter<SynchronousEventListener> implements SynchronousEventEmitter {

	public SimpleSynchronousEventEmitter() {

	}

	@Override
	public synchronized void emit(final Event event) {

		final Queue<SynchronousEventListener> queue = getListeners().get(event.getTopic());
		if(queue != null) {
			for(final SynchronousEventListener l : queue) {
				l.visit(event);
			}
		}
	}

	@Override
	public void stop() {

		// no need
	}
}
