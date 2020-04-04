package com.roman.AirHockey.Game.Player.Players;

import com.roman.AirHockey.Game.Field;
import com.roman.AirHockey.Game.GameComponent;
import com.roman.AirHockey.Main.MainPanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class PlayerPattern implements GameComponent {
    public enum Side {LOWER, UPPER}

    ;
    protected Side playerSide;
    protected int x;
    protected int y;
    protected double speed;
    protected int radius;
    protected BufferedImage image;
    protected Gate gate;

    public PlayerPattern(Side side) {
        this.playerSide = side;
        this.gate = new Gate();
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

    public Side getPlayerSide() {
        return playerSide;
    }

    public int getRadius() {
        return radius;
    }

    private void initPosition() {
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

    public abstract void update();

    public void draw(Graphics2D g) {
        g.drawImage(image, x - radius, y - radius, null);
    }

    @Override
    public void setTexture(BufferedImage image) {
        this.image = image;
        this.radius = image.getWidth() / 2;
    }

    public Gate getGate() {
        return gate;
    }


    public class Gate {
        public static final int LENGTH = (MainPanel.WIDTH - 2 * Field.BORDER_SIZE) / 3;

        public int getX1() {
            return (MainPanel.WIDTH / 2) - (LENGTH / 2);
        }

        public int getX2() {
            return (MainPanel.WIDTH / 2) + (LENGTH / 2);
        }

        public int getY() {
            if (getPlayerSide() == Side.LOWER) {
                return MainPanel.HEIGHT - Field.BORDER_SIZE;
            } else if (getPlayerSide() == Side.UPPER) {
                return Field.BORDER_SIZE;
            }
            return 0;
        }
    }
}
