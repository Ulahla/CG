package SB_exercise1;

import java.util.Random;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

public class Ball {

	public int xBallPos;
	public int yBallPos;
	public int xDir;
	public int yDir;
			
	public Ball() {
		// TODO Auto-generated constructor stub
		xBallPos = KickPong.width/2;
		yBallPos = KickPong.height/2;
		Random random = new Random();
		int xrand = random.nextInt(2);
		int yrand = random.nextInt(2);
		xDir = xrand == 1 ?  -1 : 1;
		yDir = yrand == 1 ?  1 : -1;
	}

	public void draw(){
		GL11.glPointSize(10);
		
		GL11.glBegin(GL11.GL_POINTS);
		GL11.glVertex2d(xBallPos,yBallPos);
		GL11.glEnd();
	}

	public void move() {
		double speed = 150;
		if(Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)) KickPong.end = true;

		// x-Movement
		if(xBallPos > KickPong.width){
			xBallPos = KickPong.width;
			xDir = -1;
		}
		else if(xBallPos < 0){
			xBallPos = 0;
			xDir = 1;
		}
//		else if(xBallPos == player1.x)
//			xDir = -1;

		// y-Movement
		if(yBallPos > KickPong.height){
			yBallPos = KickPong.height;
			yDir = -1;
		}
		if(yBallPos < 0){
			yBallPos = 0;
			yDir = 1;
		}

		yBallPos += yDir * speed * KickPong.timeDiff;
		xBallPos += xDir * speed * KickPong.timeDiff;
	}
}
