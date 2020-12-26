import object.GameObject;

import javax.swing.*;
import java.awt.*;

public class wall extends GameObject {


    private boolean horizontal;
    private int bricks;


    public wall(int x, int y, boolean horizontal, int bricks,Image[] image){
        super(x, y, image);

        this.x=x;
        this.y=y;
        this.horizontal = horizontal;
        this.bricks = bricks;
    }
    public void draw(Graphics g){
        if(horizontal){
            for(int i = 0;i<bricks;i++){
                g.drawImage(image[0], x+i*image[0].getWidth(null),y,null);
            }
        }else {
            for(int i=0;i<bricks;i++){
                g.drawImage(image[0],x,y+i*image[0].getHeight(null),null);
            }
        }
    }
}
