package project2;

import java.util.Arrays;

import org.newdawn.slick.Input;

public class Rogue extends Movable {
	public Rogue(float x, float y) {
		super("res/rogue.png", x, y);
		setdir(DIR_LEFT);
		sethisdir(DIR_LEFT);
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
		if (!World.getsprite(getx()+delta_x, gety()+delta_y, Arrays.asList("res/wall.png","res/cracked_wall.png","res/door.png")) &&
			!(World.getsprite(getx()+delta_x, gety()+delta_y, Arrays.asList("res/stone.png","res/ice.png"))&&
					World.getsprite(getx()+2*delta_x, gety()+2*delta_y, Arrays.asList("res/stone.png","res/ice.png","res/tnt.png",
							"res/rogue.png","res/skull.png","res/mage.png","res/player_left.png",
							"res/wall.png","res/cracked_wall.png","res/door.png"))) &&
			!(World.getsprite(getx()+delta_x, gety()+delta_y, Arrays.asList("res/tnt.png"))&&
					World.getsprite(getx()+2*delta_x, gety()+2*delta_y, Arrays.asList("res/stone.png","res/ice.png","res/tnt.png",
							"res/rogue.png","res/skull.png","res/mage.png","res/player_left.png",
							"res/wall.png","res/door.png")))){
			setx(getx() + delta_x);
			sety(gety() + delta_y);
			}
		else {
			if (getdir()==DIR_LEFT){
				setdir(DIR_RIGHT);
			}
			else{
				setdir(DIR_LEFT);
			}
			if (!World.getsprite(getx()-delta_x, gety()-delta_y, Arrays.asList("res/wall.png","res/cracked_wall.png","res/door.png")) &&
					!(World.getsprite(getx()-delta_x, gety()-delta_y, Arrays.asList("res/stone.png","res/ice.png"))&&
							World.getsprite(getx()-2*delta_x, gety()-2*delta_y, Arrays.asList("res/stone.png","res/ice.png","res/tnt.png",
									"res/rogue.png","res/skull.png","res/mage.png","res/player_left.png",
									"res/wall.png","res/cracked_wall.png","res/door.png"))) &&
					!(World.getsprite(getx()-delta_x, gety()-delta_y, Arrays.asList("res/tnt.png"))&&
							World.getsprite(getx()-2*delta_x, gety()-2*delta_y, Arrays.asList("res/stone.png","res/ice.png","res/tnt.png",
									"res/rogue.png","res/skull.png","res/mage.png","res/player_left.png",
									"res/wall.png","res/door.png")))){
					setx(getx() - delta_x);
					sety(gety() - delta_y);
			}
		}
	}
}