package com.github.events1000.emitter.api;

import com.github.events1000.api.Event;
import com.github.events1000.listener.api.EventListener;

public interface EventEmitter<L extends EventListener> {

    void registerEventListener(L listener);

    void emit(Event event);

}
