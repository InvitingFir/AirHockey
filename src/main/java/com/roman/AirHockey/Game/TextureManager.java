package com.roman.AirHockey.Game;

import com.roman.AirHockey.Panels.GamePlayPanel;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class TextureManager {
    public static final String BASIC = "/Textures/Basic";
    public static final String REALISTIC = "/Textures/Realistic";

    public static final String PUCK = "/Puck.png";
    public static final String UPPER_PLAYER = "/UpperPlayer.png";
    public static final String LOWER_PLAYER = "/LowerPlayer.png";
    public static final String FIELD = "/Field.png";

    private GameComponent[] components;

    private String currentTextureType;

    public TextureManager(GameComponent[] components) {
        currentTextureType = BASIC;
        this.components = components;
    }

    public BufferedImage getPuckImage() throws IOException {
        return ImageIO.read(getClass().getResourceAsStream(currentTextureType + PUCK));
    }

    public BufferedImage getFieldImage() throws IOException {
        return ImageIO.read(getClass().getResourceAsStream(currentTextureType + FIELD));
    }

    public BufferedImage getUpperPlayerImage() throws IOException {
        return ImageIO.read(getClass().getResourceAsStream(currentTextureType + UPPER_PLAYER));
    }

    public BufferedImage getLowerPlayerImage() throws IOException {
        return ImageIO.read(getClass().getResourceAsStream(currentTextureType + LOWER_PLAYER));
    }

    public void updateTextures(String Texture) {
        try {
            if (Texture.equals(this.currentTextureType)) {
                currentTextureType = Texture;
                components[GamePlayPanel.FIELD].setTexture(getFieldImage());
                components[GamePlayPanel.PUCK].setTexture(getPuckImage());
                components[GamePlayPanel.UPPER_PLAYER].setTexture(getUpperPlayerImage());
                components[GamePlayPanel.LOWER_PLAYER].setTexture(getLowerPlayerImage());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
