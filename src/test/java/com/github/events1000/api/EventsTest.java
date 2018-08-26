package com.github.events1000.api;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.github.events1000.listener.impl.CountingSynchonousEventListener;

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
	CountingSynchonousEventListener listener = new CountingSynchonousEventListener(EventTopic.get("test"));
	Events.getInstance().registerListener(listener);
	Events.getInstance().emit(new SimpleSynchronousEvent(EventTopic.get("test")));
	assertThat(listener.getCount(), is(1L));
	assertThat(Events.getInstance().getHistory().size(), is(1));
	Event e = Events.getInstance().getHistory().get(0);
	assertThat(e.getTopic().getName(), is("test"));
    }

}
