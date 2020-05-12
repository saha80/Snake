package Game;

import Game.Entities.*;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;

import static Game.Entities.Field.FIELD_CELL_SIZE;
import static Game.Entities.Field.FIELD_SIZE;

public class Game {
    private final Snake snake = new Snake();
    private Food food;
    private boolean isAteAllFood = true;
    private final Field field = new Field();
    private Directions newDirection = null;
    private final boolean isGameRunning = true;
    private Canvas c = new Canvas(FIELD_SIZE, FIELD_SIZE);
    private GraphicsContext gc = c.getGraphicsContext2D();

    public Game() {
        c.setStyle("-fx-color: white");
    }

    public void gameLoop() {
        new AnimationTimer() {
            private long lastTick = 0;

            @Override
            public void handle(long now) {
                if (lastTick == 0) {
                    lastTick = now;
                    tick(gc);
                    return;
                }
                if (now - lastTick > 1000000000 / snake.getSpeed()) {
                    lastTick = now;
                    tick(gc);
                }
            }
        }.start();
    }

    private void tick(GraphicsContext gc) {
        if (isAteAllFood) {
            food = new Food(snake);
        }
        snake.update(food, newDirection);
        isAteAllFood = snake.contains(food);
        //System.out.println(food.x + " " + food.y);
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, FIELD_SIZE, FIELD_SIZE);
        for (BodyPart c : snake.getBody()) {
            //System.out.println(c.x + " " + c.y + ", ");
            gc.setFill(Color.GREEN);
            gc.fillRect(c.x * FIELD_CELL_SIZE, c.y * FIELD_CELL_SIZE, FIELD_CELL_SIZE - 2, FIELD_CELL_SIZE - 2);
        }
        //System.out.println();
    }

    public Canvas getCanvas() {
        return c;
    }

    public void setNewDirection(Directions direction) {
        newDirection = direction;
    }

    public static Directions getDirectionByKey(KeyCode kc) {
        if (kc == KeyCode.UP || kc == KeyCode.W) {
            return Directions.up;
        }
        if (kc == KeyCode.DOWN || kc == KeyCode.S) {
            return Directions.down;
        }
        if (kc == KeyCode.LEFT || kc == KeyCode.A) {
            return Directions.left;
        }
        if (kc == KeyCode.RIGHT || kc == KeyCode.D) {
            return Directions.right;
        }
        return null;
    }
}
