/*
 * Copyright (c) 2015 - Seb&Lulu
 * Author(s) : jsdidierlaurent
 * Date : 15 mars 2015
 */
package com.nana.core.server.http;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

import com.nana.core.trigger.TriggerHTTP;
import com.nana.utils.pattern.observer.IObservable;

public class HTTPHandler extends AbstractHandler implements IObservable<TriggerHTTP>{
	private TriggerHTTP _trigger;

	public HTTPHandler(@NonNull final TriggerHTTP trigger) {
		register(trigger);
	}

	/** Quand l'adresse est call on previent le trigger **/
	@Override
	public void handle(final String target, final Request baseRequest, final HttpServletRequest request, final HttpServletResponse response ) throws IOException, ServletException {
		response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);

		notifyObservers();

		//TODO Seb : Gérer un type de State pour stocker le résultat si besoin **/

		baseRequest.setHandled(true);
	}

	@Override
	public void register(@NonNull final TriggerHTTP observer) {
		_trigger = observer;
	}

	@Override
	public void notifyObservers() {
		_trigger.notif();
	}

}
