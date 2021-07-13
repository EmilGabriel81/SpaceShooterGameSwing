package com.schooluniversity.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameCore implements ActionListener{

	private GameMainPanel gamePanel;
	
	 public GameCore(GameMainPanel gamePanel) {
		
		this.gamePanel = gamePanel;
	}
	 
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		this.gamePanel.render();
	}

}
