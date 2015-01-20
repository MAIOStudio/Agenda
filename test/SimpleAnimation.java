
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author dearmartinez
 */
public class SimpleAnimation extends JPanel implements ActionListener {
    
    Timer timer = new Timer(5, this);
    int x = 0;
    int speedX = 2;
    
    @Override
    public void paintComponent(Graphics g) {
        
        super.paintComponent(g);
        
        g.setColor(Color.red);
        g.fillRect(x, x, 50, 30);
        g.fillOval(x, 30, 50, 30);
        g.fillRoundRect(30, x, 50, 30, 20, 20);
       
        timer.start();
    }
    
    public static void main(String[] args) {
        
        SimpleAnimation animation = new SimpleAnimation();
        JFrame frame = new JFrame();
        frame.setTitle("Simple Animation");
        frame.setSize(600, 370);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(animation);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(x < 0 || x > 550)
            speedX = -speedX;
        
        x += speedX;
        repaint();
        
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
