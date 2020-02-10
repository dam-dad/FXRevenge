package dad.fxrevenge.scene;

public abstract class Scene {

	// abstract void redraw(); // redraw everything on screen

	public abstract void load(); // load all of the data and graphics that this scene needs to function.
	
	protected abstract void update(); // update logic for this scene

	public abstract void unload(); // unload everything that the garbage collector won’t unload, itself, including graphics
	
	public abstract javafx.scene.Scene getScene();

}
