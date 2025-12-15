import javax.swing.*;
import java.awt.*;

public class Window {
    JFrame frame;
    JButton button;
    TheChara playerIcon;
    TheChara enemyIcon;

    public Window(Character player, Character enemy) {
        SwingUtilities.invokeLater(() -> {
            frame = new JFrame("Mijan no Shuuto gemu");
            frame.setSize(1200, 800);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new BorderLayout());

            JPanel hpPanel = new JPanel();
            hpPanel.setLayout(new GridLayout(1, 2));
            JLabel playerHp = new JLabel("HP: " + player.getHp(), SwingConstants.CENTER);
            JLabel enemyHp = new JLabel("HP: " + enemy.getHp(), SwingConstants.CENTER);
            hpPanel.add(playerHp);
            hpPanel.add(enemyHp);

            frame.add(hpPanel, BorderLayout.NORTH);

            hpPanel.setBackground(Color.CYAN);

            playerIcon = new TheChara("img/player.png");
            playerIcon.setLocation(100, 100);

            enemyIcon = new TheChara("img/enemy.png");
            enemyIcon.setLocation(800, 100);

            JPanel arena = new JPanel(null);
            arena.setBackground(Color.BLACK);

            arena.add(playerIcon);
            arena.add(enemyIcon);
            
            frame.add(arena, BorderLayout.CENTER);

            frame.setVisible(true);
        });
    }
}