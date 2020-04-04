package com.roman.AirHockey.Game.Strategy;

import com.roman.AirHockey.Game.Field;
import com.roman.AirHockey.Game.Player.Players.PlayerPattern;
import com.roman.AirHockey.Main.MainPanel;
import com.roman.AirHockey.Game.Player.Players.Bot;
import com.roman.AirHockey.Game.Player.Puck;

public class MainUpperStrategy extends Strategy{

    public MainUpperStrategy(Puck puck, Bot admin) {
        super(puck, admin);
    }

    public void update() {
        if(puck.getY()<= MainPanel.HEIGHT/2){ attack(); }
        else{ protect(); }
        updatePosition();
    }

    protected void protect(){
        int x = MainPanel.WIDTH / 2 - PlayerPattern.Gate.LENGTH / 2;
        targetX = 0;
        targetX += Math.round(x + puck.getX() * protectionFactor);
        targetY = Field.BORDER_SIZE + admin.getRadius() + 5;
    }
}