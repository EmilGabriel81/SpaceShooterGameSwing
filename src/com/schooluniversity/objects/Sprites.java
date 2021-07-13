package com.schooluniversity.objects;

import java.awt.Image;

public abstract class Sprites {

	private Image image;
	private boolean dead;
	protected int x;
	protected int y;
	protected int xDir;
	
	public abstract void move();
	
	public Sprites() {
		this.dead = false;
		
	}
	
	public void kill() {
		// the sprite dies
		this.dead = true;
	}

	public Image getImage() {
		return this.image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public boolean isDead() {
		return this.dead;
	}

	public void setDead(boolean dead) {
		this.dead = dead;
	}

	public int getX() {
		return this.x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return this.y;
	}

	public void setY(int y) {
		this.y = y;
	}

//	public int getxDir() {
//		return xDir;
//	}
//
//	public void setxDir(int xDir) {
//		this.xDir = xDir;
//	}
	
}
