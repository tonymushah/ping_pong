package structures;

import javax.swing.*;
import javax.swing.plaf.DimensionUIResource;
import javax.swing.plaf.FontUIResource;

import java.awt.*;

import objects.*;

public class Game_table extends JPanel{
    private int sizex;
    private int sizey;
    Ping_Pong pongGame;
    private Ball baolina;
    public void setBaolina(Ball baolina) {
        this.baolina = baolina;
    }
    public Ball getBaolina() {
        return baolina;
    }
    public void setSizex(int sizex) {
        this.sizex = sizex;
    }
    public void setSizey(int sizey) {
        this.sizey = sizey;
    }
    public int getSizex() {
        return sizex;
    }
    public int getSizey() {
        return sizey;
    }
    public void setSizu(int sizex, int sizey){
        this.setSizex(sizex);
        this.setSizey(sizey);
    }
    public void setPongGame(Ping_Pong pongGame) {
        this.pongGame = pongGame;
    }
    public Ping_Pong getPongGame() {
        return pongGame;
    }
    public void init_g(){
        this.setSizu(500, 500);
        this.setPreferredSize(new DimensionUIResource(this.sizex, this.sizey));
    }
    public Game_table(Ping_Pong pongGame){
        this.setPongGame(pongGame);
        this.init_g();
        this.setBaolina(new Ball((this.sizex / 2) - 10, (this.sizey / 2) - 10, 15, this));
    }
    public void paint(Graphics gra){
        Graphics2D graph = (Graphics2D) gra;
        super.paint(graph);

        // NOTE the Structure

            // NOTE Line
            graph.setColor(Color.decode("#000"));
            graph.setStroke(new BasicStroke(1));
            graph.drawLine(10, 250, 490, 250);

            // NOTE player 0 points
            graph.setStroke(new BasicStroke(1));
            
            // NOTE FOnts
                graph.setFont(new FontUIResource("Arial", FontUIResource.BOLD, 15));

            // NOTE Player 1
            graph.setColor(Color.decode("#ff6a00"));
            graph.fillRect(this.pongGame.getGamers()[0].x, this.pongGame.getGamers()[0].y, (int) this.pongGame.getGamers()[0].getWidth(), (int) this.pongGame.getGamers()[0].getHeight());
            // NOTE player 1 points
            graph.drawString("" + this.pongGame.getGamers()[0].getPoints(), 0, 240);

            // NOTE Player 2
            graph.setColor(Color.decode("#005dff"));
            graph.fillRect(this.pongGame.getGamers()[1].x, this.pongGame.getGamers()[1].y, (int) this.pongGame.getGamers()[1].getWidth(), (int) this.pongGame.getGamers()[1].getHeight());
            // NOTE player 2 points
            graph.drawString("" + this.pongGame.getGamers()[1].getPoints(), 0, 260);

            // NOTE the Ball 
            graph.setColor(Color.decode("#089000"));
            graph.fillOval(this.baolina.x, this.baolina.y, this.baolina.width, this.baolina.height);

        // NOTE the refresing process
        try {
            Thread.sleep(10);
        } catch (Exception e) {
            //TODO: handle exception
        }
        this.baolina.move();
        this.repaint();
    }
}
