package project2;

import java.util.Arrays;

import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class Tnt extends Sprite {
	public Tnt(float x, float y) {
		super("res/tnt.png", x, y);
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
		setx(getx() + delta_x);
		sety(gety() + delta_y);
	}
	public void update(Input input, int delta){
		if (World.getsprite(getx(), gety(), Arrays.asList("res/explosion.png"))){
			settag("res/floor.png");
			try {
				setimg(new Image(0,0));
			} catch (SlickException e) {
				e.printStackTrace();
			}
		}
		if (gettag().equals("res/tnt.png")){
		if (World.getsprite(getx(), gety(), Arrays.asList("res/player_left.png"))){
			moveToDest(World.get_lm());
		}
		else{
			if(World.getsprite(getx(), gety(), Arrays.asList("res/rogue.png"))){
				moveToDest(World.getspritedir(getx(), gety(), "res/rogue.png"));
			}
		}
		}
	}
}
