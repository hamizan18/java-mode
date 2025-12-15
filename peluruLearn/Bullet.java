public class Bullet {
    public int x, y;
    public int vx;
    public int size = 10;

    public Bullet(int x, int y, int vx) {
        this.x = x;
        this.y = y;
        this.vx = vx;
    }

    public void update() {
        x += vx;
    }
}