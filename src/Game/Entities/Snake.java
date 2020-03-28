package Game.Entities;

import Game.Game;

import javax.management.openmbean.ArrayType;
import java.sql.Array;
import java.util.ArrayList;

public class Snake {
    public class BodyPart {
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

    public static final int START_LENGTH = 4;
    private ArrayList<BodyPart> body = new ArrayList<BodyPart>(START_LENGTH);
    private Directions direction = Directions.left;
    public boolean isAlive = true;
    public boolean isAteAllFood = true;

    public Snake(int fieldSize) {
        int xOffset = 0, yOffset = 0;
        switch (direction) {
            case up:
                yOffset = 1;
                break;
            case down:
                yOffset = -1;
                break;
            case left:
                xOffset = 1;
                break;
            case right:
                xOffset = -1;
                break;
        }

        for (int i = 0; i < START_LENGTH; i++) {
            int BPx = fieldSize / 2 + xOffset * i - 1;
            int BPy = fieldSize / 2 + yOffset * i - 1;
            body.add(new BodyPart(BPx, BPy));
        }
    }

    public synchronized boolean update(int fieldSize, Food food, final Directions newDirection) {
        BodyPart headCopy = new BodyPart(body.get(0));

        move(headCopy, newDirection);

        if (collidedAWall(fieldSize, headCopy) || collidedItself(headCopy))
            return isAlive = false;

        moveSnake(headCopy);
        expand(headCopy, food);
        if (body.size() == fieldSize * fieldSize)
            return false;
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
        if (direction == null)
            direction = this.direction;
        switch (direction) {
            case up:
                if (this.direction == Directions.down) //Tried to move up while moving down
                {
                    direction = Directions.down;
                    yOffset = 1;
                } else
                    yOffset = -1;
                break;
            case down:
                if (this.direction == Directions.up) //Tried to move down while moving up
                {
                    direction = Directions.up;
                    yOffset = -1;
                } else
                    yOffset = 1;
                break;
            case left:
                if (this.direction == Directions.right) //Tried to move left while moving right
                {
                    direction = Directions.right;
                    xOffset = 1;
                } else
                    xOffset = -1;
                break;
            case right:
                if (this.direction == Directions.left) //Tried to move right while moving left
                {
                    direction = Directions.left;
                    xOffset = -1;
                } else
                    xOffset = 1;
                break;
        }
        this.direction = direction;
        head.move(xOffset, yOffset);
    }

    private boolean collidedAWall(int fieldSize, BodyPart head) {
        return head.x < 0 || head.x >= fieldSize || head.y < 0 || head.y >= fieldSize;
    }

    private boolean collidedItself(BodyPart head) {
        for (int i = 4; i < body.size(); i++) {
            if (head.equals(body.get(i)))
                return true;
        }
        return false;
    }

    private void moveSnake(BodyPart newHead) {
        for (int i = body.size() - 1; i > 0; i--)
            body.get(i).move(body.get(i - 1));
        body.get(0).move(newHead);
    }

    public boolean contains(Food food) {
        for (BodyPart bodyPart : body)
            if (bodyPart.equals(food))
                return true;
        return false;
    }

    public synchronized ArrayList<BodyPart> getBody() {
        return body;
    }
}
