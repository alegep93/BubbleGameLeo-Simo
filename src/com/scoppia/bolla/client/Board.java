package com.scoppia.bolla.client;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.dom.client.Style.TextAlign;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;

public class Board extends FlowPanel {
	public int count = 0;
	private ScoreBoard sb;
	public HTML go = new HTML("GAME OVER");
	public HTML punteggio = new HTML();
	public HTML btnRitenta = new HTML("");
	List<Bubble> bubbles = new ArrayList<>();
	SimpleEventBus bus;
	
	public Board(SimpleEventBus bus) {
		this.getElement().getStyle().setWidth(100, Unit.PCT);
		this.getElement().getStyle().setHeight(100, Unit.PCT);
		this.setStyleName("sfondo");
		this.getElement().getStyle().setBorderColor("black");
		this.bus=bus;
		this.add(go);
		this.add(punteggio);
		this.add(btnRitenta);
		go.getElement().getStyle().setColor("black");
		go.getElement().getStyle().setFontSize(120, Unit.PX);
		go.getElement().getStyle().setTextAlign(TextAlign.CENTER);
		go.getElement().getStyle().setMarginTop(150, Unit.PX);
		go.setStyleName("gameover");
		
		punteggio.getElement().getStyle().setColor("black");
		punteggio.getElement().getStyle().setFontSize(60, Unit.PX);
		punteggio.getElement().getStyle().setTextAlign(TextAlign.CENTER);
		punteggio.getElement().getStyle().setMarginTop(30, Unit.PX);
		punteggio.setStyleName("punteggio");
		
		btnRitenta.setStyleName("image");
		
	}
	
	public void addBubble(Bubble bubble) {
		bubble.addClickHandler(new BubbleClickHandler(bubble, this, bus));
		bubbles.add(bubble);
		this.add(bubble);
		
	}
	
	public void removeAllBubble(){
		for(Bubble b : bubbles){
			this.remove(b);
		}
		btnRitenta.addClickHandler(new RitentaClickHandler());
	}
	
	public void removeBubble(Bubble bubble) {
		bubbles.remove(bubble);
		this.remove(bubble);
	}

	public int move(ScoreBoard sb) {
		int bh = this.getOffsetHeight();

		for (Bubble b : bubbles) {
			int y = (int) ((Math.random()+50));
			b.moveBy((int) ((Math.random() - 0.5) * 0), y);
			if (b.getPositionY() > bh) {
				this.removeBubble(b);
				count = count +1;
				sb.setVite(sb.getVite()-1);
				
			}
		}return count;
	}

	public int size() {
		return bubbles.size();
	}

}