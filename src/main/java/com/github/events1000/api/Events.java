package com.github.events1000.api;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.events1000.emitter.api.AsynchronousEventEmitter;
import com.github.events1000.emitter.api.SingleThreadAsynchronousEventEmitter;
import com.github.events1000.emitter.api.SimpleSynchronousEventEmitter;
import com.github.events1000.emitter.api.SynchronousEventEmitter;
import com.github.events1000.listener.api.AsynchronousEventListener;
import com.github.events1000.listener.api.EventListener;
import com.github.events1000.listener.api.SynchronousEventListener;

public class Events {

	private static final Logger logger = LoggerFactory.getLogger(Events.class);
	public static final int DEFAULT_HISTORY_SIZE = 1000;

	private static class InstanceHolder {

		private static final Events instance = new Events();
	}

	public static Events getInstance() {

		return InstanceHolder.instance;
	}

	private final SynchronousEventEmitter synchronousEventEmitter;
	private final AsynchronousEventEmitter asynchronousEventEmitter;
	private final ArrayList<Event> history;
	private final int historySize;

	private Events() {

		synchronousEventEmitter = new SimpleSynchronousEventEmitter();
		asynchronousEventEmitter = new SingleThreadAsynchronousEventEmitter();
		historySize = DEFAULT_HISTORY_SIZE;
		history = new ArrayList<>(historySize);
	}

	public synchronized void emit(final SynchronousEvent event) {

		synchronousEventEmitter.emit(event);
		trimHistory();
		history.add(event);
	}

	public synchronized void emit(final AsynchronousEvent event) {

		asynchronousEventEmitter.emit(event);
		trimHistory();
		history.add(event);
		// if(logger.isDebugEnabled()) {
		// logger.debug(event + " fired");
		// }
	}

	public synchronized void emit(final Event event) {

		if(event instanceof SynchronousEvent) {
			emit((SynchronousEvent)event);
		} else if(event instanceof AsynchronousEvent) {
			emit((AsynchronousEvent)event);
		} else if(logger.isDebugEnabled()) {
			logger.debug("Unsupported event type " + event.getClass());
		}
	}

	private void trimHistory() {

		if(history.size() >= historySize) {
			history.subList(historySize - 1, history.size()).clear();
		}
	}

	public synchronized void registerListener(final EventListener listener) {

		if(listener instanceof SynchronousEventListener) {
			registerListener((SynchronousEventListener)listener);
		} else if(listener instanceof AsynchronousEventListener) {
			registerListener((AsynchronousEventListener)listener);
		}
	}

	public synchronized void registerListener(final SynchronousEventListener listener) {

		synchronousEventEmitter.registerEventListener(listener);
	}

	public synchronized void registerListener(final AsynchronousEventListener listener) {

		asynchronousEventEmitter.registerEventListener(listener);
	}

	public synchronized List<Event> getHistory() {

		return history;
	}

	public void stop() {

		synchronousEventEmitter.stop();
		asynchronousEventEmitter.stop();
	}
}
