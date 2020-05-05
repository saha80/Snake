package Game.Entities;

import java.util.ArrayList;
import java.util.Random;


import static Game.Entities.Field.FIELD_CELL_SIZE;
import static Game.Entities.Field.FIELD_SIZE;

public class Snake {
    public static class BodyPart {
        public int x;
        public int y;

        public BodyPart(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public BodyPart(BodyPart other) {
            this.move(other);
        }

        public void move(int xOffset, int yOffset) {
            this.x += xOffset;
            this.y += yOffset;
        }

        public void move(BodyPart other) {
            this.x = other.x;
            this.y = other.y;
        }

        public boolean equals(BodyPart other) {
            return this.x == other.x && this.y == other.y;
        }

        public boolean equals(Food food) {
            return this.x == food.x && this.y == food.y;
        }
    }

    //public static final int START_LENGTH = 1;
    private ArrayList<BodyPart> body = new ArrayList<>();
    private Directions direction = Directions.values()[new Random().nextInt(3)];
    private int speed = 1;
    private boolean isAlive = true;
    private boolean isAteAllFood = true;


    public Snake() {
//        int xOffset = 0, yOffset = 0;
//        switch (direction) {
//            case up:
//                yOffset = 1;
//                break;
//            case down:
//                yOffset = -1;
//                break;
//            case left:
//                xOffset = 1;
//                break;
//            case right:
//                xOffset = -1;
//                break;
//        }
//
//        for (int i = 0; i < START_LENGTH; i++) {
//            int BPx = fieldSize / 2 + xOffset * i - 1;
//            int BPy = fieldSize / 2 + yOffset * i - 1;
//            body.add(new BodyPart(BPx, BPy));
//        }
        body.add(new BodyPart(FIELD_SIZE / 2, FIELD_SIZE / 2));
    }

    public synchronized boolean update(Food food, final Directions newDirection) {
        BodyPart headCopy = new BodyPart(body.get(0));

        move(headCopy, newDirection);

        if (collidedAWall(headCopy) || collidedItself(headCopy)) {
            return isAlive = false;
        }

        moveSnake(headCopy);
        expand(headCopy, food);
        if (body.size() == FIELD_SIZE * FIELD_SIZE) {
            return false;
        }
        return isAlive;
    }

    private void expand(BodyPart headCopy, Food food) {
        if (headCopy.equals(food)) {
            isAteAllFood = true;
            body.add(new BodyPart(body.get(body.size() - 1)));
        }
    }

    private void move(BodyPart head, Directions direction) {
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
        head.move(xOffset, yOffset);
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

    private void moveSnake(BodyPart newHead) {
        for (int i = body.size() - 1; i > 0; i--)
            body.get(i).move(body.get(i - 1));
        body.get(0).move(newHead);
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

    public boolean isAteAllFood() {
        return isAteAllFood;
    }

    public void isAteAllFood(boolean b) {
        isAteAllFood = b;
    }

    public synchronized ArrayList<BodyPart> getBody() {
        return body;
    }
}
