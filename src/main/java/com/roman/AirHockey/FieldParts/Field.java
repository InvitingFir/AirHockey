package com.roman.AirHockey.FieldParts;

import com.roman.AirHockey.Main.MainPanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Field implements GamePart {
    public static final int BORDER_SIZE = 15;
    public static final int WIDTH = MainPanel.WIDTH - 2*BORDER_SIZE;
    public static final int HEIGHT = MainPanel.HEIGHT-2*BORDER_SIZE;
    public static final int NO_BACKGROUND = 0;
    public static final int REAL_BACKGROUND = 1;
    private BufferedImage background;

    public Field(int Background_id){
        try {
            switch (Background_id) {
                case NO_BACKGROUND:
                    background = ImageIO.read(getClass().getResourceAsStream("/no_background.jpg"));
                    break;
                case REAL_BACKGROUND:
                    background = ImageIO.read(getClass().getResourceAsStream("/real_background.jpg"));
                    break;
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public void draw(Graphics2D g) {
        g.drawImage(background, 0, 0,null);
    }
}
