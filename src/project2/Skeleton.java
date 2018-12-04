package project2;

import java.util.Arrays;

import org.newdawn.slick.Input;

public class Skeleton extends Movable {
	public Skeleton(float x, float y) {
		super("res/skull.png", x, y);
		setdir(DIR_UP);
		sethisdir(DIR_UP);
	}
	public void update(Input input, int delta){
		if (World.get_lm()!=DIR_NONE){
			moveToDest(getdir());
		}
	}
	public void moveToDest(int dir) {
		float speed = 32;
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
		if (!World.getsprite(getx()+delta_x, gety()+delta_y, Arrays.asList("res/stone.png","res/ice.png","res/tnt.png",
				"res/rogue.png","res/skull.png","res/mage.png",
				"res/wall.png","res/cracked_wall.png","res/door.png"))){
			setx(getx() + delta_x);
			sety(gety() + delta_y);
			}
		else {
			if (getdir()==DIR_UP){
				setdir(DIR_DOWN);
			}
			else{
				setdir(DIR_UP);
			}
			if (!World.getsprite(getx()-delta_x, gety()-delta_y, Arrays.asList("res/stone.png","res/ice.png","res/tnt.png",
					"res/rogue.png","res/skull.png","res/mage.png",
					"res/wall.png","res/cracked_wall.png","res/door.png"))) {
				setx(getx() - delta_x);
				sety(gety() - delta_y);
				}
		}
	}
}
