package com.roman.AirHockey.Game;

import com.roman.AirHockey.Main.MainPanel;
import com.roman.AirHockey.Game.Player.Players.PlayerPattern;

import java.awt.*;
import java.awt.image.BufferedImage;


//Класс просто содержит расположение, владельца
//ворот и отрисовывает их на поле
public class Gate implements GameComponent {
    public static final int LENGTH = (MainPanel.WIDTH - 2 * Field.BORDER_SIZE) / 3;
    private PlayerPattern owner;

    public Gate(PlayerPattern owner) {
        this.owner = owner;
    }

    public int getX1() {
        return (MainPanel.WIDTH / 2) - (LENGTH / 2);
    }

    public int getX2() {
        return (MainPanel.WIDTH / 2) + (LENGTH / 2);
    }

    public int getY(){
        switch(owner.getPlayerSide()){
            case PlayerPattern.LOWER:
                return MainPanel.HEIGHT-Field.BORDER_SIZE;
            case PlayerPattern.UPPER:
                return Field.BORDER_SIZE;
        }
        return 0;
    }

    public PlayerPattern getOwner(){return owner;}

    public void draw(Graphics2D g) {
        g.setColor(Color.BLACK);
        switch (owner.getPlayerSide()) {
            case PlayerPattern.LOWER:
                g.fillRect(getX1(), MainPanel.HEIGHT - Field.BORDER_SIZE, LENGTH, MainPanel.HEIGHT);
                break;
            case PlayerPattern.UPPER:
                g.fillRect(getX1(), 0, LENGTH, Field.BORDER_SIZE);
                break;
        }
    }

    public void update() {
    }

    public void setTexture(BufferedImage image) {
    }
}
