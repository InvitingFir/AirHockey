package com.roman.AirHockey.Panels;

import java.awt.*;
import java.util.List;

public class GameStateManager {
    public static final int NUM_OF_PANELS = 3;
    public static final int MAIN_MENU = 0;
    public static final int GAME_PLAY = 1;
    public static final int SETTINGS = 2;
    public static final int PAUSE = 3;

    private List<GamePanel> panelArray;
    private int currentPanel = MAIN_MENU;

    public void setPanelArray(List<GamePanel> panelArray) {
        this.panelArray = panelArray;
    }

    public void update() {
        panelArray.get(currentPanel).update();
    }

    public void redraw(Graphics2D g) {
        panelArray.get(currentPanel).redraw(g);
    }

    public void updateGamePlayPanel(GamePanel gamePlayPanel) {
        panelArray.set(GAME_PLAY, gamePlayPanel);
    }

    public void swapPanel(int newPanel) {
        this.currentPanel = newPanel;
    }

    public void keyPressed(int key) {
        panelArray.get(currentPanel).keyPressed(key);
    }
}
