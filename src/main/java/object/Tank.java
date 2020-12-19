package object;

import javax.swing.*;
import java.awt.*;

public class Tank {

    public final static  int UP = 0;
    public final static  int DOWN = 1;
    public final static  int LEFT = 2;
    public final static  int RIGHT = 3;

    private int x;
    private int y;
    private int speed;
    private Direction direction;

    public Tank(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        speed = 5;
    }
    public Direction Direction(){
        return  direction;
    }

    public void setDirection(Direction direction){
        this.direction = direction;
    }

        public int getX() {
        return x;
    }
    public void setX(int x){
        this.x = x;
    }

    public int getY() {
        return y;
    }
    public  void setY(int Y){
        this.y = y;
    }

    public Direction getDirection() {
        return direction;
    }
    public Image getImage( ){
        if(direction==Direction.UP){
            return new ImageIcon("assets/images/itankU.png").getImage();

        }if(direction==Direction.DOWN){
            return new ImageIcon("assets/images/itankD.png").getImage();
        }if(direction==Direction.LEFT){
            return new ImageIcon("assets/images/itankL.png").getImage();
        }if(direction==Direction.RIGHT){
            return new ImageIcon("assets/images/itankR.png").getImage();
        }
        if(direction==Direction.UP_RIGHT){
            return new ImageIcon("assets/images/itankR.png").getImage();
        }if(direction==Direction.DOWN_LEFT){
            return new ImageIcon("assets/images/itankR.png").getImage();
        }if(direction==Direction.DOWN_RIGHT){
            return new ImageIcon("assets/images/itankR.png").getImage();
        }if(direction==Direction.UP_LEFT){
            return new ImageIcon("assets/images/itankR.png").getImage();
        }
        return null;

    }
    public void move(){
        switch (direction){
            case UP:
                y+=speed;
                break;
            case DOWN:
                y-=speed;
                break;
            case LEFT:
                x+=speed;
                break;
            case RIGHT:
                x-=speed;
                break;
        }
    }

}
