package com.roman.AirHockey.Game;


import java.awt.*;
import java.awt.image.BufferedImage;

public class Field implements GameComponent {
    public static final int BORDER_SIZE = 15;
    private BufferedImage background;

    public void draw(Graphics2D g) {
        g.drawImage(background, 0, 0, null);
    }

    public void update() {
    }

    public void setTexture(BufferedImage image) {
        this.background = image;
    }
}
