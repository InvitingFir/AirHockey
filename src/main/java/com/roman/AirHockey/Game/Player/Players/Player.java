package com.roman.AirHockey.Game.Player.Players;

import com.roman.AirHockey.Game.Field;
import com.roman.AirHockey.Main.MainPanel;
import com.roman.AirHockey.Util.Vector;

public class Player extends PlayerPattern {

    public Player(Side side) {
        super(side);
        this.speed = 0;
    }

    public void update() {
        int x = MainPanel.getMouseX();
        int y = MainPanel.getMouseY();
        if (x - radius >= Field.BORDER_SIZE && x + radius <= MainPanel.WIDTH - Field.BORDER_SIZE) {
            if (this.playerSide == Side.LOWER) lowerUpdate(x, y);
            else upperUpdate(x, y);
        }

    }

    private void upperUpdate(int x, int y){
        if (y + radius <= MainPanel.HEIGHT / 2 && y - radius >= Field.BORDER_SIZE) {
            Vector vector = new Vector(this.x, this.y, x, y);
            this.y = y;
            this.x = x;
            this.speed = vector.getLength();
        } else speed = 0;
    }

    private void lowerUpdate(int x, int y){
        if (y - radius >= MainPanel.HEIGHT / 2 && y + radius <= MainPanel.HEIGHT - Field.BORDER_SIZE) {
            Vector vector = new Vector(this.x, this.y, x, y);
            this.y = y;
            this.x = x;
            this.speed = vector.getLength();
        } else
            speed = 0;
    }
}
