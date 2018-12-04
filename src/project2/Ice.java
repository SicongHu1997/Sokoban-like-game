package project2;

import java.util.Arrays;

import org.newdawn.slick.Input;

public class Ice extends Movable {
	/** speed of ice **/
	public static final float ICE_SPEED = 4.0f;
	public Ice(float x, float y) {
		super("res/ice.png", x, y);
	}
	public void moveToDest(int dir, int delta) {
		float speed = ICE_SPEED*App.TILE_SIZE;
		float delta_x = 0,
			  delta_y = 0;
		switch (dir) {
			case DIR_LEFT:
				delta_x = -speed*delta/1000;
				break;
			case DIR_RIGHT:
				delta_x = speed*delta/1000;
				break;
			case DIR_UP:
				delta_y = -speed*delta/1000;
				break;
			case DIR_DOWN:
				delta_y = speed*delta/1000;
				break;
		}
		setx(getx() + delta_x);
		sety(gety() + delta_y);
	}
	public void update(Input input, int delta){
		float delta_x = 0, delta_y = 0;
		switch (getdir()) {
			case DIR_LEFT:
				delta_x = -App.TILE_SIZE/2;
				break;
			case DIR_RIGHT:
				delta_x = App.TILE_SIZE/2;
				break;
			case DIR_UP:
				delta_y = -App.TILE_SIZE/2;
				break;
			case DIR_DOWN:
				delta_y = App.TILE_SIZE/2;
				break;
		}
		if (World.getsprite(getx(), gety(), Arrays.asList("res/player_left.png")) && World.get_lm()!=Sprite.DIR_NONE){
			setdir(World.get_lm());
		}
		else{
			if(World.getsprite(getx(), gety(), Arrays.asList("res/rogue.png"))){
				setdir(World.getspritedir(getx(), gety(), "res/rogue.png"));
			}
		}
		if (World.getsprite(getx()+delta_x, gety()+delta_y, Arrays.asList("res/stone.png", "res/tnt.png",
				"res/skull.png","res/mage.png",
				"res/cracked_wall.png","res/wall.png","res/door.png"))){
			setdir(Sprite.DIR_NONE);
		}
		moveToDest(getdir(), delta);
	}
}
