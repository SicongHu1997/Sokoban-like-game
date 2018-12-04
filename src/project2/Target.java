package project2;

import java.util.Arrays;

import org.newdawn.slick.Input;

public class Target extends Sprite {
	public Target(float x, float y) {
		super("res/Target.png", x, y);
	}
	public void update(Input input, int delta){
		if (World.getsprite(getx(), gety(), Arrays.asList("res/ice.png","res/stone.png"))){
			World.set_gs(World.get_gs()*App.WIN);
		}
		else{
			World.set_gs(World.get_gs()*App.NOTHING_HAPPEN);
		}
	}
}
