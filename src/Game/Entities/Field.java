package Game.Entities;

import javafx.scene.shape.Rectangle;

import static Scenes.MainMenuScene.MAIN_MENU_HEIGHT;
import static Scenes.MainMenuScene.MAIN_MENU_WIDTH;
import static java.lang.Integer.max;

public class Field {
    public static final int FIELD_SIZE = max(MAIN_MENU_WIDTH, MAIN_MENU_HEIGHT) * 2; //square field
    public static final int FIELD_CELL_SIZE = FIELD_SIZE / 30;
}
