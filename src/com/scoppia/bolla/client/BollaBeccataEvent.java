package com.scoppia.bolla.client;

import com.google.web.bindery.event.shared.Event;

public class BollaBeccataEvent extends Event<BollaBeccataEvent.Handler> {
	
	Bubble bubble;
	
	public BollaBeccataEvent(Bubble bubble){
		this.bubble=bubble;
	}
	
	public interface Handler{
		public void onBubbleBeccata(BollaBeccataEvent be);
	}
	
	public static final Type<BollaBeccataEvent.Handler> TYPE =new Type<>();
	@Override
	public com.google.web.bindery.event.shared.Event.Type<BollaBeccataEvent.Handler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(BollaBeccataEvent.Handler handler) {
		handler.onBubbleBeccata(this);
	}

}
