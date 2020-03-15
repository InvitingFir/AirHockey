package com.roman.AirHockey.FieldParts;


import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Field{
    public static final int BORDER_SIZE = 15;
    public static final String NO_BACKGROUND = "/no_background.jpg";
    public static final String REAL_BACKGROUND = "/real_background.jpg";
    private BufferedImage background;

    public Field(String backgroundString){
        try { background = ImageIO.read(getClass().getResourceAsStream(backgroundString)); }
        catch(IOException e){ e.printStackTrace(); }
    }
    
    public void draw(Graphics2D g) {
        g.drawImage(background, 0, 0,null);
    }
}
