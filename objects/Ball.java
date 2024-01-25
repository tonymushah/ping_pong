package objects;

// NOTE Personal package import
import structures.Game_table;
import utilities.*;

// NOTE java import
import java.awt.*;
import java.util.*;

public class Ball extends Rectangle{
    /* 
        FINISHED make the player intercept system
        FINISHED Make the wining system
        FINISHED Make the ball Bouncing system
    */ 
    int angle; // NOTE it isn't the angle but the alignmnt priority 
    JAlignmnt alignmnt;
    int called;
    int init_x, init_y;
    int inv;
    private Game_table pongTable;
    public void setPongTable(Game_table pongTable) {
        this.pongTable = pongTable;
    }
    public void setAngle(int angle) {
        this.angle = angle;
    }
    public void setInit(int init_x, int init_y){
        this.init_x = init_x;
        this.init_y = init_y;
    }
    public void setInv(int inv) {
        this.inv = inv;
    }
    public int getInit_x() {
        return init_x;
    }
    public void setCalled(int called) {
        this.called = called;
    }
    public int getInit_y() {
        return init_y;
    }
    public int getAngle() {
        return angle;
    }
    public Game_table getPongTable() {
        return pongTable;
    }
    public void setAlignmnt(JAlignmnt alignmnt) {
        this.alignmnt = alignmnt;
    }
    public JAlignmnt getAlignmnt() {
        return alignmnt;
    }
    public Ball(int pos_x, int pos_y, int diameter, Game_table pongTable){
        super(pos_x, pos_y, diameter, diameter);
        this.setInit(pos_x, pos_y);
        this.setLocation(pos_x, pos_y);
        this.setPongTable(pongTable);
        this.setAlignmnt(new JAlignmnt());
    }
    public void init_(){
        if(this.pongTable.getPongGame().getLast_winner() == null){
            this.setLocation(this.init_x, this.init_y);
        }else{
            this.setLocation(this.pongTable.getPongGame().getLast_winner().x, this.pongTable.getPongGame().getLast_winner().y);
        }
        this.called = 0;
    }
    public void move(){
        if(called == 1){
            int[] direction = new int[2];
            Random rand = new Random();
            // BUG finishing inv condif
            // FINISHED this first one is for the begining
            if(this.x == this.init_x && this.y == this.init_y){
                if(this.getPongTable().getPongGame().getLast_winner() == null && this.angle == 0){
                    this.inv = Math.abs(rand.nextInt(2) % 2);
                }
            }else{
                // FINISHED Bouncing condition
                int player0 = this.pongTable.getPongGame().getGamers()[0].distance(this);
                int player1 = this.pongTable.getPongGame().getGamers()[1].distance(this);
                /*System.out.println("Distance player 0 = " + player0);
                System.out.println("Distance player 1 = " + player1);*/
                // FINISHED placed ball after winning
                /*
                    BUG the player 0 is always gone to the right
                */
                if(this.getPongTable().getPongGame().getLast_winner() != null){
                    this.setAngle(0);
                    if(this.getPongTable().getPongGame().getLast_winner() == this.getPongTable().getPongGame().getGamers()[0]){
                        this.inv = 1;
                    }else if(this.getPongTable().getPongGame().getLast_winner() == this.getPongTable().getPongGame().getGamers()[1]){
                        this.inv = 0;
                    }
                    this.getPongTable().getPongGame().setLast_winner(null);
                    // FINISHED 1 - Player 0
                }else if(player0 <= 25){
                    if(this.angle == 0 && this.inv == 0){
                        // FINISHED Random Boucing after that
                        switch (rand.nextInt(4) % 2) {
                            case 0:
                                this.inv = (this.inv + 1) % 2;
                                this.angle = 1;
                                break;
                            case 1:
                                this.angle = 3;
                                break;
                            default:
                                break;
                        }
                    }else{
                        // FINISHED Player bounce
                        int[] bouncy = alignmnt.bounce_WUD(this.angle, this.inv);
                        this.angle = bouncy[0];
                        this.inv = bouncy[1];
                    }
                // FINISHED 2 - Player 1
                }else if(player1 <= 25){
                    if(this.angle == 0 && this.inv == 1){
                        // FINISHED Random Boucing after that
                        switch (rand.nextInt(4) % 2) {
                            case 0:
                                this.inv = (this.inv + 1) % 2;
                                this.angle = 1;
                                break;
                            case 1:
                                this.angle = 3;
                                break;
                            default:
                                break;
                        }
                    }else{
                        // FINISHED Player bounce
                        int[] bouncy = alignmnt.bounce_WUD(this.angle, this.inv);
                        this.angle = bouncy[0];
                        this.inv = bouncy[1];
                    }
                // FINISHED 3 - left border
                // FINISHED 4 - rigth border
                }else if(this.x > (this.pongTable.getSizex() - 20) || this.x < 10){
                    int[] bouncy = alignmnt.bounce_WLR(this.angle, this.inv);
                    this.angle = bouncy[0];
                    this.inv = bouncy[1];
                // FINISHED winning
                }else if(this.y < 0){
                    this.pongTable.getPongGame().setLast_winner(this.pongTable.getPongGame().getGamers()[1]);
                    this.pongTable.getPongGame().getGamers()[1].addPoint();
                    this.init_();
                    return;
                }else if(this.y > (this.pongTable.getSizey())){
                    this.pongTable.getPongGame().setLast_winner(this.pongTable.getPongGame().getGamers()[0]);
                    this.pongTable.getPongGame().getGamers()[0].addPoint();
                    this.init_();
                    return;
                }
            }
            switch (this.inv) {
                case 0:
                    direction = this.alignmnt.getAlign(angle);
                    break;
                case 1:
                    direction = this.alignmnt.getinv_Align(angle);
                    break;
                default:
                    break;
            }
            // TODO the movement system
            this.setLocation(this.x + (direction[0] * 2), this.y + (direction[1] * 2));
        }
    }
}
