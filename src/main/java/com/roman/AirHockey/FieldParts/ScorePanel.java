package com.roman.AirHockey.FieldParts;

import com.roman.AirHockey.Player.Bot;
import com.roman.AirHockey.Player.MovableGamePart;
import com.roman.AirHockey.Player.Player;

import java.awt.*;

public class ScorePanel implements GamePart {
    private static int myScore;
    private static int botScore;

    @Override
    public void draw(Graphics2D g) {

    }

    public static void updateScore(MovableGamePart player){
        if(player instanceof Bot) {
            myScore++;
        }
        else if(player instanceof Player) {
            botScore++;
        }
        System.out.println("|me|"+myScore+" : " + botScore + "|bot|");
    }
}
