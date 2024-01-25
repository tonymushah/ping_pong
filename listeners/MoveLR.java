package listeners;

import java.awt.event.*;
import objects.*;

public class MoveLR implements KeyListener{
    Player to_move;
    @Override
    public void keyPressed(KeyEvent arg0) {
        // TODO Auto-generated method stub
        switch (arg0.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                to_move.move_Left();
                break;
            case KeyEvent.VK_RIGHT:
                to_move.move_Right();
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
    public void setTo_move(Player to_move) {
        this.to_move = to_move;
    }
    public Player getTo_move() {
        return to_move;
    }
    public MoveLR(Player to_move){
        this.setTo_move(to_move);
    }
}
