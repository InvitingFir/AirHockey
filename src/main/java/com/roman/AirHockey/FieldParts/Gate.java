package com.roman.AirHockey.FieldParts;

import com.roman.AirHockey.Main.MainPanel;
import com.roman.AirHockey.Player.Bot;
import com.roman.AirHockey.Player.MovableGamePart;
import com.roman.AirHockey.Player.Player;

import java.awt.*;

public class Gate implements GamePart{
    public static final int SMALL_GATES = Field.WIDTH/3;
    public static final int MEDIUM_GATES = 2*Field.WIDTH/3;
    public static final int BIG_GATES = Field.WIDTH;
    private static int length;
    private MovableGamePart owner;

    public Gate(MovableGamePart owner){
        this.owner = owner;
    }

    public int getX1(){
        return (MainPanel.WIDTH/2)-(length/2);
    }

    public int getX2(){ return (MainPanel.WIDTH/2)+(length/2);
    }

    public static int getCurrentSize(){return length;}

    public static void setCurrentSize(int size){length = size;}

    public int getY(){
        if(owner instanceof Bot) return Field.BORDER_SIZE;
        else if(owner != null) return MainPanel.HEIGHT-Field.BORDER_SIZE;
        else return 0;
    }

    public MovableGamePart getOwner(){
        return owner;
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.BLACK);
        if(owner instanceof Bot) g.fillRect(getX1(), 0, length, Field.BORDER_SIZE);
        else if(owner instanceof Player) g.fillRect(getX1(), MainPanel.HEIGHT-Field.BORDER_SIZE, length, MainPanel.HEIGHT);
    }
}
