package com.roman.AirHockey.MainMenu;

import com.roman.AirHockey.Panels.*;

import java.awt.*;
import java.awt.event.KeyEvent;

public class MainMenuPanel implements GamePanel {
    public static final int START = 0;
    public static final int OPTIONS = 1;
    public static final int EXIT = 2;
    public static final int NUM_OF_OPTIONS = 3;

    private int choice = START;
    private GameStateManager gsm;
    private Logo[] optionArray;
    private Background background;

    public MainMenuPanel(GameStateManager gsm) {
        this.gsm = gsm;
        background = new Background("/MainMenu/mainMenuBackground.png");
        optionArray = new Logo[NUM_OF_OPTIONS];
        optionArray[START] = new Logo(5, "/MainMenu/start1.png", "/MainMenu/start2.png", 10, 280);
        optionArray[OPTIONS] = new Logo(7, "/MainMenu/options1.png", "/MainMenu/options2.png", 120, 350);
        optionArray[EXIT] = new Logo(4, "/MainMenu/exit1.png", "/MainMenu/exit2.png", 300, 420);
        optionArray[choice].setImage(Logo.SECONDARY_IMAGE);
    }

    public void update() {
        for (int i = 0; i < optionArray.length; i++) {
            if (i == choice) optionArray[i].wave();
            else optionArray[i].unWave();
        }
    }

    public void redraw(Graphics2D g) {
        background.draw(g);
        for (int i = 0; i < NUM_OF_OPTIONS; i++) {
            optionArray[i].draw(g);
        }
    }

    public void keyPressed(int key) {
        if (key == KeyEvent.VK_DOWN) {
            optionArray[choice].setImage(Logo.PRIMARY_IMAGE);
            choice++;
            if (choice == NUM_OF_OPTIONS) choice = 0;
            optionArray[choice].setImage(Logo.SECONDARY_IMAGE);
        } else if (key == KeyEvent.VK_UP) {
            optionArray[choice].setImage(Logo.PRIMARY_IMAGE);
            choice--;
            if (choice < 0) choice = NUM_OF_OPTIONS - 1;
            optionArray[choice].setImage(Logo.SECONDARY_IMAGE);
        } else if (key == KeyEvent.VK_ENTER) {
            confirmChoice();
        }
    }

    private void confirmChoice() {
        switch (choice) {
            case 0:
                gsm.swapPanel(GameStateManager.GAME_PLAY);
                break;
            case 1:
                gsm.swapPanel(GameStateManager.SETTINGS);
                break;
            case 2:
                System.exit(0);
                break;
        }
    }
}
