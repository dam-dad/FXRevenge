package fxrevenge.world;

import javafx.scene.Scene;

public class StrartAPP2 extends dad.fxrevenge.scene.Scene {

	private WorldMAPController worldController = new WorldMAPController();
	private Scene scene;

	@Override
	public void load() {
		// TODO Auto-generated method stub
		scene = worldController.getScene();
		
	}

	@Override
	protected void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void unload() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Scene getScene() {
		return scene;
	}
	
}
