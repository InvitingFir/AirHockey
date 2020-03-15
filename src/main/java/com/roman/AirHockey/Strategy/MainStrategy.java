package com.roman.AirHockey.Strategy;

import com.roman.AirHockey.FieldParts.Field;
import com.roman.AirHockey.FieldParts.Gate;
import com.roman.AirHockey.Main.MainPanel;
import com.roman.AirHockey.Player.Bot;
import com.roman.AirHockey.Player.Player;
import com.roman.AirHockey.Player.Puck;
import com.roman.AirHockey.Util.Vector;

public class MainStrategy extends Strategy{
    public static final double BOT_ACCELERATION = 1.005;

    private double protectionFactor;
    private Vector movement;
    private int targetX;
    private int targetY;
    private double speed;

    public MainStrategy(Puck puck, Bot admin) {
        super(puck, admin);
        protectionFactor = (double)(Gate.getCurrentSize())/ (double)(Field.WIDTH);
        this.speed = admin.getSpeed();
    }

    public void update() {
        if(puck.getY()<= MainPanel.HEIGHT/2){
            attack();
        }
        else{
            protect();
        }
        updatePosition();
    }

    private void protect(){
        int x = MainPanel.WIDTH/2 - Gate.getCurrentSize()/2;
        targetX = 0;
        targetX += Math.round(x + puck.getX()*protectionFactor);
        targetY = Field.BORDER_SIZE+admin.getRadius()+5;
    }

    private void attack(){
        targetX = puck.getX();
        targetY = puck.getY();
    }

    private void updatePosition(){
        //if(speed < 40)speed = admin.getSpeed()*BOT_ACCELERATION;
        int x = admin.getX();
        int y = admin.getY();
        movement = new Vector(x, y, targetX, targetY);
        if(movement.getLength()>speed) {
            x += Math.round(speed*Math.cos(movement.getAngle()));
            y += Math.round(speed*Math.sin(movement.getAngle()));
            admin.setX(x);
            admin.setY(y);
        }
    }
}
