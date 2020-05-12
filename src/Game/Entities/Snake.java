package Game.Entities;

import java.util.ArrayList;
import java.util.Random;

import static Game.Entities.Field.*;

public class Snake {
    private ArrayList<BodyPart> body = new ArrayList<>();
    private Directions direction = Directions.values()[new Random().nextInt(3)];
    private int speed = 1;
    private boolean isAlive = true;

    public Snake() {
        body.add(new BodyPart(FIELD_SIZE / 2, FIELD_SIZE / 2));
    }

    public boolean update(Food food, Directions newDirection) {
        BodyPart headCopy = new BodyPart(body.get(0));
        moveHead(headCopy, newDirection);
        if (collidedAWall(headCopy) || collidedItself(headCopy)) {
            return isAlive = false;
        }
        moveBody(headCopy);
        if (headCopy.equals(food)) {
            expand(headCopy, food);
        }
        if (body.size() * FIELD_CELL_COUNT == FIELD_SIZE * FIELD_SIZE) {
            return false;
        }
        return isAlive;
    }

    private void expand(BodyPart headCopy, Food food) {
        body.add(new BodyPart(body.get(body.size() - 1)));
    }

    private void moveHead(BodyPart head, Directions direction) {
        int xOffset = 0, yOffset = 0;
        if (direction == null) {
            direction = this.direction;
        }
        if (direction == Directions.up) {
            if (this.direction == Directions.down) { //Tried to move up while moving down
                direction = Directions.down;
                yOffset = 1;
            } else {
                yOffset = -1;
            }
        }
        if (direction == Directions.down) {
            if (this.direction == Directions.up) { //Tried to move down while moving up
                direction = Directions.up;
                yOffset = -1;
            } else {
                yOffset = 1;
            }
        }
        if (direction == Directions.left) {
            if (this.direction == Directions.right) {//Tried to move left while moving right
                direction = Directions.right;
                xOffset = 1;
            } else {
                xOffset = -1;
            }
        }
        if (direction == Directions.right) {
            if (this.direction == Directions.left) { //Tried to move right while moving left
                direction = Directions.left;
                xOffset = -1;
            } else {
                xOffset = 1;
            }
        }
        this.direction = direction;
        head.move(xOffset * FIELD_CELL_SIZE, yOffset * FIELD_CELL_SIZE);
    }

    private boolean collidedAWall(BodyPart head) {
        return head.x < 0 || head.x >= FIELD_SIZE || head.y < 0 || head.y >= FIELD_SIZE;
    }

    private boolean collidedItself(BodyPart head) {
        for (int i = 4; i < body.size(); i++) {
            if (head.equals(body.get(i))) {
                return true;
            }
        }
        return false;
    }

    private void moveBody(BodyPart newHead) {
        for (int i = body.size() - 1; i > 0; i--)
            body.get(i).set(body.get(i - 1));
        body.get(0).set(newHead);
    }

    public boolean contains(Food food) {
        for (BodyPart bodyPart : body) {
            if (bodyPart.equals(food)) {
                return true;
            }
        }
        return false;
    }

    public int getSpeed() {
        return speed;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public synchronized ArrayList<BodyPart> getBody() {
        return body;
    }
}
