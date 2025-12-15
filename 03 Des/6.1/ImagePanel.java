import javax.swing.*;
import java.awt.*;

public class ImagePanel extends JPanel {

    Image img;

    public ImagePanel() {
        img = new ImageIcon("img/kitten.png").getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, 0, 0, 50, 50, this);
    }
}
