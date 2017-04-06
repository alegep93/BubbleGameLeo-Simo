package com.scoppia.bolla.client;

import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.user.client.ui.HTML;

public class ScoreBoard extends HTML {
	private int score;
	private int vite;
	
	public int getVite() {
		return vite;
	}

	public void setVite(int vite) {
		this.vite = vite;
		setHTML("" + vite + " vite" + " - " + score + " points");
	}

	SimpleEventBus bus;
	public ScoreBoard(SimpleEventBus bus){
		this.bus = bus;
		bus.addHandler(BollaBeccataEvent.TYPE, b->setScore(getScore()+10));
	}
	
	public int getScore() {
		return this.score;
	}

	public void setScore(int score) {
		this.score = score;
		setHTML("" + vite + " vite" + " - " + score + " points");
	}

}
