package com.roman.AirHockey.Game.Strategy;

import com.roman.AirHockey.Game.Field;
import com.roman.AirHockey.Game.Player.Players.PlayerPattern;
import com.roman.AirHockey.Main.MainPanel;
import com.roman.AirHockey.Game.Player.Players.Bot;
import com.roman.AirHockey.Game.Player.Puck;
import com.roman.AirHockey.Util.Vector;

public abstract class Strategy {
    protected Puck puck;
    protected Bot admin;

    protected double protectionFactor;
    protected Vector movement;
    protected int targetX;
    protected int targetY;

    public Strategy(Puck puck, Bot admin) {
        this.puck = puck;
        this.admin = admin;
        double a = PlayerPattern.Gate.LENGTH;
        double b = MainPanel.WIDTH - 2 * Field.BORDER_SIZE;
        protectionFactor = a / b;
    }

    public abstract void update();

    protected abstract void protect();

    protected void attack(){
        targetX = puck.getX();
        targetY = puck.getY();
    }

    protected void updatePosition(){
        double speed = admin.getSpeed();
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
