package project2;

import java.util.Arrays;

import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class Cracked extends Sprite {
	/** explode time limit **/
	public static final int EXPLODE_TIME =400;
	private int timer;
	public Cracked(float x, float y) {
		super("res/cracked_wall.png", x, y);
	}
	public void update(Input input, int delta){
		if (gettag().equals("res/explosion.png")){
			timer += delta;
		}
		if (World.getsprite(getx(), gety(), Arrays.asList("res/tnt.png"))){
			settag("res/explosion.png");
			try {
				setimg(new Image("res/explosion.png"));
			} catch (SlickException e) {
				e.printStackTrace();
			}
		}
		if (timer>=EXPLODE_TIME){
			settag("res/floor.png");
			try {
				setimg(new Image(0,0));
			} catch (SlickException e) {
				e.printStackTrace();
			}
		}
	}
}
