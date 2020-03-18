package com.roman.AirHockey.Game;

import java.awt.*;
import java.awt.image.BufferedImage;

public interface GameComponent {
    void draw(Graphics2D g);

    void update();

    void setTexture(BufferedImage image);
}
