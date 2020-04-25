package Game.Entities;

import java.util.Random;

import static Game.Entities.Field.FIELD_SIZE;

public class Food {
    public int x;
    public int y;

    public Food(Snake snake) {
        Random random = new Random(System.currentTimeMillis());
        do {
            this.x = random.nextInt(FIELD_SIZE);
            this.y = random.nextInt(FIELD_SIZE);
        } while (snake.contains(this));
    }
}
