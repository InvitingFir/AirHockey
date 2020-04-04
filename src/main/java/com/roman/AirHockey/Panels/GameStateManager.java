package com.roman.AirHockey.Panels;

import com.roman.AirHockey.Game.GamePlayPanel;
import com.roman.AirHockey.MainMenu.MainMenuPanel;
import com.roman.AirHockey.Settings.SettingsPanel;

import java.awt.*;

public class GameStateManager {
    public static final int NUM_OF_PANELS = 3;
    public static final int MAIN_MENU = 0;
    public static final int GAME_PLAY = 1;
    public static final int SETTINGS = 2;
    public static final int PAUSE = 3;

    private GamePanel[] panelArray;
    private int currentPanel = MAIN_MENU;

    public GameStateManager() {
        this.panelArray = new GamePanel[NUM_OF_PANELS];
        panelArray[GAME_PLAY] = new GamePlayPanel(this);
        panelArray[MAIN_MENU] = new MainMenuPanel(this);
        panelArray[SETTINGS] = new SettingsPanel(this);
    }

    public void update() {
        panelArray[currentPanel].update();
    }

    public void redraw(Graphics2D g) {
        panelArray[currentPanel].redraw(g);
    }

    public void updateGamePlayPanel(GamePanel gamePlayPanel) {
        panelArray[GAME_PLAY] = gamePlayPanel;
    }

    public void swapPanel(int newPanel) {
        this.currentPanel = newPanel;
    }

    public void keyPressed(int key) {
        panelArray[currentPanel].keyPressed(key);
    }
}
