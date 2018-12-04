package project2;

import java.util.Arrays;

import org.newdawn.slick.Input;

public class Mage extends Movable {
	public Mage(float x, float y) {
		super("res/mage.png", x, y);
	}
	public void update(Input input, int delta){
		/** direction **/
		int i=Sprite.DIR_NONE;
		if (World.get_lm()!=0){
			float x = World.find_player_x();
			float y = World.find_player_y();
			if ((Math.round(Math.abs(x-getx())/App.TILE_SIZE)*App.TILE_SIZE)>(Math.round(Math.abs(y-gety())/App.TILE_SIZE)*App.TILE_SIZE)){
				if((x-getx())>0){
					i=Sprite.DIR_RIGHT;
				}
				else{
					i=Sprite.DIR_LEFT;
				}
				float delta_x = 0,
						  delta_y = 0;
					switch (i) {
						case DIR_LEFT:
							delta_x = -App.TILE_SIZE;
							break;
						case DIR_RIGHT:
							delta_x = App.TILE_SIZE;
							break;
						case DIR_UP:
							delta_y = -App.TILE_SIZE;
							break;
						case DIR_DOWN:
							delta_y = App.TILE_SIZE;
							break;
					}
				if(World.getsprite(getx()+delta_x, gety()+delta_y, Arrays.asList("res/stone.png","res/ice.png","res/tnt.png",
						"res/rogue.png","res/skull.png","res/mage.png",
						"res/wall.png","res/cracked_wall.png","res/door.png"))){
					if((y-gety())>0){
						i=Sprite.DIR_DOWN;
					}
					else{
						i=Sprite.DIR_UP;
					}
				}
			}
			else{
				if((y-gety())>0){
					i=Sprite.DIR_DOWN;
				}
				else{
					i=Sprite.DIR_UP;
				}
				float delta_x = 0,
						  delta_y = 0;
					switch (i) {
						case DIR_LEFT:
							delta_x = -App.TILE_SIZE;
							break;
						case DIR_RIGHT:
							delta_x = App.TILE_SIZE;
							break;
						case DIR_UP:
							delta_y = -App.TILE_SIZE;
							break;
						case DIR_DOWN:
							delta_y = App.TILE_SIZE;
							break;
					}
				if(World.getsprite(getx()+delta_x, gety()+delta_y, Arrays.asList("res/stone.png","res/ice.png","res/tnt.png",
						"res/rogue.png","res/skull.png","res/mage.png",
						"res/wall.png","res/cracked_wall.png","res/door.png"))){
					if((x-getx())>0){
						i=Sprite.DIR_RIGHT;
					}
					else{
						i=Sprite.DIR_LEFT;
					}
				}
			}
			float delta_x = 0,
					  delta_y = 0;
				switch (i) {
					case DIR_LEFT:
						delta_x = -App.TILE_SIZE;
						break;
					case DIR_RIGHT:
						delta_x = App.TILE_SIZE;
						break;
					case DIR_UP:
						delta_y = -App.TILE_SIZE;
						break;
					case DIR_DOWN:
						delta_y = App.TILE_SIZE;
						break;
				}
			if(!World.getsprite(getx()+delta_x, gety()+delta_y, Arrays.asList("res/stone.png","res/ice.png","res/tnt.png",
					"res/rogue.png","res/skull.png","res/mage.png",
					"res/wall.png","res/cracked_wall.png","res/door.png"))){
				moveToDest(i);
			}
		}
	}
	public void moveToDest(int dir) {
		float speed = App.TILE_SIZE;
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
}
