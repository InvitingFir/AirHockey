package com.roman.AirHockey.Panels;

import java.awt.*;

public interface GamePanel {
    void update();
    void redraw(Graphics2D g);
    void keyPressed(int key);
}
