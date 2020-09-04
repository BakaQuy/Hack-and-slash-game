package Model;

import java.awt.*;

public abstract class Decor implements Collidable {

	private int posX;
	private int posY;
	private Rectangle hitBox;

	public Decor(int x, int y) {
		this.setPosX(x);
		this.setPosY(y);
		this.hitBox = new Rectangle(this.posX, this.posY, sizeSquare, sizeSquare);
	}

	public int getPosX() {
		return this.posX;
	}

	public void setPosX(int posX) {
		this.posX = posX * sizeSquare; // *50 : en reference a la taille de la
										// map
	}

	public int getPosY() {
		return this.posY;
	}

	public void setPosY(int posY) {
		this.posY = posY * sizeSquare; // *50 : en reference a la taille de la
										// map
	}

	@Override
	public Rectangle getHitbox() {
		return hitBox;
	}

	@Override
	public void setHitbox(int x, int y) {
		this.hitBox.setBounds(x, y, sizeSquare, sizeSquare);
	}

	public void setHitBox(int x, int y, int width, int heigth) {
		this.hitBox.setBounds(x, y, width, heigth);
	}

	@Override
	public boolean collides(Collidable collidable) {
		boolean collision;
		Rectangle box = collidable.getHitbox();
		if (this.hitBox.intersects(box)) {
			collision = true;
		} else {
			collision = false;
		}
		return collision;
	}

	@Override
	public void applyCollisionOn(Collidable collidable) {
		collidable.goBack(this);
	}

	@Override
	public int collidesWith(Collidable collidable) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void goBack(Collidable collidable) {
		int edge = collidesWith(collidable);
		int xTarget = (int) collidable.getHitbox().getX();
		int yTarget = (int) collidable.getHitbox().getY();

		if (edge == 6) {
			posX = xTarget - (sizeSquare - 1);
		} else if (edge == 4) {
			posX = xTarget + (sizeSquare - 1);
		} else if (edge == 2) {
			posY = yTarget - (sizeSquare - 1);
		} else if (edge == 8) {
			posY = yTarget + (sizeSquare - 1);
		}
	}

	@Override
	public void getDamageFromMonster(int damage) {
		// TODO Auto-generated method stub

	}

	@Override
	public void getDamageFromPlayer(int damage) {
		// TODO Auto-generated method stub

	}
}
