import java.util.List;

public class Player extends Character {

    public Player(int x, int y) {
        super(x, y, 100, 10);
    }

    @Override
    public void shoot(List<Bullet> bullets) {
        int bx = x + width / 2 - 5;
        int by = y;

        bullets.add(new Bullet(bx, by, -12)); // ke atas
    }
}
