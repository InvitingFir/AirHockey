package com.roman.AirHockey.Game.Managers;

import com.roman.AirHockey.Game.GameComponent;
import com.roman.AirHockey.Game.GamePlayPanel;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class TextureManager {
    public static final String BASIC = "/GamePlay/Textures/Basic";
    public static final String REALISTIC = "/GamePlay/Textures/Realistic";

    public static final String PUCK = "/Puck.png";
    public static final String PLAYER1 = "/UpperPlayer.png";
    public static final String PLAYER2 = "/LowerPlayer.png";
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

    public BufferedImage getPlayer1Image() throws IOException {
        return ImageIO.read(getClass().getResourceAsStream(currentTextureType + PLAYER1));
    }

    public BufferedImage getPlayer2Image() throws IOException {
        return ImageIO.read(getClass().getResourceAsStream(currentTextureType + PLAYER2));
    }

    public void updateTextures(String Texture) {
        try {
            if (Texture.equals(this.currentTextureType)) {
                currentTextureType = Texture;
                components[GamePlayPanel.FIELD].setTexture(getFieldImage());
                components[GamePlayPanel.PUCK].setTexture(getPuckImage());
                components[GamePlayPanel.PLAYER1].setTexture(getPlayer1Image());
                components[GamePlayPanel.PLAYER2].setTexture(getPlayer2Image());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
