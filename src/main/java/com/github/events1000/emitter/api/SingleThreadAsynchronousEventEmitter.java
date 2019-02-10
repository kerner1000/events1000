package com.github.events1000.emitter.api;

import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.github.events1000.api.Event;
import com.github.events1000.listener.api.AsynchronousEventListener;

public class SingleThreadAsynchronousEventEmitter extends AbstractEventEmitter<AsynchronousEventListener> implements AsynchronousEventEmitter {

	private static final ExecutorService exe = Executors.newSingleThreadExecutor();

	public SingleThreadAsynchronousEventEmitter() {

	}

	@Override
	public synchronized void emit(final Event event) {

		final Queue<AsynchronousEventListener> queue = getListeners().get(event.getTopic());
		if(queue != null) {
			for(final AsynchronousEventListener l : queue) {
				exe.submit(() -> l.visit(event));
			}
		}
	}

	@Override
	public void stop() {

		exe.shutdown();
	}
}
