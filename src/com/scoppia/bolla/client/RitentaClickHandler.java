package com.scoppia.bolla.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;

public class RitentaClickHandler implements ClickHandler {
	ScoppiaLaBollaProject p = new ScoppiaLaBollaProject();

	@Override
	public void onClick(ClickEvent event) {
		p.onModuleLoad();		
	}
	

}
