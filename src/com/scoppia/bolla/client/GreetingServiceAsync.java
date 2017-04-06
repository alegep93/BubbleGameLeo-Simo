package com.scoppia.bolla.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface GreetingServiceAsync {
	void greetServer(String input, AsyncCallback<String> callback) throws IllegalArgumentException;

	void salvaPunteggio(String Nome, int punteggio, AsyncCallback<Void> callback);
}
