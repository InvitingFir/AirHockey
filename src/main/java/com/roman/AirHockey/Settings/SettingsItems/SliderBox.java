package com.roman.AirHockey.Settings.SettingsItems;

import com.roman.AirHockey.Game.Player.Players.Bot;
import com.roman.AirHockey.Main.MainPanel;

import java.awt.*;

public class SliderBox implements OptionBox {
    private int maxLevel;
    private int currentLevel;

    public SliderBox(int maxLevel) {
        this.maxLevel = maxLevel;
        currentLevel = Bot.SPEED;
    }

    public void update() {

    }

    public void redraw(Graphics2D g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, MainPanel.WIDTH, MainPanel.HEIGHT);
        g.setColor(Color.BLACK);
        g.drawString(Integer.toString(currentLevel), 100, 100);
    }

    public void moveLeft() {
        if (currentLevel > 0) currentLevel--;
    }

    public void moveRight() {
        if (currentLevel < maxLevel) currentLevel++;
    }

    public Object getChoice() {
        return currentLevel;
    }
}
