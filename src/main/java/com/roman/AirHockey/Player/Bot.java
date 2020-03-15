package com.roman.AirHockey.Player;

import com.roman.AirHockey.Strategy.MainStrategy;
import com.roman.AirHockey.Strategy.Strategy;

public class Bot extends Player implements MovableGamePart{
    private Strategy strategy;

    public Bot(int x, int y, int radius, int speed, Puck puck) {
        super(x, y, radius);
        this.speed = speed;
        this.strategy = new MainStrategy(puck, this);
    }

    @Override
    public void update() {
        strategy.update();
    }

    public void setX(int x){this.x = x;}

    public void setY(int y){this.y = y;}
}
