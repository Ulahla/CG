package SB_exercise1;

import java.awt.Font;

import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

public class KickPong {
	public static int width  = 800;
	public static int height = 600;
	public static long lastTime = 0;
	public static float timeDiff = 0;
	public static boolean end = false;
	public Player player1;
	public Player player2;
	public Ball ball;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KickPong app = new KickPong();
		app.run();
	}

	public void init(){
		try {
			Display.setDisplayMode(new DisplayMode(width, height));
			Display.create();
			
			//load default java font
//			Font awtFont = new Font("Arial", Font.BOLD, 24);
//			font = new TrueTyoeFont(awtFont, true);
			GL11.glEnable(GL11.GL_TEXTURE_2D);
			GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
			
			//initialize Players and Ball
			player1 = new Player("player1", Keyboard.KEY_W, Keyboard.KEY_S);
			player2 = new Player("player2", Keyboard.KEY_UP, Keyboard.KEY_DOWN);
			ball = new Ball();
			
		} catch (LWJGLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//set OpenGL ortho
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		GL11.glOrtho(0, width, 0, height, 1, -1);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		
		// Set Background Color
		GL11.glClearColor(0.3f, 0.3f, 0.3f, 1f);
		
		lastTime = Sys.getTime();
		}
	
	private void run(){
		
		init();
		
		while(!end){
			end = update();
			draw();
		}
	}
	
	private void draw(){
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);

		// draw line in the middle
		GL11.glColor3d(0.2f, 0.2f, 0.2f);
		drawLine(width/2-2, 0, width/2+2, height);
		
		// draw Score left
		GL11.glBegin(GL11.GL_QUADS);
		GL11.glEnable(GL11.GL_BLEND);
//		font.drawString(20,10, "Score", Color.yellow);
		GL11.glDisable(GL11.GL_BLEND);
		GL11.glColor3d(1f, 1f, 1f);
		GL11.glVertex2d(57, 50);
		GL11.glVertex2d(107, 50);
		GL11.glVertex2d(107, 0);
		GL11.glVertex2d(57, 0);
		GL11.glEnd();

		// draw Score right
		GL11.glBegin(GL11.GL_QUADS);
//		GL11.glt
		GL11.glColor3d(1f, 1f, 1f);
		GL11.glVertex2d(width-104, 50);
		GL11.glVertex2d(width-54, 50);
		GL11.glVertex2d(width-54, 0);
		GL11.glVertex2d(width-104, 0);
		GL11.glEnd();
		
		// draw Player 1 und 2
		GL11.glColor3d(0.f, 1.f, 1.f);
		player1.draw(80);
		player2.draw(width-80);


		// draw ball
		GL11.glColor3d(1.0f, 0f, 0f);
		ball.draw();
	}
	
	/**
	 * input is xs (start) ys (start) and xe (end) ye (end)
	 * @param xs
	 * @param ys
	 * @param xe
	 * @param ye
	 */
	private void drawLine(int xs, int ys, int xe, int ye) {
		GL11.glBegin(GL11.GL_QUADS);
		GL11.glVertex2d(xs, ys);
		GL11.glVertex2d(xs, ye);
		GL11.glVertex2d(xe, ye);
		GL11.glVertex2d(xe, ys);
		GL11.glEnd();
	}

	private boolean update(){

		long aktTime = Sys.getTime();
		timeDiff = ((float)(aktTime-lastTime))/Sys.getTimerResolution();
		lastTime = aktTime;
//		System.out.println(timeDiff);
		ball.move();
		Display.update();
		Display.sync(20);
		return Display.isCloseRequested();
	}

	
	//GL11.glTranslatef(-10,0,0);
//	for
//	GL11.glColor3f
//	GL11.glTranslatef
//	Gl11.glRotatef
//	meshT.draw();

}
