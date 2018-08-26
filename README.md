# events1000
A Lightweight Event System.

[![Build Status](https://travis-ci.org/kerner1000/events1000.svg?branch=master)](https://travis-ci.org/kerner1000/events1000)
[![codecov](https://codecov.io/gh/kerner1000/events/branch/master/graph/badge.svg)](https://codecov.io/gh/kerner1000/events1000)

# Features
## Events can be visited or consumed
## Asynchronous, Synchronous and UI Events
## Event Topics may have (more generic) parent Topis


# Usage
## Creating Objects
```
	EventListener listener = new SynchronousEventListener() {

	    @Override
	    public EventTopic getTopic() {
		return EventTopic.get("test");
	    }

	    @Override
	    public boolean visit(Event e) {
		System.err.println("Hey there!");
		return false;
	    }
	};
	Event event = new SynchronousEvent() {

	    @Override
	    public UUID getUUID() {
		return UUID.randomUUID();
	    }

	    @Override
	    public EventTopic getTopic() {
		return EventTopic.get("test");
	    }
	};
```
## Register Listener
```
Events.getInstance().registerListener(listener);
```

## Emit an Event
```
Events.getInstance().emit(event);
```
## Output
```
Hey there!
```
