import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame     = new JFrame("Mijan no windousu");
        ImagePanel image = new ImagePanel();
        Direction WASD   = new Direction(image);
        JButton rightBtn = new JButton("Right");
        JButton leftBtn  = new JButton("Left");
        JButton upBtn    = new JButton("Up");
        JButton downBtn  = new JButton("Down");

        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLayout(new BorderLayout());

        JPanel btnPanel = new JPanel();
        btnPanel.setLayout(new GridLayout(1, 4));

        frame.add(btnPanel, BorderLayout.SOUTH);

        btnPanel.add(leftBtn);
        btnPanel.add(upBtn);
        btnPanel.add(downBtn);
        btnPanel.add(rightBtn);

        WASD.turnRight(rightBtn);
        WASD.turnLeft(leftBtn);
        WASD.turnUp(upBtn);
        WASD.turnDown(downBtn);

        frame.add(image, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}