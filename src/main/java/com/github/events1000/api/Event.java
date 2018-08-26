package com.github.events1000.api;

import java.util.UUID;

public interface Event {

    UUID getUUID();

    EventTopic getTopic();

}
