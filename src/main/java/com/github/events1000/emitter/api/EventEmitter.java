package com.github.events1000.emitter.api;

import com.github.events1000.api.Event;
import com.github.events1000.api.EventTopic;
import com.github.events1000.listener.api.EventListener;

public interface EventEmitter<L extends EventListener> {

    void emit(Event event);

    void stop();

    void registerEventListener(EventTopic topic, L listener);

    void unregisterEventListener(L listener);

}
