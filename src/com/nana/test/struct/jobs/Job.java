package com.nana.test.struct.jobs;

import org.eclipse.jdt.annotation.NonNull;

import com.nana.test.struct.events.IEvent;

public abstract class Job implements IJob {

	public Job() { super(); }

	@Override
	public void pushEvent(@NonNull final IEvent event) {
		//TODO Seb : Ajouter la gestion du Manager d'event
	}
}
