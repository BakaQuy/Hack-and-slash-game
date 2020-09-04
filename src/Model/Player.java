package Model;

public class Player extends Character {

	private boolean readyToAttack = true;

	public Player(int x, int y, int speed, int hp, Game game) {
		super(x,y,speed,hp,game);
	}
	
	public void stop() {
		if (isMovingRight() == false && isMovingLeft() == false && isMovingUp() == false && isMovingDown() == false) {
			move(0, 0);
		} else if (isMovingRight() == false && isMovingLeft() == true) {
			move(-1, 0);
		} else if (isMovingRight() == true && isMovingLeft() == false) {
			move(1, 0);
		} else if (isMovingUp() == false && isMovingDown() == true) {
			move(0, 1);
		} else if (isMovingUp() == true && isMovingDown() == false) {
			move(0, -1);
		}
	}

	public boolean isReadyToAttack() {
		return readyToAttack;
	}

	public void setReadyToAttack(boolean readyToAttack) {
		this.readyToAttack = readyToAttack;
	}
	
	public void update(){
		super.update();
		move(speedX,speedY);
	}

	@Override
	public void applyCollisionOn(Collidable collidable) {
		
	}
	
	public void getDamageFromMonster(int damage) {
		getDamage(1);
	}

	@Override
	public void getDamageFromPlayer(int damage) {
		
	}
}