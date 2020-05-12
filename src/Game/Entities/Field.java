package Game.Entities;

import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

import static Scenes.MainMenuScene.MAIN_MENU_HEIGHT;
import static Scenes.MainMenuScene.MAIN_MENU_WIDTH;
import static java.lang.Integer.max;

public class Field extends Rectangle {
    public static final int FIELD_SIZE = (int) ((double) max(MAIN_MENU_WIDTH, MAIN_MENU_HEIGHT) * 1.5); //square field
    public static final int FIELD_CELL_COUNT = 30;
    public static final int FIELD_CELL_SIZE = FIELD_SIZE / FIELD_CELL_COUNT;

    public Field() {

    }
}
