package com.schooluniversity.objects;

import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

import com.schooluniversity.images.ImageCreator;
import com.schooluniversity.images.Images;
import com.schooluniversity.variables.ConstantVariables;

public class PlayerShip extends Sprites {

	public PlayerShip() {
		
		init();

	}
	
	
	private void init() {
		
		ImageIcon imageIcon = ImageCreator.createImg(Images.PLAYERSHIP);
		setImage(imageIcon.getImage());
		
		int xStart = ConstantVariables.BOARD_WIDTH/2-ConstantVariables.PLAYERSHIP_WIDTH/2;
		int yStart = ConstantVariables.BOARD_HEIGHT-100;
		setX(xStart);
		setY(yStart);
		
	}


	@Override
	public void move() {
		
		x += xDir;
		//add constraints
		//if(this.getX()<0+ConstantVariables.PLAYERSHIP_WIDTH) this.x = 0+ConstantVariables.PLAYERSHIP_WIDTH;
		if(x < ConstantVariables.PLAYERSHIP_WIDTH) x = ConstantVariables.PLAYERSHIP_WIDTH;
		if(x > ConstantVariables.BOARD_WIDTH - 2*ConstantVariables.PLAYERSHIP_WIDTH) x = ConstantVariables.BOARD_WIDTH - 2*ConstantVariables.PLAYERSHIP_WIDTH;
	}


	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_LEFT)  xDir =- 2;
		if(key == KeyEvent.VK_RIGHT) xDir = 2;
	}


	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_LEFT)  xDir = 0;
		if(key == KeyEvent.VK_RIGHT) xDir = 0;
	}

}
