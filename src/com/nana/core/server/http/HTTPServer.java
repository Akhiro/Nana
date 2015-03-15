/*
 * Copyright (c) 2015 - Seb&Lulu
 * Author(s) : jsdidierlaurent
 * Date : 15 mars 2015
 */
package com.nana.core.server.http;

import java.io.Closeable;
import java.io.IOException;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.server.handler.ContextHandlerCollection;
import org.eclipse.jetty.util.thread.QueuedThreadPool;
import org.eclipse.jetty.util.thread.ScheduledExecutorScheduler;


public class HTTPServer extends Thread implements Closeable {
	private int port;
	private int idleTimeout;
	private int poolSize;
	private String threadNamePrefix;
	private String threadGroupName;

	@NonNull private final ContextHandlerCollection _contexts = new ContextHandlerCollection();

	private Server _server;

	public HTTPServer() {}

	public int getPort() {
		return port;
	}

	public void setPort(final int port) {
		this.port = port;
	}

	public int getIdleTimeout() {
		return idleTimeout;
	}

	public void setIdleTimeout(final int idleTimeout) {
		this.idleTimeout = idleTimeout;
	}

	public int getPoolSize() {
		return poolSize;
	}

	public void setPoolSize(final int poolSize) {
		this.poolSize = poolSize;
	}

	public String getThreadNamePrefix() {
		return threadNamePrefix;
	}

	public void setThreadNamePrefix(final String threadNamePrefix) {
		this.threadNamePrefix = threadNamePrefix;
	}

	public String getThreadGroupName() {
		return threadGroupName;
	}

	public void setThreadGroupName(final String threadGroupName) {
		this.threadGroupName = threadGroupName;
	}

	public void addContext(@NonNull final String adress, @NonNull final Handler handler ) {
		ContextHandler contextFR = new ContextHandler(adress);
        contextFR.setHandler(handler);

        _contexts.addHandler(contextFR);
	}

	@Override
	public void run() {
		setName(getThreadGroupName());

		/** Thread Pool **/
		QueuedThreadPool threadPool = new QueuedThreadPool();
        threadPool.setMaxThreads(getPoolSize());
        threadPool.setName(getThreadNamePrefix());

        /** Server **/
        _server = new Server(threadPool);
        _server.setDumpAfterStart(false);
        _server.setDumpBeforeStop(false);
        _server.setStopAtShutdown(true);

        /** Server Connection **/
        ServerConnector connector = new ServerConnector(_server);
        connector.setPort(getPort());
        connector.setIdleTimeout(getIdleTimeout());

        _server.addConnector(connector);
        _server.addBean(new ScheduledExecutorScheduler());
        _server.setHandler(_contexts);

        try {
        	/** Lancement du serveur Web **/
        	_server.start();
        	_server.join();

        } catch (Exception e) {
        	//e.printStackTrace();
        } finally {
        	try {
				_server.stop();
			} catch (Exception e) {
				e.printStackTrace();
			}
        }
	}

	@Override
	public void close() throws IOException {
		interrupt();
	}
}
