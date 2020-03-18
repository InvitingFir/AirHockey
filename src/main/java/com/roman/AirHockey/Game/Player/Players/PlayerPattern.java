package com.roman.AirHockey.Game.Player.Players;

import com.roman.AirHockey.Game.GameComponent;
import com.roman.AirHockey.Main.MainPanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class PlayerPattern implements GameComponent {
    public static final int LOWER = 0;
    public static final int UPPER = 1;

    private static boolean sideCounter = false;
    protected int playerSide;
    protected int x;
    protected int y;
    protected double speed;
    protected int radius;
    protected BufferedImage image;

    public PlayerPattern() {
        if (sideCounter) this.playerSide = LOWER;
        else this.playerSide = UPPER;
        sideCounter = !sideCounter;
        initPosition();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double getSpeed() {
        return speed;
    }

    public int getPlayerSide() {
        return playerSide;
    }

    public int getRadius() {
        return radius;
    }

    public abstract void update();

    public void draw(Graphics2D g) {
        g.drawImage(image, x - radius, y - radius, null);
    }

    @Override
    public void setTexture(BufferedImage image) {
        this.image = image;
        this.radius = image.getWidth() / 2;
    }

    public void initPosition() {
        this.x = MainPanel.WIDTH / 2;
        switch (playerSide) {
            case LOWER:
                setY(4 * MainPanel.HEIGHT / 5);
                break;
            case UPPER:
                setY(MainPanel.HEIGHT / 5);
                break;
        }
    }
}
