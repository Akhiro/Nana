package com.nana.api.interfaces;

import org.eclipse.jdt.annotation.NonNull;

public interface IAPISendMessage {
	public IAPIReturns sendMessage(@NonNull final String message);
}
