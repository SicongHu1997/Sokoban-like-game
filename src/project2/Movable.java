package project2;

import java.util.Arrays;

public class Movable extends Sprite{
	public Movable(String image_src, float x, float y){
		super(image_src, x, y);
	}
	
	/** move the sprite to a certain direction.
	 * @param dir the direction for the sprite to move.
	 */
	public void moveToDest(int dir) {
		float speed = 32;
		// Translate the direction to an x and y displacement
		float delta_x = 0,
			  delta_y = 0;
		switch (dir) {
			case DIR_LEFT:
				delta_x = -speed;
				break;
			case DIR_RIGHT:
				delta_x = speed;
				break;
			case DIR_UP:
				delta_y = -speed;
				break;
			case DIR_DOWN:
				delta_y = speed;
				break;
		}
		
		// Make sure the position isn't occupied!
		if (!World.getsprite(getx()+delta_x, gety()+delta_y, Arrays.asList("res/wall.png","res/cracked_wall.png","res/door.png"))) {
			if ((!(World.getsprite(getx()+delta_x, gety()+delta_y, Arrays.asList("res/stone.png","res/ice.png"))&&
					(World.getsprite(getx()+2*delta_x, gety()+2*delta_y, Arrays.asList("res/stone.png","res/ice.png","res/tnt.png",
							"res/rogue.png","res/skull.png","res/mage.png",
							"res/wall.png","res/cracked_wall.png","res/door.png"))))) &&
				(!(World.getsprite(getx()+delta_x, gety()+delta_y, Arrays.asList("res/tnt.png"))&&
						(World.getsprite(getx()+2*delta_x, gety()+2*delta_y, Arrays.asList("res/stone.png","res/ice.png","res/tnt.png",
								"res/rogue.png","res/skull.png","res/mage.png",
								"res/wall.png","res/door.png")))))){
				setx(getx() + delta_x);
				sety(gety() + delta_y);
			}
		}
	}
}
