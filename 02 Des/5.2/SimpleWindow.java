import javax.swing.*;

public class SimpleWindow {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Mijann no Windowsu");

        final int[] hp = {100};

        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel hpLabel = new JLabel("HP: " + hp[0]);
        hpLabel.setBounds(20, 20, 200, 30);
        frame.add(hpLabel);

        JButton attackBtn = new JButton("Attack");
        attackBtn.setBounds(20, 70, 100, 30);
        frame.add(attackBtn);

        attackBtn.addActionListener(e -> {
            hp[0] -= 10;
            if (hp[0] < 0) hp[0] = 0;
            hpLabel.setText("HP: " + hp[0]);
        });

        frame.setVisible(true);
    }
}