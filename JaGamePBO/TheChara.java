import javax.swing.*;
import java.awt.*;

public class TheChara extends JPanel{
        Image img;

    public TheChara(String CharaPath) {
        img = new ImageIcon(CharaPath).getImage();
        setSize(80, 80);
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
    }
}