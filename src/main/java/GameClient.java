import object.GameObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class GameClient extends JComponent {

    private final int screenWidth;
    private final int screenHeight;


    private Tank playerTank;
    private Image backGround;
    private boolean stop;
    //private ArrayList<Tank>enemyTanks = new ArrayList<>();
    //private ArrayList<wall>walls = new ArrayList<>();


    private ArrayList<GameObject>GameObjects= new ArrayList<>();
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

    public ArrayList<GameObject> getGameObjects() {
        return GameObjects;
    }

    public void init(){
        backGround = Tools.getImage("a.jpg");
        Image[] brickImage={Tools.getImage("brick.png")};

        Image[] iTankImage = new Image[8];
        Image[] eTankImage = new Image[8];

        String[] sub = {"U","D","L","R","LU","LD","RD","RU"};
        for(int i= 0; i<iTankImage.length;i++){
            iTankImage[i] = Tools.getImage("itank"+sub[i]+".png");
            eTankImage[i] = Tools.getImage("etank"+sub[i]+".png");

        }

         playerTank = new Tank(400, 100, Direction.DOWN,iTankImage);
        GameObjects.add(playerTank);

        for(int i=0;i<3;i++){
            for(int j=0;j<4;j++){
                GameObjects.add(new Tank(350+j*110,300+100*i,Direction.UP,true,eTankImage));
            }
        }

        GameObjects.add(new wall(170,150,true,18,brickImage));
        GameObjects.add(new wall(70,100,false,14,brickImage));
        GameObjects.add(new wall(800,100,false,14,brickImage));
    }


    @Override
    protected void paintComponent(Graphics g) {

        g.setColor(Color.GRAY);
        g.fillRect(0,0,screenWidth,screenHeight);
        g.drawImage(backGround,0,0,null);
        //playerTank.draw(g);

        for(GameObject object:GameObjects){
            object.draw(g);
        }
//        for(Tank tank:enemyTanks){
//            tank.draw(g);
//        }
//        for(wall wall:walls){
//            wall.draw(g);
//        }

        //super.paintComponent(g);
        //image object


    }

    public int getScreenWidth() {
        return screenWidth;
    }

    public int getScreenHeight() {
        return screenHeight;
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

        //playerTank.move();


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
