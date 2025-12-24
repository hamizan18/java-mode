import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    private int playerX = 100;
    private int playerY = 400;
    private final int playerW = 40;
    private final int playerH = 40;
    private final int playerSpeed = 5;
    private Enemy enemy = new Enemy(380, 50);

    private final List<Bullet> enemyBullets = new ArrayList<>();
    private final List<Bullet> bullets = new ArrayList<>();
    private final Timer timer;

    public GamePanel() {
        setPreferredSize(new Dimension(800, 500));
        setFocusable(true);

        setupKeyBindings();

        timer = new Timer(16, e -> {
            updateBullets();
            updateEnemy();
            repaint();
        });
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());

        g.setColor(Color.WHITE);
        g.fillRect(playerX, playerY, playerW, playerH);

        g.setColor(Color.YELLOW);
        for (Bullet b : bullets) {
            g.fillOval(b.x, b.y - b.size / 2, b.size, b.size);
        }
        
        // Enemy
        g.setColor(Color.RED);
        g.fillRect(enemy.x, enemy.y, enemy.width, enemy.height);

        g.setColor(Color.ORANGE);
        for (Bullet b : enemyBullets) {
            g.fillOval(b.x, b.y, b.size, b.size);
        }
    }

    private void setupKeyBindings() {
        InputMap im = getInputMap(WHEN_IN_FOCUSED_WINDOW);
        ActionMap am = getActionMap();

        im.put(KeyStroke.getKeyStroke("D"), "right");
        am.put("right", new AbstractAction() {
            @Override public void actionPerformed(ActionEvent e) {
                playerX += playerSpeed;
            }
        });

        im.put(KeyStroke.getKeyStroke("A"), "left");
        am.put("left", new AbstractAction() {
            @Override public void actionPerformed(ActionEvent e) {
            playerX -= playerSpeed;
            }
        });

        im.put(KeyStroke.getKeyStroke("SPACE"), "dor");
        am.put("dor", new AbstractAction() {
            @Override public void actionPerformed(ActionEvent e) {
                shoot();
            }
        });
    }

    private void shoot() {
        int bulletStartX = playerX + playerW / 2 - 10 / 2; // tengah player
        int bulletStartY = playerY - playerH / 2; 

        int bulletSpeed = 12;
        bullets.add(new Bullet(bulletStartX, bulletStartY, -bulletSpeed));
    }

    private void updateEnemy() {
        if (enemy.canShoot()) {
            int bx = enemy.x + enemy.width / 2 - 5;
            int by = enemy.y + enemy.height;

            enemyBullets.add(new Bullet(bx, by, 8));
        }
    }

    private void updateBullets() {
        Iterator<Bullet> it = bullets.iterator();
        while (it.hasNext()) {
            Bullet b = it.next();
            b.update();

            // Hapus klo keluar layar atas
            if (b.y < -b.size) {
                it.remove();
            }
        }
        Iterator<Bullet> itEnemy = enemyBullets.iterator();
        while (itEnemy.hasNext()) {
            Bullet eb = itEnemy.next();
            eb.update();

            if (eb.y > getHeight()) {
                itEnemy.remove();
            }
        }
    }
    
}