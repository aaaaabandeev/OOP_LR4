import java.awt.*;
import javax.swing.*;

public class Main extends JPanel {
    private int pointX = 10;
    private int pointY = 100;
    private int lineX1 = 50;
    private int lineY1 = 200;
    private int lineX2 = 150;
    private int lineY2 = 200;
    private int angle = 0;

    public Main() {
        Timer timer = new Timer(50, e -> {
            pointX += 2;
            if (pointX > 190) {
                pointX = 10;
            }
            lineX1 += 2;
            lineX2 -= 2;
            if (lineX1 > 190) {
                lineX1 = 50;
                lineX2 = 150;
            }
            angle += 5;
            if (angle == 360) {
                angle = 0;
            }
            repaint();
        });
        timer.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.drawLine(10, 100, 190, 100);
        g.fillOval(pointX, pointY, 5, 5);

        int endX = (int)(50 + 50 * Math.cos(Math.toRadians(angle)));
        int endY = (int)(200 + 50 * Math.sin(Math.toRadians(angle)));
        g.drawLine(50, 200, endX, endY);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Moving Lines");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Main movingLines = new Main();
        frame.add(movingLines);
        frame.setSize(400, 300);
        frame.setVisible(true);
    }
}
