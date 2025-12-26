import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.*;
import java.awt.Rectangle;

public class GamePanel extends JPanel {
    private GameState gameState = GameState.PLAYING;
    private final int playerSpeed = 5;
    private Player player = new Player(380, 400);
    private Enemy enemy = new Enemy(380, 50);

    private final List<Bullet> enemyBullets = new ArrayList<>();
    private final List<Bullet> bullets = new ArrayList<>();
    List<Character> characters = new ArrayList<>();

    private boolean leftPressed = false;
    private boolean rightPressed = false;
    private boolean shootPressed = false;
    private final Timer timer;

    public GamePanel() {
        setPreferredSize(new Dimension(800, 500));
        setFocusable(true);

        characters.add(player);
        characters.add(enemy);

        setupKeyBindings();

        timer = new Timer(16, e -> {

            if (gameState != GameState.PLAYING) {
                repaint();
                return;
            }

            player.updateCd();
            enemy.updateCd();
            
            if (leftPressed) {
                player.move(-playerSpeed, 0);
            }
            if (rightPressed) {
                player.move(playerSpeed, 0);
            }
            if (shootPressed) {
                player.shoot(bullets);
            }
            
            updateBullets();
            updateEnemy();
            checkCollision();
            repaint();
        });
        timer.start();
    }

    private void drawHpBar(Graphics g, int x, int y, int width, int height, float ratio, Color fillColor) {
        g.setColor(Color.DARK_GRAY);
        g.fillRect(x, y, width, height);

        g.setColor(fillColor);
        g.fillRect(x, y, (int)(width * ratio), height);

        g.setColor(Color.WHITE);
        g.drawRect(x, y, width, height);
    }

    private void drawEndScreen(Graphics g, String text, Color color) {
        Graphics2D g2 = (Graphics2D) g;

        // Layar gelap
        g2.setColor(new Color(0, 0, 0, 170));
        g2.fillRect(0, 0, getWidth(), getHeight());

        // Font
        g2.setFont(new Font("Arial", Font.BOLD, 48));
        FontMetrics fm = g2.getFontMetrics();

        int textWidth = fm.stringWidth(text);
        int x = (getWidth() - textWidth) / 2;
        int y = getHeight() / 2;

        g2.setColor(color);
        g2.drawString(text, x, y);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());

        drawHpBar(
            g,
            enemy.getX(),
            enemy.getY() - 12,
            enemy.getWidth(),
            6,
            enemy.getHpRatio(),
            Color.RED
        );

        drawHpBar(
            g,
            player.getX(),
            player.getY() + player.getHeight() + 6,
            player.getWidth(),
            6,
            player.getHpRatio(),
            Color.GREEN
        );
        
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

        if (gameState == GameState.WIN) {
            drawEndScreen(g, "YOU WIN!", Color.GREEN);
        }
        if (gameState == GameState.LOSE) {
            drawEndScreen(g, "YOU LOSE!", Color.RED);
        }
    }

    private void setupKeyBindings() {
        InputMap im = getInputMap(WHEN_IN_FOCUSED_WINDOW);
        ActionMap am = getActionMap();

        im.put(KeyStroke.getKeyStroke("pressed A"), "left_pressed");
        im.put(KeyStroke.getKeyStroke("released A"), "left_released");
        am.put("left_pressed", new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                leftPressed = true;
            }
        });
        am.put("left_released", new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                leftPressed = false;
            }
        });


        im.put(KeyStroke.getKeyStroke("pressed D"), "right_pressed");
        im.put(KeyStroke.getKeyStroke("released D"), "right_released");
        am.put("right_pressed", new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                rightPressed = true;
            }
        });
        am.put("right_released", new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                rightPressed = false;
            }
        });


        im.put(KeyStroke.getKeyStroke("pressed SPACE"), "shoot_pressed");
        im.put(KeyStroke.getKeyStroke("released SPACE"), "shoot_released");
        am.put("shoot_pressed", new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                shootPressed = true;
            }
        });
        am.put("shoot_released", new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                shootPressed = false;
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

    private void checkCollision() {
        if (enemy.isDead()) {
            System.out.println("ENEMY DEAD!");
        }
        Iterator<Bullet> it = bullets.iterator();
        while(it.hasNext()) {
            Bullet b = it.next();
                if (b.getBounds().intersects(enemy.getBounds())) {
                    enemy.takeDamage(player.damage);
                    it.remove();
                }
            }

            Iterator<Bullet> eit = enemyBullets.iterator();
            while (eit.hasNext()) {
                Bullet eb = eit.next();
                    if (eb.getBounds().intersects(player.getBounds())) {
                        player.takeDamage(enemy.damage);
                        eit.remove();
                }
            }
            if (enemy.isDead()) {
                gameState = GameState.WIN;
            }
            if (player.isDead()) {
                gameState = GameState.LOSE;
            }
        }
    }