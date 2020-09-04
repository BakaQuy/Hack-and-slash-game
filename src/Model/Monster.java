package Model;

import java.awt.*;
import java.util.Random;

public class Monster extends Character {

	private Rectangle fieldOfView;
	private int vision = 100;
	protected Random random;
	private final int damage = 1;

	public Monster(int x, int y, int speed, int hp, Game game) {
		super(x, y, speed, hp, game);
		this.fieldOfView = new Rectangle(posX - vision, posY - vision, 3 * vision, 3 * vision);
		random = new Random();
	}

	public Rectangle getFieldOfView() {
		return fieldOfView;
	}

	public void setFieldOfView(int x, int y) {
		this.fieldOfView.setBounds(x - vision, y - vision, 3 * vision, 3 * vision);
	}

	public void getDamageFromPlayer(int damage) {
		getDamage(10);
	}
	
	public void getDamageFromMonster(int damage) {
		
	}

	@Override
	public void applyCollisionOn(Collidable collidable) {
		collidable.getDamageFromMonster(damage);
		collidable.goBack(this);
	}

	public void update() {
		super.update();
		setFieldOfView(this.posX, this.posY);
		lookForPlayer(this.getGame());
	}

	public void lookForPlayer(Game game) {
		Player target = game.getPlayers().get(0);
		if (this.fieldOfView.intersects(target.getHitbox())) {
			huntTarget(target);
		} else {
			patrol();
		}
	}

	private void huntTarget(Player target) {
		int x = target.getPosX();
		int y = target.getPosY();
		int dx = 0;
		int dy = 0;

		if (posX <= x - sizeSquare) {
			dx = 1;
		} else if (posY <= y - sizeSquare) {
			dy = 1;
		} else if (posX >= x + sizeSquare) {
			dx = -1;
		} else if (posY >= y + sizeSquare) {
			dy = -1;
		} else if (posX == x - (sizeSquare - 1) && posY < y) {
			dy = 1;
		} else if (posX == x + (sizeSquare - 1) && posY < y) {
			dy = 1;
		} else if (posX == x - (sizeSquare - 1) && posY > y) {
			dy = -1;
		} else if (posX == x + (sizeSquare - 1) && posY > y) {
			dy = -1;
		} else if (posY == y - (sizeSquare - 1) && posX < x) {
			dx = 1;
		} else if (posY == y + (sizeSquare - 1) && posX < x) {
			dx = 1;
		} else if (posY == y - (sizeSquare - 1) && posX > x) {
			dx = -1;
		} else if (posY == y + (sizeSquare - 1) && posX > x) {
			dx = -1;
		}
		move(dx, dy);
	}

	private void patrol() {
		if (random.nextInt(10) == 7) {
			dir = random.nextInt(4);
		}
		if (dir == 2) {
			move(1, 0);
		} else if (dir == 0) {
			move(-1, 0);
		} else if (dir == 3) {
			move(0, 1);
		} else if (dir == 1) {
			move(0, -1);
		} else if (dir == 4) {
			move(0, 0);
		}
	}
}
