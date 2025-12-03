import javax.swing.*;
import java.awt.*;

public class SimpleWindow {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Mijan no Windoosu");

        final int[] hp = {100};
        frame.setSize(1200, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLayout(new BorderLayout());

        JLabel hpLabel = new JLabel("HP: " + hp[0], SwingConstants.CENTER);
        frame.add(hpLabel, BorderLayout.NORTH);

        JTextArea log = new JTextArea();
        JScrollPane scroll = new JScrollPane(log);
        frame.add(scroll, BorderLayout.SOUTH);

        JPanel panelBtn = new JPanel();
        panelBtn.setLayout(new GridLayout(2, 1));
        frame.add(panelBtn, BorderLayout.EAST);

        JButton atkButton = new JButton("Attack");
        JButton healButton = new JButton("Heal");

        panelBtn.add(atkButton);
        panelBtn.add(healButton);

        JPanel centerPanel = new JPanel();
        frame.add(centerPanel, BorderLayout.CENTER);

        atkButton.addActionListener(e -> {
            hp[0] -= 10;
            if (hp[0] < 0) hp[0] = 0;
            hpLabel.setText("HP: " + hp[0]);
        });

        healButton.addActionListener(e -> {
            hp[0] += 10;
            if (hp[0] >= 100) hp[0] = 100;
            hpLabel.setText("HP: " + hp[0]);
        });

        frame.setVisible(true);
    }
}