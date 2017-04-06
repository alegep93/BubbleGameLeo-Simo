package com.scoppia.bolla.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.RepeatingCommand;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class ScoppiaLaBollaProject implements EntryPoint {

	GreetingServiceAsync servizio = GWT.create(GreetingService.class);

	int i = 0;

	@Override
	public void onModuleLoad() {
		servizio.salvaPunteggio("Leo", 11800, new AsyncCallback<Void>() {

			@Override
			public void onSuccess(Void result) {
			}

			@Override
			public void onFailure(Throwable caught) {
			}
		});

		SimpleEventBus bus = new SimpleEventBus();
		
		Board board = new Board(bus);
		board.go.setVisible(false);
		board.btnRitenta.setVisible(false);
		
		ScoreBoard score = new ScoreBoard(bus);
		score.setScore(0);
		score.setVite(20);
		
		DockLayoutPanel dlp = new DockLayoutPanel(Unit.PX);
		dlp.addNorth(score, 100);
		dlp.addSouth(new HTML(), 100);
		dlp.addEast(new HTML(), 100);
		dlp.addWest(new HTML(), 100);
		dlp.add(board);
		//dlp.add(go);

		RootLayoutPanel.get().add(dlp);

		// muove le bubble
		Scheduler.get().scheduleFixedDelay(new RepeatingCommand() {
			@Override
			public boolean execute() {
				if (board.count >= 20) {
					board.removeAllBubble();
					board.go.setVisible(true);
					board.punteggio.setVisible(true);
					board.btnRitenta.setVisible(true);
					board.punteggio.setHTML("Hai fatto: " + score.getScore() + " punti");
					score.setVisible(false);
					return false;
				} else {
					board.move(score);
					score.setVisible(true);
					return true;
				}
			}
		}, 80);

		// fa nascere nuove bubble
		Scheduler.get().scheduleFixedDelay(new RepeatingCommand() {
			@Override
			public boolean execute() {
				if (board.count >= 20) {
					return false;
				} else {
					if (board.size() < 200) {
						Bubble bubble = new Bubble((int) ((Math.random() * 55)+20), (int) (Math.random() * (board.getOffsetWidth()-55)), 0);
						board.addBubble(bubble);
					}
					return true;
				}
			}
		}, 200);

	}

}
