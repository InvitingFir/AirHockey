package com.roman.AirHockey.Game.Player;

import com.roman.AirHockey.Game.Field;
import com.roman.AirHockey.Game.GameComponent;
import com.roman.AirHockey.Game.Score;
import com.roman.AirHockey.Main.MainPanel;
import com.roman.AirHockey.Game.Player.Players.PlayerPattern;
import com.roman.AirHockey.Util.Vector;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Puck implements GameComponent {
    public static final double PUCK_ACCELERATION = 0.991;
    public static final int SPEED_LIMIT = 60;
    public static final int BASIC_X = MainPanel.WIDTH / 2;
    public static final int LOW_Y = 2 * MainPanel.HEIGHT / 3;
    public static final int HIGH_Y = MainPanel.HEIGHT / 3;

    private int puckX;
    private int puckY;
    private double lastX;
    private double lastY;
    private double deltaX;
    private double deltaY;
    private double puckAngle;
    private double puckSpeed;
    private int radius;
    private BufferedImage image;

    private PlayerPattern[] PlayerArray;
    private Score score;

    public Puck(PlayerPattern[] playerArray, Score score) {
        gameSetup(PlayerPattern.Side.LOWER);
        this.PlayerArray = playerArray;
        this.score = score;
        lastCoordinatesUpdate();
    }

    private void gameSetup(PlayerPattern.Side startY) {
        this.puckX = BASIC_X;
        this.puckSpeed = 0;
        if (startY == PlayerPattern.Side.UPPER) {
            this.puckY = HIGH_Y;
        } else if (startY == PlayerPattern.Side.LOWER) {
            this.puckY = LOW_Y;
        }
        lastCoordinatesUpdate();
    }

    public void draw(Graphics2D g) {
        g.drawImage(image, puckX - radius, puckY - radius, null);
    }

    @Override
    public void setTexture(BufferedImage image) {
        this.image = image;
        this.radius = image.getWidth() / 2;
    }

    public void update() {
        puckPositionUpdate();
        borderCollision();
        for (PlayerPattern p : PlayerArray) {
            playerCollision(p);
            goalCheck(p);
        }
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
        if (distance.getLength() <= player.getRadius() + radius) {
            if ((puckSpeed < player.getSpeed()) || (Vector.angleBetweenVectors(distance, puck) <= Math.PI / 2)) {
                puckAngle = distance.getAngle();
                if (puckSpeed < player.getSpeed())
                    puckSpeed = player.getSpeed();
            } else {
                puckAngle = Math.PI + 2 * distance.getAngle() - puckAngle;
                puckSpeed += player.getSpeed();
            }
            if (puckSpeed > SPEED_LIMIT) puckSpeed = SPEED_LIMIT;
            puckX += Math.round((radius + player.getRadius() - distance.getLength() + 2) * Math.cos(puckAngle));
            puckY += Math.round((radius + player.getRadius() - distance.getLength() + 2) * Math.sin(puckAngle));
            lastCoordinatesUpdate();
        }
    }

    private void goalCheck(PlayerPattern p) {
        PlayerPattern.Gate gate = p.getGate();
        if (this.puckX - radius > gate.getX1() && this.puckX + radius < gate.getX2()) {
            if (Math.abs(this.puckY - gate.getY()) <= Field.BORDER_SIZE + this.radius) {
                score.updateScore(p.getPlayerSide());
                gameSetup(p.getPlayerSide());
            }
        }
    }

    private void puckPositionUpdate() {
        puckSpeed *= PUCK_ACCELERATION;
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

    public void setPlayer(PlayerPattern.Side side, PlayerPattern player) {
        for (PlayerPattern p : PlayerArray) {
            if (p.getPlayerSide() == side) p = player;
            break;
        }
    }
}
