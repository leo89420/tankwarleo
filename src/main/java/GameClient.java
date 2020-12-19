import javax.swing.*;
import java.awt.*;
public class GameClient extends JComponent {
        private int screenWidth;
        private int screenHeight;
    GameClient(){
        this.setPreferredSize(new Dimension(800,600));

    }

    GameClient(int screenWidth,int screenHeight ){
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;

        this.setPreferredSize(new Dimension(screenWidth , screenHeight));
    }

    @Override
    public void paintComponents(Graphics g) {
        super.paintComponents(g);
        g.drawImage(new ImageIcon("assets/images/itankD.png").getImage(),
                100,100,null);
    }
}
