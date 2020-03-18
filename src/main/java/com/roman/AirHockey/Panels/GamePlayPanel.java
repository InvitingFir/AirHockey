package com.roman.AirHockey.Panels;

import com.roman.AirHockey.Game.*;
import com.roman.AirHockey.Game.Player.Players.Bot;
import com.roman.AirHockey.Game.Player.Players.Player;
import com.roman.AirHockey.Game.Player.Players.PlayerPattern;
import com.roman.AirHockey.Game.Player.Puck;
import com.roman.AirHockey.Game.ScoreManager.ScoreManager;

import java.awt.*;

public class GamePlayPanel implements GamePanel {
    public static final int FIELD = 0;
    public static final int PUCK = 6;
    public static final int UPPER_PLAYER = 7;
    public static final int LOWER_PLAYER = 3;
    public static final int GATE1 = 4;
    public static final int GATE2 = 5;
    public static final int SCORE1 = 1;
    public static final int SCORE2 = 2;

    public static final int NUM_OF_COMPONENTS = 8;


    private GameComponent[] components;
    private TextureManager textureManager;

    private GameStateManager gsm;

    public GamePlayPanel(GameStateManager gsm) {
        this.gsm = gsm;
        Gate[] gates = new Gate[2];
        PlayerPattern[] players = new PlayerPattern[2];
        this.components = new GameComponent[NUM_OF_COMPONENTS];
        components[FIELD] = new Field();
        components[PUCK] = new Puck(players, gates);
        components[UPPER_PLAYER] = players[0] = new Bot(3, (Puck) components[PUCK]);
        components[LOWER_PLAYER] = players[1] = new Player();
        components[GATE1] = gates[0] = new Gate(players[0]);
        components[GATE2] = gates[1] = new Gate(players[1]);
        components[SCORE1] = new ScoreManager.ScorePanel(PlayerPattern.LOWER);
        components[SCORE2] = new ScoreManager.ScorePanel(PlayerPattern.UPPER);
        textureManager = new TextureManager(components);
        ScoreManager panel = new ScoreManager();
        updateTextures(TextureManager.BASIC);
    }

    public void update() {
        for (GameComponent g : components) {
            g.update();
        }
    }

    public void redraw(Graphics2D g) {
        for (GameComponent gg : components) {
            gg.draw(g);
        }
    }

    public void updateTextures(String texture) {
        textureManager.updateTextures(texture);
    }
}
