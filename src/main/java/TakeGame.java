import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TakeGame {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        GameClient gameClient = new GameClient(800,600);
        frame.add(gameClient);
        frame.setTitle("坦克大戰!");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();

        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
            }
        });
    }

}
