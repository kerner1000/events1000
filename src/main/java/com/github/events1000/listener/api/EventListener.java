package com.github.events1000.listener.api;

import com.github.events1000.api.Event;

public interface EventListener {

    /**
     * 
     * @param e
     *            the event to visit
     * @return {code true} if the event was consumed, {@code false} otherwise
     */
    boolean visit(Event e);

}
