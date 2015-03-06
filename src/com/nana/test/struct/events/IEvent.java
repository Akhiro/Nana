package com.nana.test.struct.events;

import java.util.Date;

import org.eclipse.jdt.annotation.NonNull;

import com.nana.test.impl.events.EventTypeEnum;

public interface IEvent {
	public @NonNull EventTypeEnum getEventType();
	public @NonNull Date getDateOfIssue();
}
