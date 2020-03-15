package com.roman.AirHockey.GamePanels;

import com.roman.AirHockey.FieldParts.Field;
import com.roman.AirHockey.FieldParts.GamePart;
import com.roman.AirHockey.FieldParts.Gate;
import com.roman.AirHockey.Main.MainPanel;
import com.roman.AirHockey.Player.Bot;
import com.roman.AirHockey.Player.MovableGamePart;
import com.roman.AirHockey.Player.Player;
import com.roman.AirHockey.Player.Puck;

import java.awt.*;
import java.util.ArrayList;

public class GameplayPanel implements GamePanel {
    private ArrayList<MovableGamePart> players;
    private Puck puck;
    private Field field;
    private Gate[] gates;

    private GameStateManager gsm;

    public GameplayPanel(GameStateManager gsm){
        this.gsm = gsm;
        players = new ArrayList<>();
        Gate.setCurrentSize(Gate.SMALL_GATES);
        gates = new Gate[2];
        puck = new Puck(20,  players, gates);
        players.add(new Player(MainPanel.WIDTH/2, 3*MainPanel.HEIGHT/4, 30));
        players.add(new Bot(MainPanel.WIDTH/2, MainPanel.HEIGHT/4, 30,2, puck));
        gates[0] = new Gate(players.get(0));
        gates[1] = new Gate(players.get(1));
        field = new Field(Field.REAL_BACKGROUND);
    }

    public void update() {
        for (MovableGamePart g: players) { g.update(); }
        puck.update();
    }

    public void redraw(Graphics2D g) {
        field.draw(g);
        for (GamePart gg: players) { gg.draw(g); }
        puck.draw(g);
        for (Gate gg:gates) { gg.draw(g); }
    }
}
