package Model;

import java.awt.*;

public interface Collidable {
	
	public final int sizeSquare = 40;
	
	Rectangle getHitbox();

	void setHitbox(int x, int y);

	boolean collides(Collidable collidable);

	void applyCollisionOn(Collidable collidable);

	int collidesWith(Collidable collidable);

	void getDamageFromMonster(int damage);
	
	void getDamageFromPlayer(int damage);
	
	void goBack(Collidable collidable);
}
