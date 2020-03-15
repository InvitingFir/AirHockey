package com.roman.AirHockey.FieldParts;

import com.roman.AirHockey.Player.Players.PlayerPattern;
import java.awt.*;

public class ScorePanel{
    private static int [] scores;

    public ScorePanel(){ scores = new int[2]; }

    public void draw(Graphics2D g) {
        String score = String.format("you|%d:%d|bot ",scores[0] , scores[1]);
        g.drawString(score, Field.BORDER_SIZE+2, 13);
    }

    public static void updateScore(PlayerPattern player){
        scores[player.getPlayerSide()]++;
        System.out.println(scores[0] + " " + scores[1]);}
}
