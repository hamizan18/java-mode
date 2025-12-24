public class Enemy {
    public int x, y;
    public int width = 40;
    public int height = 40;

    private int shootCooldown = 0;

    public Enemy(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean canShoot() {
        shootCooldown++;
        if (shootCooldown > 60) {
            shootCooldown = 0;
            return true;
        }
        return false;
    }
}