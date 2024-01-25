package structures;

import javax.swing.*;
import javax.swing.plaf.DimensionUIResource;

import listeners.*;
import objects.*;

public class  Ping_Pong extends JFrame{
    private Player[] gamers;
    Game_table tablePong;
    private Player last_winner;
    public Player[] getGamers() {
        return gamers;
    }
    public void setGamers(Player[] gamers) {
        this.gamers = gamers;
    }
    public void setLast_winner(Player last_winner) {
        this.last_winner = last_winner;
    }
    public Player getLast_winner() {
        return last_winner;
    }
    public void init_player(){
        this.gamers = new Player[2];
        for (int i = 0; i < this.gamers.length; i++) {
            this.gamers[i] = new Player(this);
            this.gamers[i].setSize(48, 16);
        }
        this.gamers[0].setLocation(250 - 20, 0);
        this.gamers[1].setLocation(250 - 20 , 450);
    }
    public void setTablePong(Game_table tablePong) {
        this.tablePong = tablePong;
    }
    public Game_table getTablePong() {
        return tablePong;
    }
    public void init_pongTable(){
        this.tablePong = new Game_table(this);
    }
    public void launch_graph(){
        this.setTitle("Ping Pong");
        this.init_player();
        this.init_pongTable();
        this.setAutoRequestFocus(true);
        //this.setAlwaysOnTop(false);
        //this.setFocusable(false);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(new DimensionUIResource(500, 500));
        //this.drawAllPlayer();
        this.addKeyListener(new MoveLR(this.gamers[1]));
        this.addKeyListener(new MoveQD(this.gamers[0]));
        this.addKeyListener(new Launch_ball(this.tablePong.getBaolina()));
        this.add(this.tablePong);
        this.setVisible(true);
    }
    public Ping_Pong(){
        this.launch_graph();
    }
}
