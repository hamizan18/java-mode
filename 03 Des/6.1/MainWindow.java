import javax.swing.*;
import java.awt.*;

public class MainWindow {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Mijan no windowusu");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        ImagePanel panelGambar = new ImagePanel();
        frame.add(panelGambar, BorderLayout.CENTER);

        frame.setVisible(true);
    }
}