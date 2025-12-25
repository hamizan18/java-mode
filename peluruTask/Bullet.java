import java.awt.Rectangle;

public class Bullet {
    public int x, y;
    public int size = 10;
    public int vy;

    public Bullet(int x, int y, int vy) {
        this.x = x;
        this.y = y;
        this.vy = vy; 
    }

    public void update() {
        y += vy;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, size, size);
    }
}
