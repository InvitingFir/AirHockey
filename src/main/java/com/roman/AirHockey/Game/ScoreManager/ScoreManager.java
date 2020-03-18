package com.roman.AirHockey.Game.ScoreManager;

import com.roman.AirHockey.Game.GameComponent;
import com.roman.AirHockey.Game.Player.Players.PlayerPattern;
import com.roman.AirHockey.Main.MainPanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ScoreManager {
    private static int[] score = {0, 0};

    public static void updateScore(PlayerPattern player) {
        score[player.getPlayerSide()]++;
    }

    public static class ScorePanel implements GameComponent {
        Font font;
        int score;
        int side;

        public ScorePanel(int side) {
            this.side = side;
            font = new Font("Impact", Font.PLAIN, 20);
        }

        @Override
        public void draw(Graphics2D g) {
            g.setColor(Color.WHITE);
            g.setFont(font);
            g.drawString(Integer.toString(this.score), 4 * MainPanel.WIDTH / 5, 200 + side * 200);
        }

        @Override
        public void update() {
            if (ScoreManager.score[side] != this.score) {
                this.score = ScoreManager.score[side];
            }
        }

        @Override
        public void setTexture(BufferedImage image) {

        }
    }
}
