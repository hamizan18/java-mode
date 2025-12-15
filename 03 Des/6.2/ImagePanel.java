import javax.swing.*;
import java.awt.*;

public class ImagePanel extends JPanel {
    Image img;
    private int x;
    private int y;

    public ImagePanel() {
        img = new ImageIcon("img/kitten.png").getImage();
        x = 40;
        y = 100;
    }

    public int getXpos() {
        return x;
    }

    public int getYpos() {
        return y;
    }

    public void setXpos(int x) {
        if (x > 800) x = 800; 
        if (x < 0) x = 0; 
        this.x = x;
        repaint();
    }

    public void setYpos(int y) {
        if (y > 600) y = 600; 
        if (y < 0) x = 0;
        this.y = y;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, x, y, 50, 50, this);
    }
}