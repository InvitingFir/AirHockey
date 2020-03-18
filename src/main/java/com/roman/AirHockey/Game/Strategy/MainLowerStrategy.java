package com.roman.AirHockey.Game.Strategy;

import com.roman.AirHockey.Game.Field;
import com.roman.AirHockey.Game.Gate;
import com.roman.AirHockey.Main.MainPanel;
import com.roman.AirHockey.Game.Player.Players.Bot;
import com.roman.AirHockey.Game.Player.Players.PlayerPattern;
import com.roman.AirHockey.Game.Player.Puck;

public class MainLowerStrategy extends Strategy {


    public MainLowerStrategy(Puck puck, Bot admin) {
        super(puck, admin);
    }

    public void update() {
        if (puck.getY() > MainPanel.HEIGHT / 2) {
            attack();
        } else {
            protect();
        }
        updatePosition();
    }

    @Override
    protected void protect() {
        int x = MainPanel.WIDTH / 2 - Gate.LENGTH / 2;
        targetX = 0;
        targetX += Math.round(x + puck.getX() * protectionFactor);
        targetY = MainPanel.HEIGHT - (Field.BORDER_SIZE + admin.getRadius() + 5);
    }
}