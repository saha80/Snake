package Game;

import Game.Entities.Directions;
import Game.Entities.Field;
import Game.Entities.Food;
import Game.Entities.Snake;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;

public class Game {
    public static final Color BGCOLOR = Color.SILVER;
    private Snake snake = new Snake(Field.fieldSize);
    private boolean isGameRunning = false;
    private Directions newDirection = null;
    private Food food;

    public boolean gameCycle(){
        if(snake.isAteAllFood)
        {
            food = new Food(Field.fieldSize, snake);
            snake.isAteAllFood = false;
        }
        isGameRunning = snake.update(Field.fieldSize, food, newDirection);
        setNewDirection(null);
        if(!isGameRunning)
            if(snake.isAlive)
                System.out.println("WON!");
            else
                System.out.println("LOST(");
        return isGameRunning;
    }
    public Snake getSnake(){
        return snake;
    }
    public Food getFood(){
        return food;
    }

    public synchronized void setNewDirection(Directions direction){
        newDirection = direction;
    }
    public static Directions getDirectionByKey(KeyCode keyCode){
        switch (keyCode)
        {
            case UP:
            case W:
                return Directions.up;
            case DOWN:
            case S:
                return Directions.down;
            case LEFT:
            case A:
                return Directions.left;
            case RIGHT:
            case D:
                return Directions.right;
        }
        return null;
    }
}
