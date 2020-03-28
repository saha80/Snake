package Game.Entities;

import Game.Game;
import javafx.scene.Group;
import javafx.scene.shape.Box;

public class Field {
    public static final int fieldSize = 20;
    public static final int CellWidth = 30;
    public static final int CellHeight = 30;
    public static final int CellLength = 15;
    public static final int DistanceBetweenCells = 4;

    public static Group getField()
    {
        Group group = new Group();
        for (int i = 0; i < fieldSize; i++)
        {
            for (int j = 0; j < fieldSize; j++)
            {
                Box cell = new Box(CellWidth, CellHeight, CellLength);
                cell.translateXProperty().set(i * (CellWidth + DistanceBetweenCells));
                cell.translateYProperty().set(j * (CellHeight + DistanceBetweenCells));
                group.getChildren().add(cell);
            }
        }
        group.translateXProperty().set(CellWidth / 2 + DistanceBetweenCells);
        group.translateYProperty().set(CellHeight / 2 + DistanceBetweenCells);
        return group;
    }
}
