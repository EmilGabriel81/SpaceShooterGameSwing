package com.schooluniversity.objects;

import javax.swing.ImageIcon;

import com.schooluniversity.images.ImageCreator;
import com.schooluniversity.images.Images;
import com.schooluniversity.variables.ConstantVariables;

public class EnemyShip extends Sprites {

	private boolean visible = true;

	public EnemyShip(int x, int y) {
		this.x = x;
		this.y = y;
		init();
	}

	private void init() {
		ImageIcon imageIcon = ImageCreator.createImg(Images.ENEMY);
		setImage(imageIcon.getImage());
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public void move(int dir) {
		 this.x += dir;
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub

	}

}
