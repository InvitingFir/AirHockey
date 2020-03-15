package com.roman.AirHockey.Player;

import com.roman.AirHockey.FieldParts.Field;
import com.roman.AirHockey.FieldParts.Gate;
import com.roman.AirHockey.FieldParts.ScorePanel;
import com.roman.AirHockey.Main.MainPanel;
import com.roman.AirHockey.Player.Players.PlayerPattern;
import com.roman.AirHockey.Util.Vector;

import java.awt.*;
import java.util.ArrayList;

public class Puck {
    public static final double PUCK_ACCELERATION = 0.995;
    public static final int SPEED_LIMIT = 70;
    public static final int BASIC_X = MainPanel.WIDTH/2;
    public static final int START_Y = MainPanel.HEIGHT/2;

    private int puckX;
    private int puckY;
    private double lastX;
    private double lastY;
    private double deltaX;
    private double deltaY;
    private double puckAngle;
    private double puckSpeed;
    private int radius;
    private Color puckColor;

    private ArrayList<PlayerPattern> PlayerArray;
    private Gate[] gates;

    public Puck(int radius, ArrayList<PlayerPattern> PlayerArray, Gate[] gates){
        gameSetup();
        this.radius = radius;
        this.PlayerArray = PlayerArray;
        this.puckAngle = 15*Math.PI/8;
        this.puckColor = Color.MAGENTA;
        this.gates = gates;
        lastCoordinatesUpdate();
    }

    private void gameSetup(){
        this.puckX = BASIC_X;
        this.puckY = START_Y;
        this.puckSpeed = 0;
        lastCoordinatesUpdate();
    }

    public void draw(Graphics2D g){
        g.setColor(puckColor);
        g.fillArc(puckX-radius, puckY-radius, 2*radius, 2*radius, 0, 360);
    }

    public void update(){
        puckPositionUpdate();
        borderCollision();
        for (Gate g: gates)goalCheck(g);
        for (PlayerPattern p: PlayerArray) { playerCollision(p); }
    }


    private void borderCollision(){
        if (puckX - radius <= Field.BORDER_SIZE) {        //Western Field
            puckAngle = (3 * Math.PI - puckAngle) % (2 * Math.PI);
            puckX = Field.BORDER_SIZE + 1 + radius;
            lastCoordinatesUpdate();
        } else if (puckX + radius >= MainPanel.WIDTH - Field.BORDER_SIZE) {        //Eastern Field
            puckAngle = (3 * Math.PI - puckAngle) % (2 * Math.PI);
            puckX = MainPanel.WIDTH - Field.BORDER_SIZE - radius - 1;
            lastCoordinatesUpdate();
        } else if (puckY + radius >= MainPanel.HEIGHT - Field.BORDER_SIZE) {        //Southern Field
            puckAngle = (2 * Math.PI - puckAngle) % (2 * Math.PI);
            puckY = MainPanel.HEIGHT - Field.BORDER_SIZE - radius - 1;
            lastCoordinatesUpdate();
        } else if (puckY - radius <= Field.BORDER_SIZE) {         //Northern Field
            puckAngle = (2 * Math.PI - puckAngle) % (2 * Math.PI);
            puckY = Field.BORDER_SIZE + 1 + radius;
            lastCoordinatesUpdate();
        }
    }

    private void playerCollision(PlayerPattern player){
        Vector distance = new Vector(player.getX(), player.getY(), puckX, puckY);
        Vector puck = new Vector(lastX, lastY, puckX, puckY);
        if(distance.getLength()<= PlayerPattern.RADIUS+radius) {
            if((puckSpeed < player.getSpeed()) || (Vector.angleBetweenVectors(distance, puck) <= Math.PI/2)) {
                puckAngle = distance.getAngle();
                puckSpeed +=player.getSpeed()%SPEED_LIMIT;
            }
            else {
                puckAngle = Math.PI + 2 * distance.getAngle() - puckAngle;
                puckSpeed = (puckSpeed + player.getSpeed()) % SPEED_LIMIT;
            }
            puckX += Math.round((radius + PlayerPattern.RADIUS - distance.getLength() + 2) * Math.cos(puckAngle));
            puckY += Math.round((radius + PlayerPattern.RADIUS - distance.getLength() + 2) * Math.sin(puckAngle));
            lastCoordinatesUpdate();
        }
    }

    private boolean goalCheck(Gate gate){
        if(this.puckX-radius > gate.getX1() && this.puckX+radius < gate.getX2()) {
            if (Math.abs(this.puckY - gate.getY()) <= Field.BORDER_SIZE + this.radius) {
                ScorePanel.updateScore(gate.getOwner());
                gameSetup();
                return false;
            }
        }
        return true;
    }

    private void puckPositionUpdate(){
        puckSpeed*=PUCK_ACCELERATION;
        deltaX += Math.cos(puckAngle)*puckSpeed;
        deltaY += Math.sin(puckAngle)*puckSpeed;
        puckX = (int)(Math.round(lastX + deltaX));
        puckY = (int)(Math.round(lastY + deltaY));
    }

    private void lastCoordinatesUpdate(){
        lastX = puckX;
        lastY = puckY;
        deltaX = 0;
        deltaY = 0;
    }

    public int getX() {
        return puckX;
    }

    public int getY() {
        return puckY;
    }
}
