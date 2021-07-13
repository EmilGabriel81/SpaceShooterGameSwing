package com.schooluniversity.objects;

import javax.swing.ImageIcon;

import com.schooluniversity.images.ImageCreator;
import com.schooluniversity.images.Images;
import com.schooluniversity.variables.ConstantVariables;

public class Bullet extends Sprites{

	
	public Bullet() {
		
	}
	public Bullet(int x , int y) {
		this.x = x;
		this.y = y;	
		init();
		
	}
	
	private void init() {
		ImageIcon imageIcon = ImageCreator.createImg(Images.BULLET);
		setImage(imageIcon.getImage());
		setX(x + ConstantVariables.PLAYERSHIP_WIDTH/2);
		setY(y);
		
	}



	@Override
	public void move() {
		
		this.y -= ConstantVariables.BULLETSPEED;
		if(this.y < 0 ) this.kill();
	}

}
