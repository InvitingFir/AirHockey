package com.roman.AirHockey.Player.Players;

import com.roman.AirHockey.FieldParts.Field;
import com.roman.AirHockey.Main.MainPanel;
import com.roman.AirHockey.Util.Vector;

import java.awt.*;

public class Player extends PlayerPattern {

    public Player(){
        super();
        this.speed = 0;
        color = Color.GRAY;
    }

    public void update(){
        int x = MainPanel.getMouseX();
        int y = MainPanel.getMouseY();
        if(x- PlayerPattern.RADIUS >= Field.BORDER_SIZE && x + PlayerPattern.RADIUS <= MainPanel.WIDTH - Field.BORDER_SIZE) {
            if(this.playerSide == PlayerPattern.LOWER) lowerUpdate(x, y);
            else upperUpdate(x, y);
        }

    }

    private void upperUpdate(int x, int y){
        if(y+ PlayerPattern.RADIUS <= MainPanel.HEIGHT/2 && y- PlayerPattern.RADIUS >= Field.BORDER_SIZE) {
            Vector vector = new Vector(this.x, this.y, x, y);
            this.y = y;
            this.x = x;
            this.speed = vector.getLength();
        }
        else speed = 0;
    }

    private void lowerUpdate(int x, int y){
        if(y- PlayerPattern.RADIUS >= MainPanel.HEIGHT/2 && y+ PlayerPattern.RADIUS <= MainPanel.HEIGHT-Field.BORDER_SIZE) {
            Vector vector = new Vector(this.x, this.y, x, y);
            this.y = y;
            this.x = x;
            this.speed = vector.getLength();
        }
        else speed = 0;
    }
}
