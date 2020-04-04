package com.roman.AirHockey.Settings;

import com.roman.AirHockey.Game.GamePlayPanel;
import com.roman.AirHockey.Panels.GamePanel;
import com.roman.AirHockey.Panels.GameStateManager;
import com.roman.AirHockey.Settings.SettingsItems.*;

import java.awt.*;
import java.awt.event.KeyEvent;

public class SettingsPanel implements GamePanel {
    public static final int LEVEL = 0;
    public static final int TEXTURES = 1;
    public static final int NUM_OF_OPTIONS = 2;

    private int chosenOption;

    private OptionBox[] options;
    private GameStateManager gsm;

    public SettingsPanel(GameStateManager gsm) {
        this.gsm = gsm;
        this.options = new OptionBox[NUM_OF_OPTIONS];
        options[LEVEL] = new SliderBox(5);
        options[TEXTURES] = new CarouselBox();
    }

    public void update() {
        options[chosenOption].update();
    }

    public void redraw(Graphics2D g) {
        options[chosenOption].redraw(g);
    }

    private GamePlayPanel saveSettings() { //TODO
        GamePlayPanel gpp = new GamePlayPanel(gsm);
        gpp.setBotSpeed((int) options[LEVEL].getChoice());
        //gpp.updateTextures((String)options[TEXTURES].getChoice());
        return gpp;
    }

    public void keyPressed(int key) {
        if (key == KeyEvent.VK_DOWN) {
            if (chosenOption == NUM_OF_OPTIONS - 1)
                chosenOption = 0;
            else chosenOption++;
        } else if (key == KeyEvent.VK_UP) {
            if (chosenOption == 0)
                chosenOption = NUM_OF_OPTIONS - 1;
            else chosenOption--;
        } else if (key == KeyEvent.VK_LEFT) {
            options[chosenOption].moveLeft();
        } else if (key == KeyEvent.VK_RIGHT) {
            options[chosenOption].moveRight();
        } else if (key == KeyEvent.VK_ESCAPE) {
            gsm.updateGamePlayPanel(saveSettings());
            gsm.swapPanel(GameStateManager.MAIN_MENU);
        }
    }
}
