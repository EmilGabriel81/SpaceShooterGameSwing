package com.schooluniversity.game;

import java.awt.HeadlessException;

import javax.swing.JFrame;

import com.schooluniversity.variables.ConstantVariables;

public class GameMainWindow extends JFrame{

	
	
	public GameMainWindow(){
	
		 initGui();
	}

	private void initGui() {
		
		add(new GameMainPanel());
		setTitle(ConstantVariables.TITLE);
		pack();//JFrame will be as large as the JPanel(GameMainPanel)
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		//setSize(ConstantVariables.BOARD_WIDTH, ConstantVariables.BOARD_HEIGHT);
		
	}

	
	
}
