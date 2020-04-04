package com.roman.AirHockey.Game;


import com.roman.AirHockey.MainMenu.Background;

import java.awt.image.BufferedImage;

public class Field extends Background implements GameComponent {
    public static final int BORDER_SIZE = 15;

    public void update() {
    }

    public void setTexture(BufferedImage image) {
        this.backgroundImage = image;
    }
}
