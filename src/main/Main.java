package main;

import javax.swing.JFrame;

//import java.awt.Dimension;

public class Main {
    
    public static void main(String[] args) {
        
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("2D game adventure");


        
        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);

        //gamePanel.setPreferredSize(new Dimension(800, 600));
       
        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        gamePanel.setupGame();
        gamePanel.startGameThread();
        
    }
}
