package project2;

import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Graphics;

public class Sprite {
	// Used to decide what direction an object is moving
	public static final int DIR_NONE = 0;
	public static final int DIR_LEFT = 1;
	public static final int DIR_RIGHT = 2;
	public static final int DIR_UP = 3;
	public static final int DIR_DOWN = 4;
	
	private Image image = null;
	private float x;
	private float y;
	private float his_x;
	private float his_y;
	private String tag;
	private int dir = Sprite.DIR_NONE;
	private int his_dir=Sprite.DIR_NONE;
	
	public Sprite(String image_src, float x, float y) {
		try {
			image = new Image(image_src);
		} catch (SlickException e) {
			e.printStackTrace();
		}
		this.x = x;
		this.y = y;
		this.his_x = x;
		this.his_y = y;
		this.tag = image_src;
		snapToGrid();
	}
	
	public float getx(){
		return x;
	}
	
	public float gety(){
		return y;
	}
	
	public float gethisx(){
		return his_x;
	}
	
	public float gethisy(){
		return his_y;
	}
	
	public int gethisdir(){
		return his_dir;
	}
	
	public String gettag(){
		return tag;
	}
	
	public int getdir(){
		return dir;
	}
	
	public void setx(float x){
		this.x = x;
	}
	public void sety(float y){
		this.y = y;
	}
	
	public void sethisx(float x){
		this.his_x = x;
	}
	public void sethisy(float y){
		this.his_y = y;
	}
	
	public void sethisdir(int dir){
		this.his_dir = dir;
	}
	
	public void setdir(int dir){
		this.dir = dir;
	}
	
	public void settag(String tag){
		this.tag = tag;
	}
	
	public void setimg(Image image){
		this.image = image;
	}
	
	/** Update the sprite state.
     * @param input keyboard input.
     * @param delta Time passed since last frame (milliseconds).
     */
	public void update(Input input, int delta) {
	}
	
	/** Render the entire screen, so it reflects the current game state.
     * @param g The Slick graphics object, used for drawing.
     */
	public void render(Graphics g) {
		image.drawCentered(x, y);
	}
	
	// save the sprite state
	public void save() {
		this.his_x=this.x;
		this.his_y=this.y;
		this.his_dir=this.dir;
	}
	// Forces this sprite to align to the grid
	public void snapToGrid() {
		x /= App.TILE_SIZE;
		y /= App.TILE_SIZE;
		x = Math.round(x);
		y = Math.round(y);
		x *= App.TILE_SIZE;
		y *= App.TILE_SIZE;
	}
}
