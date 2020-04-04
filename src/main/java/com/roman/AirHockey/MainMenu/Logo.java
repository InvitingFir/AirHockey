package com.roman.AirHockey.MainMenu;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Logo {
    public static final int PRIMARY_IMAGE = 0;
    public static final int SECONDARY_IMAGE = 1;
    public static final int NUM_OF_IMAGES = 2;
    public static final double WAVE_SPEED = 0.05;
    public static final double WAVE_PERIOD = 10;
    public static final double DELTA_ANGLE = 0.5;

    private LogoLetter[] logoArray;
    private double currentAngle;

    public Logo(int length, String mainPath, String secondaryPath, int x, int y) {
        this.currentAngle = 0;
        logoArray = new LogoLetter[length];
        try {
            BufferedImage image = ImageIO.read(getClass().getResourceAsStream(mainPath));
            BufferedImage secImage = ImageIO.read(getClass().getResourceAsStream(secondaryPath));
            int width = secImage.getWidth() / length;
            int height = secImage.getHeight();
            for (int i = 0; i < logoArray.length; i++) {
                BufferedImage image1 = image.getSubimage(i * width, 0, width, height);
                BufferedImage image2 = secImage.getSubimage(i * width, 0, width, height);
                logoArray[i] = new LogoLetter(image1, image2, x + width * i, y);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void wave() {
        for (int i = 0; i < logoArray.length; i++) {
            logoArray[i].drawY = logoArray[i].baseY + (int) Math.round(Math.cos(currentAngle + DELTA_ANGLE * i) * WAVE_PERIOD);
        }
        currentAngle += WAVE_SPEED;
        currentAngle = currentAngle % (2 * Math.PI);
    }

    public void unWave() {
        for (LogoLetter logoLetter : logoArray) {
            logoLetter.drawY = logoLetter.baseY;
        }
    }

    public void draw(Graphics2D g) {
        for (LogoLetter l : logoArray) {
            l.draw(g);
        }
    }

    public void setImage(int imageNumber) {
        for (LogoLetter l : logoArray) {
            l.setImage(imageNumber);
        }
    }

    private static class LogoLetter {

        private int baseY;
        private int drawX;
        private int drawY;

        private BufferedImage[] charImages;
        private int currentImage;

        public LogoLetter(BufferedImage primaryImage, BufferedImage secondaryImage, int x, int y) {
            charImages = new BufferedImage[NUM_OF_IMAGES];
            charImages[PRIMARY_IMAGE] = primaryImage;
            charImages[SECONDARY_IMAGE] = secondaryImage;
            currentImage = PRIMARY_IMAGE;
            this.drawX = x;
            this.baseY = drawY = y;
        }

        public void draw(Graphics2D g) {
            g.drawImage(charImages[currentImage], drawX, drawY, null);
        }

        public void setImage(int imageNumber) {
            this.currentImage = imageNumber;
        }
    }
}
