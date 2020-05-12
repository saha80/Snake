package Game.Entities;

import java.util.Random;

import static Game.Entities.Field.*;

public class Food {
    public int x;
    public int y;

    public Food(Snake snake) {
        Random random = new Random(System.currentTimeMillis());
        do {
            this.x = random.nextInt(FIELD_CELL_COUNT) * FIELD_CELL_SIZE;
            this.y = random.nextInt(FIELD_CELL_COUNT) * FIELD_CELL_SIZE;
        } while (snake.contains(this));
    }
}
