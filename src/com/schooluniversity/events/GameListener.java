package com.schooluniversity.events;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import com.schooluniversity.game.GameMainPanel;

public class GameListener extends KeyAdapter {

	private GameMainPanel gameBoard;
	
    public GameListener(GameMainPanel gameBoard) {
		this.gameBoard = gameBoard;
	}
    
    
	@Override
	public void keyPressed(KeyEvent e) {
		super.keyPressed(e);
	this.gameBoard.keyPressed(e);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		super.keyReleased(e);
		this.gameBoard.keyReleased(e);
	}
	

}
