package com.roman.AirHockey.Game;

import com.roman.AirHockey.Game.Managers.*;
import com.roman.AirHockey.Game.Player.Players.*;
import com.roman.AirHockey.Game.Player.Puck;
import com.roman.AirHockey.Main.MainPanel;
import com.roman.AirHockey.Panels.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class GamePlayPanel implements GamePanel {
    public static final String ERROR_IMAGE_PATH = "/GamePlay/error.png";
    public static final int FIELD = 0;
    public static final int PUCK = 1;
    public static final int PLAYER1 = 2;
    public static final int PLAYER2 = 3;
    public static final int SCORE = 4;
    public static final int NUM_OF_COMPONENTS = 5;


    private GameComponent[] components;
    private TextureManager textureManager;
    private Score score;
    private GameStateManager gsm;
    private BufferedImage errorImage;

    public GamePlayPanel(GameStateManager gsm) {
        this.gsm = gsm;
        try {
            errorImage = ImageIO.read(getClass().getResourceAsStream(ERROR_IMAGE_PATH));
        } catch (IOException e) {
            e.printStackTrace();
        }
        init();
    }

    private void init() {
        PlayerPattern[] players = new PlayerPattern[2];
        score = new Score();
        this.components = new GameComponent[NUM_OF_COMPONENTS];
        this.textureManager = new TextureManager(components);

        components[FIELD] = new Field();
        components[PUCK] = new Puck(players, score);
        components[PLAYER1] = players[0] = new Player(PlayerPattern.Side.LOWER);
        components[PLAYER2] = players[1] = new Bot(3, (Puck) components[PUCK], PlayerPattern.Side.UPPER);
        components[SCORE] = score;
        updateTextures(TextureManager.BASIC);
    }

    public void update() {
        if (score.gameOver() != null) System.exit(0);
        if (MainPanel.isOnScreen()) {
            for (GameComponent g : components) {
                g.update();
            }
        }
    }

    public void redraw(Graphics2D g) {
        for (GameComponent gg : components) {
            gg.draw(g);
        }
        if (!MainPanel.isOnScreen()) {
            g.drawImage(errorImage, MainPanel.WIDTH / 4, MainPanel.HEIGHT / 2 - errorImage.getHeight() / 2, null);
        }
    }

    public void updateTextures(String texture) {
        textureManager.updateTextures(texture);
    }

    public void setBotSpeed(int speed) {
        Bot bot = (Bot) components[PLAYER2];
        bot.setSpeed(speed);
    }

    public void keyPressed(int key) {
        if (key == KeyEvent.VK_ESCAPE) {
            gsm.swapPanel(GameStateManager.MAIN_MENU);
        }
    }
}
