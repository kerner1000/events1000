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

	final EventListener listener = new SynchronousEventListener() {

	    @Override
	    public void visit(final Event e) {

		System.err.println("Hey there!");
	    }
	};
	final Event event = new SynchronousEvent() {

	    @Override
	    public UUID getUUID() {

		return UUID.randomUUID();
	    }

	    @Override
	    public EventTopic getTopic() {

		return EventTopic.get("test");
	    }

	    @Override
	    public void consume(final Object consumer) {

		// TODO Auto-generated method stub
	    }

	    @Override
	    public Object getConsumer() {

		// TODO Auto-generated method stub
		return null;
	    }
	};
	Events.getInstance().registerListener(EventTopic.get("test"), listener);
	Events.getInstance().emit(event);
	assertThat(Events.getInstance().getHistory().size(), is(1));
	final Event e = Events.getInstance().getHistory().get(0);
	assertThat(e.getTopic().getName(), is("test"));
    }
}
