package sB_exercise2;

import org.lwjgl.opengl.GL11;

import sB_exercise2.GLDrawHelper;

public class Planet {
	public String name;
	

	public Planet(String name) {
		name = this.name;
	}

	public void render(float radius, int slices, int stacks, float r,
			float g, float b) {
		GL11.glColor3d(r, g, b);
		GLDrawHelper.drawSphere(radius, slices, stacks);
	}

	public void update() {
		// TODO Auto-generated method stub
		
	}
	
	public void rotate(float angle, float x, float y, float z){
		GL11.glRotatef(angle, x, y, z);
	}

	public void addChild(Planet planet) {
		
	}
}
