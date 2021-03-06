package concurrent;

import game.Lobby;
import graphics.LobbyFrame;
import network.NetworkManager;

public class LobbyRefresher extends Thread {

	private boolean stopRequested;
	
	public LobbyRefresher() {
		stopRequested = false;
	}
	
	public void requestStop() {
		stopRequested = true;
	}
	
	@Override
	public void run() {
		while(!stopRequested) {			
			NetworkManager.getInstance().updateLobby(Lobby.currentLobby.name);
			LobbyFrame.getInstance().updateLobby();
		
			try {
				Thread.sleep(400);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
