package com.roman.AirHockey.Game;

import com.roman.AirHockey.Game.Player.Players.PlayerPattern;
import com.roman.AirHockey.Main.MainPanel;

import java.awt.*;
import java.awt.image.BufferedImage;

//ПЕРЕДЕЛАТЬ В ОДИН КЛАСС
//добавить интерфейс геймкомпонент и запихать в массив
//в геймплейпанел, также обновлять и прочее

public class Score implements GameComponent {
    public static final int WINNER_SCORE = 7;

    private int[] scoreArray = {0, 0};

    public void updateScore(PlayerPattern.Side side) {
        if (side == PlayerPattern.Side.UPPER) {
            this.scoreArray[1]++;
        } else {
            this.scoreArray[0]++;
        }
    }

    public PlayerPattern.Side gameOver() {
        if (scoreArray[0] == WINNER_SCORE)
            return PlayerPattern.Side.UPPER;
        else if (scoreArray[1] == WINNER_SCORE)
            return PlayerPattern.Side.LOWER;
        else return null;
    }

    public void draw(Graphics2D g) {
        g.setColor(Color.WHITE);
        for (int i = 0; i < scoreArray.length; i++) {
            g.drawString(Integer.toString(scoreArray[i]), 4 * MainPanel.WIDTH / 5, 200 + i * 200);
        }
    }

    public void update() {
    }

    public void setTexture(BufferedImage image) {
    }
}
