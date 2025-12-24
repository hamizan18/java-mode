import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    private final int playerSpeed = 5;
    private Player player = new Player(100, 400);
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
        g.fillRect(
            player.getX(),
            player.getY(),
            player.getWidth(),
            player.getHeight()
        );

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
                player.move(playerSpeed, 0);
            }
        });

        im.put(KeyStroke.getKeyStroke("A"), "left");
        am.put("left", new AbstractAction() {
            @Override public void actionPerformed(ActionEvent e) {
                player.move(playerSpeed, 0);
            }
        });

        im.put(KeyStroke.getKeyStroke("SPACE"), "dor");
        am.put("dor", new AbstractAction() {
            @Override public void actionPerformed(ActionEvent e) {
                player.shoot(bullets);
            }
        });
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