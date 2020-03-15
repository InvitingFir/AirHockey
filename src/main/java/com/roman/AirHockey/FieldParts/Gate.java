package com.roman.AirHockey.FieldParts;

import com.roman.AirHockey.Main.MainPanel;
import com.roman.AirHockey.Player.Players.PlayerPattern;

import java.awt.*;


//Класс просто содержит расположение, владельца
//ворот и отрисовывает их на поле
public class Gate{
    public static final int SMALL_GATES = (MainPanel.WIDTH-2*Field.BORDER_SIZE)/3;
    private static int length;
    private PlayerPattern owner;

    public Gate(PlayerPattern owner){
        this.owner = owner;
    }

    public int getX1(){
        return (MainPanel.WIDTH/2)-(length/2);
    }

    public int getX2(){ return (MainPanel.WIDTH/2)+(length/2); }

    public int getY(){
        switch(owner.getPlayerSide()){
            case PlayerPattern.LOWER:
                return MainPanel.HEIGHT-Field.BORDER_SIZE;
            case PlayerPattern.UPPER:
                return Field.BORDER_SIZE;
        }
        return 0;
    }

    public static int getCurrentSize(){return length;}

    public PlayerPattern getOwner(){return owner;}

    public static void setCurrentSize(int size){length = size;}

    public void draw(Graphics2D g) {
        g.setColor(Color.BLACK);
        switch(owner.getPlayerSide()){
            case PlayerPattern.LOWER:
                g.fillRect(getX1(), MainPanel.HEIGHT-Field.BORDER_SIZE, length, MainPanel.HEIGHT);
                break;
            case PlayerPattern.UPPER:
                g.fillRect(getX1(), 0, length, Field.BORDER_SIZE);
                break;
        }
    }
}
