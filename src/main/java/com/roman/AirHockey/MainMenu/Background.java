package com.roman.AirHockey.MainMenu;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Background {
    protected BufferedImage backgroundImage;

    public Background() {
    }

    public Background(String path) {
        try {
            this.backgroundImage = ImageIO.read(getClass().getResourceAsStream(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g) {
        g.drawImage(backgroundImage, 0, 0, null);
    }
}
