package com.scoppia.bolla.client;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.dom.client.Style.BorderStyle;
import com.google.gwt.dom.client.Style.Position;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.HTML;

public class Bubble  extends HTML {
	private int current_y;
	private int current_x;

	private String[] colors = { "red", "orange", "magenta", "yellow" };
	
	public Bubble(int size, int posx, int posy) {
		String color = colors[ (int)(Math.random() * 10) % colors.length ] ;
		this.getElement().getStyle().setWidth(size, Unit.PX);
		this.getElement().getStyle().setHeight(size, Unit.PX);
		this.getElement().getStyle().setPosition(Position.ABSOLUTE);
		this.getElement().getStyle().setBackgroundColor(color);
		this.getElement().getStyle().setOpacity(0.7);
		this.getElement().getStyle().setBorderColor("green");
		this.getElement().getStyle().setBorderWidth(2, Unit.PX);
		this.getElement().getStyle().setBorderStyle(BorderStyle.SOLID);
		this.getElement().getStyle().setProperty("borderRadius", 50, Unit.PCT);

		setPos(posx,posy);
	}

	public void setPos(int x, int y) {
		this.current_x = x;
		this.current_y = y;
		this.getElement().getStyle().setBottom(y, Unit.PX);
		this.getElement().getStyle().setLeft(x, Unit.PX);		

		GWT.log("pos: " + x + "  " + y);

	}

	public void moveBy(int x, int y) {
		setPos(current_x+x, current_y+y);
	}

	public int getPositionY() {
		return current_y;
	}

}