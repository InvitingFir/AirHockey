package com.roman.AirHockey.Strategy;

import com.roman.AirHockey.Player.Bot;
import com.roman.AirHockey.Player.Player;
import com.roman.AirHockey.Player.Puck;

public abstract class Strategy {
    protected Puck puck;
    protected Bot admin;


    public Strategy(Puck puck, Bot admin){
        this.puck = puck;
        this.admin = admin;
    }

    public abstract void update();
}
