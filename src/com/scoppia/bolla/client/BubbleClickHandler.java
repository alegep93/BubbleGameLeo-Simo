package com.scoppia.bolla.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.SimpleEventBus;

public class BubbleClickHandler implements ClickHandler {

	Bubble bubble;
	Board board;
	private SimpleEventBus bus;

	public BubbleClickHandler(Bubble bubble, Board board, SimpleEventBus bus) {
		this.bubble = bubble;
		this.board = board;
		this.bus = bus;
	}
	
	@Override
	public void onClick(ClickEvent event) {
		board.removeBubble(bubble);
		bus.fireEvent(new BollaBeccataEvent(bubble));
	}

}
