package com.roman.AirHockey.Settings.SettingsItems;

import java.awt.*;

public interface OptionBox {
    void update();

    void redraw(Graphics2D g);

    void moveLeft();

    void moveRight();

    Object getChoice();
}
