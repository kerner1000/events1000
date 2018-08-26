package com.github.events1000.api;

public interface TransportingEvent<T> extends Event {

    T getData();

}
