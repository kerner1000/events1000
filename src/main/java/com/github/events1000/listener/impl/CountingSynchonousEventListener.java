package com.github.events1000.listener.impl;

import com.github.events1000.api.Event;
import com.github.events1000.listener.api.AbstractEventListener;
import com.github.events1000.listener.api.SynchronousEventListener;

public class CountingSynchonousEventListener extends AbstractEventListener implements SynchronousEventListener {

    private long cnt = 0;

    @Override
    public synchronized boolean visit(Event e) {
	cnt++;
	return false;
    }

    public long getCount() {
	return cnt;
    }

}
