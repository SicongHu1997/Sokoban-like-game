package project2;

import java.util.Arrays;

import org.newdawn.slick.Input;

public class Switch extends Sprite {
	public Switch(float x, float y) {
		super("res/switch.png", x, y);
	}
	public void update(Input input, int delta){
		if (World.getsprite(getx(), gety(), Arrays.asList("res/ice.png","res/stone.png"))){
			World.set_door(Boolean.TRUE);
		}
		else{
			World.set_door(Boolean.FALSE);
		}
	}
}
