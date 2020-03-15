package com.roman.AirHockey.GamePanels;

import com.roman.AirHockey.Main.MainPanel;

import java.awt.*;

public class GameStateManager {
    public static final int NUM_OF_PANELS = 3;
    public static final int MAINMENU = 0;
    public static final int GAMEPLAY = 1;

    private GamePanel GamePlay;
    private GamePanel MainMenu;
    private GamePanel [] panelArray;
    private int currentPanel = 0;

    public GameStateManager(){
        this.panelArray = new GamePanel[NUM_OF_PANELS];
        panelArray[MAINMENU] = new GameplayPanel(this);
        //panelArray[GAMEPLAY] =
    }

    public void update(){
        panelArray[currentPanel].update();
    }

    public void redraw(Graphics2D g){
        panelArray[currentPanel].redraw(g);
    }
}
