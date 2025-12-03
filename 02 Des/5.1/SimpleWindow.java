import javax.swing.JFrame;

public class SimpleWindow {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Mijan no Window");

        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
}