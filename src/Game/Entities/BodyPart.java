package Game.Entities;

public class BodyPart {
    public int x;
    public int y;

    public BodyPart(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public BodyPart(BodyPart other) {
        this.x = other.x;
        this.y = other.y;
    }

    public void move(int xOffset, int yOffset) {
        this.x += xOffset;
        this.y += yOffset;
    }

    public void set(BodyPart other) {
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