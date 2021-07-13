package com.schooluniversity.objects;

import javax.swing.ImageIcon;

import com.schooluniversity.images.ImageCreator;
import com.schooluniversity.images.Images;
import com.schooluniversity.variables.ConstantVariables;

public class Bomb extends Sprites{

	
	public Bomb(int x, int y) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
		init();
	}
	
	private void init() {
		// TODO Auto-generated method stub
		ImageIcon imageIcon = ImageCreator.createImg(Images.BOMB);
		setImage(imageIcon.getImage());
		
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		this.y += 2;
		if(this.getY() >= ConstantVariables.BOARD_HEIGHT -ConstantVariables.BOMBHEIGHT) kill();
		//or y >=
	}

}
