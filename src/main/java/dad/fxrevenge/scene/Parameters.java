package dad.fxrevenge.scene;

import dad.fxrevenge.models.Enemy;
import dad.fxrevenge.models.Race;
import javafx.scene.image.Image;

public interface Parameters {

	// RESOLUCIÓN DEL JUEGO
	int GAME_RESOLUTION_WIDTH = 800;
	int GAME_RESOLUTION_HEIGHT = 600;

	// AJUSTES DEL MAPA
	int MAP_CELL_SIZE = 50;

	// IMAGENES DE FONDO
	Image BACKGROUND_TITLESCREEN = new Image("/image/background/titlescreen.png");
	Image BACKGROUND_INTRODUCTION = new Image("/image/background/introduction.png");

	Image BACKGROUND_M = new Image("/image/background/m.png");
	Image BACKGROUND_V = new Image("/image/background/v.png");
	Image BACKGROUND_C = new Image("/image/background/c.png");
	Image BACKGROUND_FX = new Image("/image/background/fx.png");

	// JEFES
	Enemy BOSS_M = new Enemy(Race.M, 1);
	Enemy BOSS_V = new Enemy(Race.V, 1);
	Enemy BOSS_C = new Enemy(Race.C, 1);
	Enemy BOSS_FX = new Enemy(Race.FX, 1);

}
