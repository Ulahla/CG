package SB_exercise1;

import org.lwjgl.Sys;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

public class Player{

	private String name;
	public int yPlayerPos = KickPong.height/2;
	public int xPlayerPos;
	private boolean isRunning;
	private int yPlayerSpeed = 200;
	int keyUp;
	int keyDown;


	public Player(String name, int keyUp, int keyDown){
		this.name = name;
		this.keyUp = keyUp;
		this.keyDown = keyDown;
	}

	/**
	 * input is the position of the player
	 * @param xPlayerPos
	 */
	public void draw(int xPlayerPos){
		this.xPlayerPos = xPlayerPos;
		GL11.glBegin(GL11.GL_QUADS);
		GL11.glVertex2d(xPlayerPos, yPlayerPos-30);
		GL11.glVertex2d(xPlayerPos, yPlayerPos+30);
		GL11.glVertex2d(xPlayerPos+5, yPlayerPos+30);
		GL11.glVertex2d(xPlayerPos+5, yPlayerPos-30);
		move(keyUp, keyDown);
		GL11.glEnd();
	}

	/**
	 * input are the keys (UP and DOWN), which make the player move (W and S for left player1, Up and Down for player 2)
	 * @param keyUp
	 * @param keyDown
	 */
	public void move(int keyUp, int keyDown){
			if(Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)) KickPong.end = true;
			if(Keyboard.isKeyDown(keyUp))   yPlayerPos += yPlayerSpeed * KickPong.timeDiff;
			if(Keyboard.isKeyDown(keyDown)) yPlayerPos -= yPlayerSpeed * KickPong.timeDiff;
			if(yPlayerPos > KickPong.height){
				yPlayerPos = 0;
			}
			else if(yPlayerPos < 0)
				yPlayerPos = KickPong.height;
	}
	
	public void affectBall(){
		
	}


}
