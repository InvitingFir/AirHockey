package com.roman.AirHockey.GamePanels;

import com.roman.AirHockey.FieldParts.Field;
import com.roman.AirHockey.FieldParts.Gate;
import com.roman.AirHockey.FieldParts.ScorePanel;
import com.roman.AirHockey.Player.Players.Bot;
import com.roman.AirHockey.Player.Players.Player;
import com.roman.AirHockey.Player.Players.PlayerPattern;
import com.roman.AirHockey.Player.Puck;

import java.awt.*;
import java.util.ArrayList;

public class GameplayPanel implements GamePanel {
    private ArrayList<PlayerPattern> players;
    private Puck puck;
    private Field field;
    private Gate[] gates;
    private ScorePanel scorePanel;

    private GameStateManager gsm;

    public GameplayPanel(GameStateManager gsm){
        this.gsm = gsm;
        players = new ArrayList<>();
        Gate.setCurrentSize(Gate.SMALL_GATES);
        gates = new Gate[2];
        puck = new Puck(20,  players, gates);
        players.add(new Player());
        players.add(new Bot(3, puck));
        gates[0] = new Gate(players.get(0));
        gates[1] = new Gate(players.get(1));
        field = new Field(Field.NO_BACKGROUND);
        scorePanel = new ScorePanel();
    }

    public void update() {
        for (PlayerPattern g: players) { g.update(); }
        puck.update();
    }

    public void redraw(Graphics2D g) {
        field.draw(g);
        for (PlayerPattern gg: players) { gg.draw(g); }
        puck.draw(g);
        for (Gate gg:gates) { gg.draw(g); }
        scorePanel.draw(g);
    }
}
