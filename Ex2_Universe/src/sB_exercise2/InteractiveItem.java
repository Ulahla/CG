package sB_exercise2;

public interface InteractiveItem {
	// setup entire world, i.e. initialize settings, create display
	// prepare OpenGL
	public abstract void setup();
	
	
	// update all internal calculations,
	// get keyboard state, do physics
	public abstract void update();
	
	
	// render actual entire/world
	public abstract void render();
	
	
	// delet resources, etc. 
	public abstract void finish();
	
}


