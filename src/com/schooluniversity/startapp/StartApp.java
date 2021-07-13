package com.schooluniversity.startapp;

import java.awt.EventQueue;

import com.schooluniversity.game.GameMainWindow;

public class StartApp {
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				new GameMainWindow();
			}
		});
	}

}
