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
    private ArrayList<Tank>enemyTanks = new ArrayList<>();
    private ArrayList<wall>walls = new ArrayList<>();

    GameClient() {
        this(1000, 800);
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
        backGround = Tools.getImage("a.jpg");
        Image[] brickImage={Tools.getImage("brick.png")};

        Image[] iTankImage = new Image[8];
        Image[] eTankImage = new Image[8];

        String[] sub = {"U","D","L","R","LU","LD","RD","RU"};
        for(int i= 0; i<iTankImage.length;i++){
            iTankImage[i] = Tools.getImage("itank"+sub[i]+".png");
            eTankImage[i] = Tools.getImage("etank"+sub[i]+".png");

        }

         playerTank = new Tank(500, 100, Direction.DOWN,iTankImage);


        for(int i=0;i<3;i++){
            for(int j=0;j<4;j++){
                enemyTanks.add(new Tank(350+j*90,250+80*i,Direction.UP,true,eTankImage));
            }
        }

        walls.add(new wall(265,200,true,15,brickImage));
        walls.add(new wall(200,100,false,16,brickImage));
        walls.add(new wall(750,100,false,16,brickImage));
    }


    @Override
    protected void paintComponent(Graphics g) {

        g.setColor(Color.GRAY);
        g.fillRect(0,0,screenWidth,screenHeight);
        g.drawImage(backGround,0,0,null);
        playerTank.draw(g);

        for(Tank tank:enemyTanks){
            tank.draw(g);
        }
        for(wall wall:walls){
            wall.draw(g);
        }

        //super.paintComponent(g);
        //image object


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
