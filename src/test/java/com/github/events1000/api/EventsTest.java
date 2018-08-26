package com.github.events1000.api;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.UUID;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.github.events1000.listener.api.EventListener;
import com.github.events1000.listener.api.SynchronousEventListener;

public class EventsTest {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test() {
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
	Events.getInstance().registerListener(listener);
	Events.getInstance().emit(event);
	assertThat(Events.getInstance().getHistory().size(), is(1));
	Event e = Events.getInstance().getHistory().get(0);
	assertThat(e.getTopic().getName(), is("test"));
    }

}
