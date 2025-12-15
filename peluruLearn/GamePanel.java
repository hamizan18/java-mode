import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

// COBA COBA SENDIRIIII
// MINTA TUGAS SEMACAM UBAH UBAH SAMTHING DARI CODINGAN YG DAH JADI NI ATAU GA MINTA BIKIN ULANG VERSI LAENS


public class GamePanel extends JPanel {
    private int playerX = 100;
    private int playerY = 200;
    private final int playerW = 40;
    private final int playerH = 40;
    private final int playerSpeed = 5;

    private final List<Bullet> bullets = new ArrayList<>();

    private final Timer timer;

    public GamePanel() {
        setPreferredSize(new Dimension(800, 500));
        setFocusable(true); // untuk input keyboard

        setupKeyBindings();

        timer = new Timer(16, e -> {
            updateBullets();
            repaint();
        });
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // BG sementara
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());

        g.setColor(Color.WHITE);
        g.fillRect(playerX, playerY, playerW, playerH);

        g.setColor(Color.YELLOW);
        for (Bullet b : bullets) {
            g.fillOval(b.x, b.y - b.size/2, b.size, b.size);
        }
    }

    private void setupKeyBindings() {
        InputMap im = getInputMap(WHEN_IN_FOCUSED_WINDOW);
        ActionMap am = getActionMap();

        im.put(KeyStroke.getKeyStroke("W"), "up");
        am.put("up", new AbstractAction() {
            @Override public void actionPerformed(ActionEvent e) {
                playerY -= playerSpeed;
            }
        });

        im.put(KeyStroke.getKeyStroke("S"), "down");
        am.put("down", new AbstractAction() {
            @Override public void actionPerformed(ActionEvent e) {
                playerY += playerSpeed;
            }
        });

        im.put(KeyStroke.getKeyStroke("SPACE"), "shoot");
        am.put("shoot", new AbstractAction() {
            @Override public void actionPerformed(ActionEvent e) {
                shoot();
            }
        });
    }

    private void shoot() {
        int bulletStartX = playerX + playerW;   // keluar dari kanan plyer
        int bulletStartY = playerY + playerH / 2; // tengah player

        int bulletSpeed = 12;
        bullets.add(new Bullet(bulletStartX, bulletStartY, bulletSpeed));
    }

    private void updateBullets() {
        Iterator<Bullet> it = bullets.iterator();
        while (it.hasNext()) {
            Bullet b = it.next();
            b.update();

            // hapus kalo keluar layar kanan
            if (b.x > getWidth() + 50) {
                it.remove();
            }
        }
    }
}