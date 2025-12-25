import java.util.List;
import java.awt.Rectangle;

public abstract class Character {
    protected int x, y;
    protected int width = 40;
    protected int height = 40;
    protected int hp;
    protected int damage;
    protected int maxHp = 100;
    protected int shootCd = 0;
    protected int shootDelay = 14;

    public Character(int x, int y, int hp, int damage) {
        this.x = x;
        this.y = y;
        this.hp = hp;
        this.damage = damage;
        this.maxHp = hp;
    }

    public abstract void shoot(List<Bullet> bullets);

    public void updateCd() {
        if (shootCd > 0) {
            shootCd--;
        }
    }

    protected boolean canShoot() {
        return shootCd == 0;
    }
    public void takeDamage(int dmg) {
        hp -= dmg;
    }

    public boolean isDead() {
        return hp <= 0;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    public void move(int dx, int dy) {
        x += dx;
        y += dy;
    }

    public int getHp() { return hp; }
    public int getMaxHp() { return maxHp; }
    
    public int getX() { return x; }
    public int getY() { return y; }
    public int getWidth() { return width; }
    public int getHeight() { return height; }
}
