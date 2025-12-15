import javax.swing.*;
import java.awt.*;

public class BattlePanel extends JPanel {

    private BattleEngine battleEngine;

    private JLabel lblPlayerHp;
    private JLabel lblEnemyHp;
    private JTextArea logArea;
    private JButton btnAttack;
    private JButton btnHeal;

    private Image playerImage;
    private Image enemyImage;

    public BattlePanel() {
        // 1. Bikin object player & enemy
        Player player = new Player("Mijann", 100, 20, 15);
        Enemy enemy = new Enemy("Slime Jahat", 80, 15, 0);

        battleEngine = new BattleEngine(player, enemy);

        // 2. Load gambar
        playerImage = new ImageIcon("img/player.png").getImage();
        enemyImage = new ImageIcon("img/enemy.png").getImage();

        // 3. Atur layout panel
        setLayout(new BorderLayout());

        // Panel atas: HP
        JPanel topPanel = new JPanel(new GridLayout(1, 2));
        lblPlayerHp = new JLabel();
        lblEnemyHp = new JLabel();
        topPanel.add(lblPlayerHp);
        topPanel.add(lblEnemyHp);
        add(topPanel, BorderLayout.NORTH);

        // Panel tengah: gambar
        JPanel centerPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                // background sederhana
                g.setColor(new Color(30, 30, 60));
                g.fillRect(0, 0, getWidth(), getHeight());

                // player
                if (playerImage != null) {
                    g.drawImage(playerImage, 80, 200, 200, 200, this);
                }

                // enemy
                if (enemyImage != null) {
                    g.drawImage(enemyImage, 480, 200, 200, 200, this);
                }
            }
        };
        add(centerPanel, BorderLayout.CENTER);

        // Panel kanan: tombol
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 1, 5, 5));
        btnAttack = new JButton("Attack");
        btnHeal = new JButton("Heal");
        buttonPanel.add(btnAttack);
        buttonPanel.add(btnHeal);
        add(buttonPanel, BorderLayout.EAST);

        // Panel bawah: log
        logArea = new JTextArea(5, 20);
        logArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(logArea);
        add(scrollPane, BorderLayout.SOUTH);

        // 4. Set action tombol
        setupActions();

        // 5. Tampilkan HP awal
        refreshHpLabels();
        appendLog("Pertarungan dimulai!");
    }

    private void setupActions() {
        btnAttack.addActionListener(e -> {
            if (battleEngine.isPlayerDead() || battleEngine.isEnemyDead()) {
                return;
            }

            String log1 = battleEngine.playerAttack();
            appendLog(log1);
            refreshHpLabels();
            repaint();

            if (battleEngine.isEnemyDead()) {
                appendLog("Kamu menang!");
                showWinDialog();
                return;
            }

            String log2 = battleEngine.enemyTurn();
            appendLog(log2);
            refreshHpLabels();
            repaint();

            if (battleEngine.isPlayerDead()) {
                appendLog("Kamu kalah...");
                showGameOverDialog();
            }
        });

        btnHeal.addActionListener(e -> {
            if (battleEngine.isPlayerDead() || battleEngine.isEnemyDead()) {
                return;
            }

            String log1 = battleEngine.playerHeal();
            appendLog(log1);
            refreshHpLabels();
            repaint();

            String log2 = battleEngine.enemyTurn();
            appendLog(log2);
            refreshHpLabels();
            repaint();

            if (battleEngine.isPlayerDead()) {
                appendLog("Kamu kalah...");
                showGameOverDialog();
            }
        });
    }

    private void refreshHpLabels() {
        lblPlayerHp.setText(
                battleEngine.getPlayer().getName() +
                        " HP: " + battleEngine.getPlayer().getHp() +
                        "/" + battleEngine.getPlayer().getMaxHp()
        );

        lblEnemyHp.setText(
                battleEngine.getEnemy().getName() +
                        " HP: " + battleEngine.getEnemy().getHp() +
                        "/" + battleEngine.getEnemy().getMaxHp()
        );
    }

    private void appendLog(String text) {
        if (text == null || text.isEmpty()) return;
        logArea.append(text + "\n");
        logArea.setCaretPosition(logArea.getDocument().getLength());
    }

    private void showWinDialog() {
        JOptionPane.showMessageDialog(this,
                "YOU WIN!",
                "Victory",
                JOptionPane.INFORMATION_MESSAGE);
    }

    private void showGameOverDialog() {
        JOptionPane.showMessageDialog(this,
                "GAME OVER",
                "Defeat",
                JOptionPane.ERROR_MESSAGE);
    }
}
