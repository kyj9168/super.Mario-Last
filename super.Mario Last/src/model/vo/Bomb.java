package model.vo;

import java.awt.Image;
import java.util.Random;

public class Bomb {

	private Image img;

	private int x;

	private int y;

	private int w;

	private int h;

	int dy;

	int width, height;

	private boolean isDead = false;

	public Bomb(Image imgBomb, int width, int height) {
		this.width = width;
		this.height = height;

		setImg(imgBomb.getScaledInstance(50, 50, Image.SCALE_SMOOTH));

		setW(50);

		setH(50);

		Random rnd3 = new Random();

		setX(rnd3.nextInt(width - getW() * 2) + getW());
		setY(getH());

		dy = +rnd3.nextInt(15) + 1;
	}

	public void move() {
		setY(getY() + dy);

		if (getY() > height + getH()) {
			setDead(true);
		}
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getW() {
		return w;
	}

	public void setW(int w) {
		this.w = w;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}

	public boolean isDead() {
		return isDead;
	}

	public void setDead(boolean isDead) {
		this.isDead = isDead;
	}

	public Image getImg() {
		return img;
	}

	public void setImg(Image img) {
		this.img = img;
	}
}
