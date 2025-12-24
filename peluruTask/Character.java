import java.util.List;

public abstract class Character {
    protected int x, y;
    protected int width = 40;
    protected int height = 40;

    protected int hp;
    protected int damage;

    public Character(int x, int y, int hp, int damage) {
        this.x = x;
        this.y = y;
        this.hp = hp;
        this.damage = damage;
    }

    public abstract void shoot(List<Bullet> bullets);

    public void move(int dx, int dy) {
        x += dx;
        y += dy;
    }
    public int getX() { return x; }
    public int getY() { return y; }
    public int getWidth() { return width; }
    public int getHeight() { return height; }
}
