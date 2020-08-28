package cc.retzlaff.timon;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main {
    private static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public static int ScreenHeight = (int) screenSize.getHeight();
    public static int ScreenWidth = (int) screenSize.getWidth();
    public static Player player = new Player(new Vector2(ScreenWidth/2, ScreenHeight/2), 5f, 3f, 0.5f, 'a', 'd', 'w', 's');
    public static JFrame frame = new JFrame("Test");
    public static void main(String[] args) {
        JPanel canvas = new Drawing();
        canvas.setSize(ScreenWidth, ScreenHeight);
        canvas.setDoubleBuffered(true);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setUndecorated(true);
        frame.add(canvas);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                player.keyPressed(e);
                if (e.getKeyChar() == 'q') {
                    System.exit(0);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                player.keyReleased(e);
            }
        });
    }
}


class Drawing extends JPanel {
    public void paint(Graphics g) {
        g.clearRect(0, 0, Main.ScreenWidth, Main.ScreenHeight);
        Main.player.update(g);
        this.repaint();
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
