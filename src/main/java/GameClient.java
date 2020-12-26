import object.Direction;
import object.Tank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class GameClient extends JComponent {

    private int screenWidth;
    private int screenHeight;


    private Tank playerTank;
    private boolean stop;

    GameClient() {
        this(800, 600);
    }

    public GameClient(int screenWidth, int screenHeight) {
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        init();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while(!stop){
                    //更新遊戲畫面
                    repaint();
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

    }

    public void init(){
        playerTank=new Tank(400,300, Direction.DOWN);
    }

    @Override
    protected void paintComponent(Graphics g) {
        //super.paintComponent(g);
        //image object
        g.setColor(Color.black);
        g.fillRect(0,0,screenWidth,screenHeight);
        playerTank.draw(g);

    }

    public void keyPressed(KeyEvent e){
        boolean[]dirs=playerTank.getDirs();
        switch (e.getKeyCode()){

            case KeyEvent.VK_UP:
                dirs[0]=true;
                //playerTank.setY(playerTank.getY()-playerTank.getSpeed());
                break;
            case KeyEvent.VK_DOWN:
                dirs[1]=true;
                //playerTank.setY(playerTank.getY()+playerTank.getSpeed());
                break;

            case KeyEvent.VK_LEFT:
                dirs[2]=true;
                //playerTank.setX(playerTank.getX()-playerTank.getSpeed());
                break;

            case KeyEvent.VK_RIGHT:
                dirs[3]=true;
                //playerTank.setX(playerTank.getX()+playerTank.getSpeed());
                break;
        }

        playerTank.move();


        //repaint();

    }

    public void keyReleased(KeyEvent e) {
        boolean[]dirs=playerTank.getDirs();
        switch (e.getKeyCode()){

            case KeyEvent.VK_UP:
                dirs[0]=false;
                //playerTank.setY(playerTank.getY()-playerTank.getSpeed());
                break;
            case KeyEvent.VK_DOWN:
                dirs[1]=false;
                //playerTank.setY(playerTank.getY()+playerTank.getSpeed());
                break;

            case KeyEvent.VK_LEFT:
                dirs[2]=false;
                //playerTank.setX(playerTank.getX()-playerTank.getSpeed());
                break;

            case KeyEvent.VK_RIGHT:
                dirs[3]=false;
                //playerTank.setX(playerTank.getX()+playerTank.getSpeed());
                break;
        }
    }
}
