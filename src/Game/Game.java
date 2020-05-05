package Game;

import Game.Entities.Directions;
import Game.Entities.Field;
import Game.Entities.Food;
import Game.Entities.Snake;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;

import static Game.Entities.Field.FIELD_CELL_SIZE;
import static Game.Entities.Field.FIELD_SIZE;

public class Game {
    private Snake snake = new Snake();
    private Food food;
    private Directions newDirection = null;
    private boolean isGameRunning = true;
    private Canvas c = new Canvas(FIELD_SIZE, FIELD_SIZE);
    private GraphicsContext gc = c.getGraphicsContext2D();

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

//        while (isGameRunning) {
//            if (!snake.isAlive()) {
//                isGameRunning = false;
//            }
//            if (snake.isAteAllFood()) {
//                food = new Food(snake);
//                snake.isAteAllFood(false);
//            }
//            isGameRunning = snake.update(FIELD_SIZE, food, newDirection);
//            setNewDirection(null);
//        }
    }

    private void tick(GraphicsContext gc) { //todo

        if (snake.isAteAllFood()) {
            food = new Food(snake);
        }
        
        snake.update(food, newDirection);
        // draw field
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, FIELD_SIZE, FIELD_SIZE);
        // draw snake
        for (Snake.BodyPart c : snake.getBody()) {
//            gc.setFill(Color.LIGHTGREEN);
//            gc.fillRect(c.x * FIELD_CELL_SIZE, c.y * FIELD_CELL_SIZE, FIELD_CELL_SIZE - 1, FIELD_CELL_SIZE - 1);
            gc.setFill(Color.GREEN);
            gc.fillRect(c.x * FIELD_CELL_SIZE, c.y * FIELD_CELL_SIZE, FIELD_CELL_SIZE - 2, FIELD_CELL_SIZE - 2);
        }
    }
    public Canvas getCanvas() {
        return c;
    }
//    public boolean gameCycle() {
//        if (snake.isAteAllFood()) {
//            food = new Food(snake);
//            snake.isAteAllFood(false);
//        }
//        isGameRunning = snake.update(FIELD_SIZE, food, newDirection);
//        setNewDirection(null);
//        if (!isGameRunning)
//            if (snake.isAlive())
//                System.out.println("WON!");
//            else
//                System.out.println("LOST(");
//        return isGameRunning;
//    }

    public synchronized void setNewDirection(Directions direction) {
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
