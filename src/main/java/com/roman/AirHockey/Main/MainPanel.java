package com.roman.AirHockey.Main;

import com.roman.AirHockey.Panels.GameStateManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class MainPanel extends JPanel implements Runnable, MouseMotionListener {
    //Константы
    public static final int WIDTH = Main.WIDTH;
    public static final int HEIGHT = Main.HEIGHT;
    public static final int FPS = 60;

    //Игровые панели
    private GameStateManager gsm;

    //Про поток
    private long targetTime = 1000/FPS;
    private Thread thread;
    private boolean isRunning = true;

    //Про изображение
    private Image image;
    private Graphics2D imageGraphics;

    //Про координаты мыши
    private static int x = HEIGHT-40;
    private static int y = WIDTH/2;

    public MainPanel(){
        thread = new Thread(this);
        gsm = new GameStateManager();
        image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        imageGraphics = (Graphics2D) image.getGraphics();
        setPreferredSize(new Dimension(Main.WIDTH, Main.HEIGHT));
        this.addMouseMotionListener(this);
        setFocusable(true);
        requestFocus();
        thread.start();
    }

    public void run() {
        while(isRunning){
            long start = System.nanoTime();
            update();
            redraw();
            redrawOnScreen();
            long elapsed = System.nanoTime() - start;
            long wait = targetTime - elapsed/1000000;
            if(wait<0) wait=5;
            try{Thread.sleep(wait);}
            catch(Exception e){e.printStackTrace();}
        }
    }

    private void update(){
        gsm.update();
    }

    private void redraw(){ gsm.redraw(imageGraphics); }

    private void redrawOnScreen(){ repaint(); }

    @Override
    protected void paintComponent(Graphics g){
        g.drawImage(image, 0, 0, WIDTH/*SCALE*/, HEIGHT/*SCALE*/, null);
        imageGraphics.setColor(Color.BLACK);
        imageGraphics.fillRect(0, 0, MainPanel.WIDTH, MainPanel.HEIGHT);
    }

    @Override
    public void mouseDragged(MouseEvent mouseEvent) {
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
        x = mouseEvent.getX();
        y = mouseEvent.getY();
    }

    public static int getMouseX(){return x;}

    public static int getMouseY(){return y;}
}
