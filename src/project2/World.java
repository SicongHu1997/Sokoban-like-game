package project2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

public class World {
	private static ArrayList<Sprite> sprites;
	private static int last_move = Sprite.DIR_NONE;
	private static Boolean door = Boolean.FALSE;
	private static int game_state = App.NOTHING_HAPPEN;
	private int step=0;
	private int his_step=0;
	
	public World(String str) {
		sprites = Loader.loadSprites(str);
	}
	
	/** Update the game state for a frame.
     * @param input keyboard input.
     * @param delta Time passed since last frame (milliseconds).
     * @return return the game state (win, restart or nothing happen).
     */
	public int update(Input input, int delta) {
		if (input.isKeyPressed(Input.KEY_R)) {
			return App.RESTART;
		}
		if (input.isKeyPressed(Input.KEY_Z)) {
			for (Sprite sprite : sprites) {
				sprite.setx(sprite.gethisx());
				sprite.sety(sprite.gethisy());
				sprite.setdir(sprite.gethisdir());
				sprite.snapToGrid();
				step = his_step;
			}
			return App.NOTHING_HAPPEN;
		}
		for (Sprite sprite : sprites) {
			if (sprite != null) {
				if (last_move!=0 && sprite.gettag()!="res/player_left.png" && sprite.gettag()!="res/stone.png" && sprite.gettag()!="res/ice.png" && sprite.gettag()!="res/tnt.png"){
					sprite.save();
				}
				sprite.update(input, delta);
				if (sprite.gettag()=="res/player_left.png" || sprite.gettag()=="res/rogue.png"){
					for (Sprite s : sprites){
						if (s.gettag()=="res/stone.png" || s.gettag()=="res/ice.png" || s.gettag()=="res/tnt.png"){
							if (last_move!=0 && sprite.gettag()=="res/player_left.png"){
								s.save();
							}
							s.update(input, delta);
						}
					}
				}
				if (sprite.gettag()=="res/player_left.png"){
					if (last_move!=0){
						his_step = step;
						step++;
					}
					if (game_state==1){
						return App.WIN;
					}
					else{
						game_state=1;
					}
				}
				if (sprite.gettag()=="res/rogue.png" || sprite.gettag()=="res/skull.png" || sprite.gettag()=="res/mage.png"){
					if (getsprite(sprite.getx(), sprite.gety(), Arrays.asList("res/player_left.png"))){
						return App.RESTART;
					}
				}
			}
		}
		return App.NOTHING_HAPPEN;
	}
	
	public static int get_lm(){
		return last_move;
	}
	
	public static void set_lm(int dir){
		last_move = dir;
	}
	
	public static int get_gs(){
		return game_state;
	}
	
	public static void set_gs(int n){
		game_state = n;
	}
	
	public static Boolean get_door(){
		return door;
	}
	
	public static void set_door(Boolean d){
		door = d;
	}
	
	/** check if any type of sprite in List of String s appear in coordinate (x,y)
	 * @param x x-coordinate of the position to check.
	 * @param y y-coordinate of the position to check.
	 * @param s list of string (type of sprite) to check.
	 * @return return the result of the check, TRUE or FALSE.
	 */
	public static Boolean getsprite(float x, float y, List<String> s){
		x /= App.TILE_SIZE;
		y /= App.TILE_SIZE;
		x = Math.round(x);
		y = Math.round(y);
		for (Sprite sprite : sprites){
			if (Math.round(sprite.getx()/App.TILE_SIZE)==x && Math.round(sprite.gety()/App.TILE_SIZE)==y){
				for (String t: s){
					if(sprite.gettag().equals(t)){
						return true;
					}
				}
			}
		}
		return false;
	}
	
	/** get the direction of the sprite in position(x, y) and has type t
	 * @param x x-coordinate of the position to check.
	 * @param y y-coordinate of the position to check.
	 * @param t string of the sprite type to check.
	 * @return return the direction of the sprite.
	 */
	public static int getspritedir(float x, float y, String t){
		x /= App.TILE_SIZE;
		y /= App.TILE_SIZE;
		x = Math.round(x);
		y = Math.round(y);
		for (Sprite sprite : sprites){
			if (Math.round(sprite.getx()/App.TILE_SIZE)==x && Math.round(sprite.gety()/App.TILE_SIZE)==y){
				if(sprite.gettag().equals(t)){
					return sprite.getdir();
				}
			}
		}
		return 0;
	}
	
	/** get the x-coordinate of the player
	 * @return return the x-coordinate of the player.
	 */
	public static float find_player_x(){
		for (Sprite sprite : sprites){
			if(sprite.gettag().equals("res/player_left.png")){
				return sprite.getx();
			}
		}
		return 0;
	}
	
	/** get the y-coordinate of the player
	 * @return return the y-coordinate of the player.
	 */
	public static float find_player_y(){
		for (Sprite sprite : sprites){
			if(sprite.gettag().equals("res/player_left.png")){
				return sprite.gety();
			}
		}
		return 0;
	}
	
	/** Render the entire screen, so it reflects the current game state.
     * @param g The Slick graphics object, used for drawing.
     */
	public void render(Graphics g) {
		for (Sprite sprite : sprites) {
			if (sprite != null) {
				sprite.render(g);
			}
		}
		g.drawString("moves: "+step,20.0f,20.0f);
	}
}
