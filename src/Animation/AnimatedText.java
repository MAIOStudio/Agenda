package Animation;

import java.applet.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author dearmartinez
 */
public class AnimatedText extends Applet implements Runnable {
    Thread runner;
    int Xpos = 500;
    
    Font font = new Font("Times New Roman", Font.TRUETYPE_FONT, 20);
    
    @Override
    public void start() {
        if(runner == null) {
            runner = new Thread(this);
            runner.start();
        }
    }
    
    @Override
    public void stop() {
        if(runner != null) {
            runner = null;
        }
    }
    
    @Override
    public void run() {
        while(true) {
            repaint();
            try {
                Thread.sleep(30);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    @Override
    public void paint(Graphics g) {
        String greeting = ("Hello World!");
        this.setFont(font);
        this.setBackground(Color.GRAY);
        this.setForeground(Color.WHITE);
        g.drawString(greeting, Xpos, 100);
        Xpos--;
        if(Xpos < -200)
            Xpos = 500;
    }
}
