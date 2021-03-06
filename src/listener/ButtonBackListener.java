package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import game.Lobby;
import graphics.GameFrame;
import graphics.LobbiesFrame;
import graphics.LobbyFrame;
import network.NetworkManager;

public class ButtonBackListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		Thread leaveThread = new Thread(new Runnable() {
			@Override
			public void run() {
				NetworkManager.getInstance().leave();
			}
		});
		leaveThread.start();
		
		LobbyFrame.getInstance().close();
		GameFrame.getInstance().close();
		LobbiesFrame.getInstance().open();
	}
}
