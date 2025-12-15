import javax.swing.*;
import java.awt.*;

public class Direction {
    int increment = 0, decrement = 0;
    private ImagePanel direction;

    public Direction(ImagePanel direction) {
        this.direction = direction;
    }
    
    public void turnRight(JButton rightBtn) {
        rightBtn.addActionListener(e -> {
            increment = direction.getXpos() + 10;
            direction.setXpos(increment);
        });
    };

    public void turnLeft(JButton leftBtn) {
        leftBtn.addActionListener(e -> {
            decrement = direction.getXpos() - 10;
            direction.setXpos(decrement);
        });
    };

    public void turnDown(JButton downBtn) {
        downBtn.addActionListener(e -> {
            increment = direction.getYpos() + 10;
            direction.setYpos(increment);
        });
    };

    public void turnUp(JButton upBtn) {
        upBtn.addActionListener(e -> {
            decrement = direction.getYpos() - 10;
            direction.setYpos(decrement);
        });
    };
}