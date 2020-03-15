package com.roman.AirHockey.Strategy;

import com.roman.AirHockey.FieldParts.Field;
import com.roman.AirHockey.FieldParts.Gate;
import com.roman.AirHockey.Main.MainPanel;
import com.roman.AirHockey.Player.Players.Bot;
import com.roman.AirHockey.Player.Players.PlayerPattern;
import com.roman.AirHockey.Player.Puck;

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
        int x = MainPanel.WIDTH/2 - Gate.getCurrentSize()/2;
        targetX = 0;
        targetX += Math.round(x + puck.getX()*protectionFactor);
        targetY = Field.BORDER_SIZE + PlayerPattern.RADIUS + 5;
    }
}