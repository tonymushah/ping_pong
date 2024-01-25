package listeners;

import java.awt.event.*;
import objects.*;

public class Launch_ball implements KeyListener{
    Ball to_launch;
    @Override
    public void keyPressed(KeyEvent arg0) {
        // TODO Auto-generated method stub
        switch (arg0.getKeyCode()) {
            case KeyEvent.VK_SPACE:
                this.to_launch.setCalled(1);
                break;
            default:
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent arg0) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void keyTyped(KeyEvent arg0) {
        // TODO Auto-generated method stub
        
    }
    public void setTo_launch(Ball to_launch) {
        this.to_launch = to_launch;
    }
    public Ball getTo_launch() {
        return to_launch;
    }
    public Launch_ball(Ball to_launch){
        this.setTo_launch(to_launch);
    }
}
