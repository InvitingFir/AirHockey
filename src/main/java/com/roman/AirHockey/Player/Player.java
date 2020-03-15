package com.roman.AirHockey.Player;

import com.roman.AirHockey.FieldParts.Field;
import com.roman.AirHockey.Main.MainPanel;
import com.roman.AirHockey.Util.Vector;

import java.awt.*;

public class Player implements MovableGamePart {

    protected int radius;
    protected int x;
    protected int y;
    protected Color color;
    protected double speed;

    public Player(int x, int y, int radius){
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.speed = 0;
        color = Color.GRAY;
    }

    public void update(){
        int x = MainPanel.getMouseX();
        int y = MainPanel.getMouseY();
        Vector vector = new Vector(this.x, this.y, x, y);
        if(x-radius >= Field.BORDER_SIZE && x+radius <= MainPanel.WIDTH- Field.BORDER_SIZE) {
            if(y-radius >= MainPanel.HEIGHT/2 && y+radius <= MainPanel.HEIGHT-Field.BORDER_SIZE) {
                this.y = y;
                this.x = x;
                this.speed = vector.getLength();
            }
        }
    }

    public void draw(Graphics2D g){
        g.setColor(color);
        g.fillOval(x-radius, y-radius, radius*2, radius*2);
    }


    public int getX(){ return x;}

    public int getY(){ return y;}

    public int getRadius(){ return radius;}

    public double getSpeed() { return speed; }
}
