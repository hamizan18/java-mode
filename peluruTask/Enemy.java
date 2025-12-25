import java.util.List;

public class Enemy extends Character {
    private int cooldown = 0;

    public Enemy(int x, int y) {
        super(x, y, 50, 5);
    }

    public boolean canShoot() {
        cooldown++;
        if (cooldown > 60) {
            cooldown = 0;
            return true;
        }
        return false;
    }

    @Override
    public void shoot(List<Bullet> bullets) {

        if (!canShoot()) return;

        int bx = x + width / 2 - 5;
        int by = y + height;

        bullets.add(new Bullet(bx, by, 8)); // ke bawah

        shootCd = shootDelay + 20;
    }

    @Override
    public void takeDamage(int dmg) {
        hp -= dmg;
        System.out.println("ENEMY HIT! HP: " + hp);
    }
    
}
