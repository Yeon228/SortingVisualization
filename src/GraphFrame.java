import javax.sound.sampled.LineUnavailableException;
import javax.swing.*;
import java.awt.*;

class GraphFrame extends JPanel {
    public GraphFrame() {
        setSize(500, 500);
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        for (int i = 0; i < Main.arr.length; i++) {
            g.drawLine((i * 5), 500, (i * 5), 500 - Main.arr[i] * 5);
            g.drawLine((i * 5) + 1, 500, (i * 5) + 1, 500 - Main.arr[i] * 5);
            g.drawLine((i * 5) + 2, 500, (i * 5) + 2, 500 - Main.arr[i] * 5);
            g.drawLine((i * 5) + 3, 500, (i * 5) + 3, 500 - Main.arr[i] * 5);
            g.drawLine((i * 5) + 4, 500, (i * 5) + 4, 500 - Main.arr[i] * 5);
        }
    }

    @Override
    public void update(Graphics g) {
        paint(g);
    }
}