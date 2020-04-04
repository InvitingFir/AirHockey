package com.roman.AirHockey.Game.Player.Players;

import com.roman.AirHockey.Game.Player.Puck;
import com.roman.AirHockey.Game.Strategy.MainLowerStrategy;
import com.roman.AirHockey.Game.Strategy.MainUpperStrategy;
import com.roman.AirHockey.Game.Strategy.Strategy;

public class Bot extends PlayerPattern {
    public static final int SPEED = 3;
    private Strategy strategy;

    //конструктор в зависимости от положения на поле
    //присваивает определенный стиль поведения
    public Bot(int speed, Puck puck, Side side) {
        super(side);
        this.speed = SPEED;
        if (playerSide == Side.UPPER) {
            this.strategy = new MainUpperStrategy(puck, this);
        } else {
            this.strategy = new MainLowerStrategy(puck, this);
        }
    }

    //Поведение шайбы передается объекту стиля поведения
    public void update() {
        strategy.update();
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
