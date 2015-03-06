package com.nana.test.struct.jobs;

import org.eclipse.jdt.annotation.NonNull;

import com.nana.test.struct.events.IEvent;

public interface IJob extends Runnable {
	public void pushEvent(@NonNull final IEvent event);
}
