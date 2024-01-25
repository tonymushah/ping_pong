package objects;

import structures.Ping_Pong;

import java.awt.*;

public class Player extends Rectangle{
    private Ping_Pong gamePong;
    int points;
    public void setGamePong(Ping_Pong gamePong) {
        this.gamePong = gamePong;
    }
    public Ping_Pong getGamePong() {
        return gamePong;
    }
    public Player(Ping_Pong gamePong){
        this.setGamePong(gamePong);
    }
    public int distance(Ball to_use){
        int distance = (int) Math.sqrt(Math.pow((this.getX() - to_use.getX()), 2) + Math.pow((this.getY() - to_use.getY()), 2));
        //System.out.println("distance = " + distance);
        return distance;
    }
    public void move_Left(){
        int x_u = this.x - 10;
        if(x_u > 0 && x_u < this.gamePong.getTablePong().getSizex()){
            this.setLocation(x_u, this.y);
        }
    }
    public int getPoints() {
        return points;
    }
    public void addPoint(){
        this.points++;
    }
    public void move_Right(){
        int x_u = this.x + 10;
        if(x_u > 0 && x_u < this.gamePong.getTablePong().getSizex()){
            this.setLocation(x_u, this.y);
        }
    }
}
