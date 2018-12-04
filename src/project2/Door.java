package project2;

import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Image;

public class Door extends Sprite {
	public Door(float x, float y) {
		super("res/door.png", x, y);
	}
	public void update(Input input, int delta){
		if(World.get_door()){
			settag("res/floor.png");
			try {
				setimg(new Image("res/floor.png"));
			} catch (SlickException e) {
				e.printStackTrace();
			}
		}
		else{
			settag("res/door.png");
			try {
				setimg(new Image("res/door.png"));
			} catch (SlickException e) {
				e.printStackTrace();
			}
		}
	}
}