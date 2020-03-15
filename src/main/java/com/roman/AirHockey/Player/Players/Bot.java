package com.roman.AirHockey.Player.Players;

import com.roman.AirHockey.Player.Puck;
import com.roman.AirHockey.Strategy.MainLowerStrategy;
import com.roman.AirHockey.Strategy.MainUpperStrategy;
import com.roman.AirHockey.Strategy.Strategy;

import java.awt.*;

public class Bot extends PlayerPattern {
    private Strategy strategy;

    //конструктор в зависимости от положения на поле
    //присваивает определенный стиль поведения
    public Bot(int speed, Puck puck) {
        super();
        color = Color.DARK_GRAY;
        this.speed = speed;
        if (playerSide == PlayerPattern.UPPER) {
            this.strategy = new MainUpperStrategy(puck, this);
        }
        else {
            this.strategy = new MainLowerStrategy(puck, this);
        }
    }

    //Поведение шайбы передается объекту стиля поведения
    public void update() {
        strategy.update();
    }
}
