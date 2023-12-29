package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
//import java.awt.SystemTray;
import java.util.ArrayList;
//import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.JPanel;

import entity.Entity;
import entity.Player;
//import object.SuperObject; PREVIOUSLY USED
//import tile.Tile;
import tile.TileManager;

public class GamePanel extends JPanel implements Runnable {
    
    //screen settings
    final int originalTileSize = 16; //16x16 tile
    final int scale = 3; 

    public  int tileSize = originalTileSize * scale; //48x48 tile 
    public  int maxScreenCol = 16;
    public  int maxScreenRow = 12;
    public  int screenWidth = tileSize * maxScreenCol; // 786 pixels
    public  int screenHeight = tileSize * maxScreenRow; // 576 pixels

    //WORLD SETTINGS
    public final int maxWorldCol = 50;
    public final int maxWorldRow = 50;

    public final int worldWidth = tileSize * maxWorldCol;
    public final int worldHeight = tileSize * maxWorldRow; // he deleted these two but worldWidth is used line 58 of Player.java; to verify

    //FPS
    int FPS = 60;

    //SYSTEM
    TileManager tileM = new TileManager(this);
    public KeyHandler keyH = new KeyHandler(this);
    //Sound sound = new Sound();

    Sound music = new Sound();
    Sound se = new Sound();

    public CollisionChecker cChecker = new CollisionChecker(this);
    public AssetSetter aSetter = new AssetSetter(this);
    public UI ui = new UI(this);
    public EventHandler eHandler = new EventHandler(this);
    Thread gameThread; 
    
    //ENTITY AND OBJECT 
    public Player player = new Player(this, keyH, tileM);
    public Entity obj[] = new Entity[20]; //10 is the number of slots
    public Entity npc[] = new Entity[20];
    public Entity monster[] = new Entity[20]; //Number of Monsters we can display at the same time.
    public ArrayList<Entity> projectileList = new ArrayList<>();
    ArrayList<Entity> entityList = new ArrayList<>();

    //GAME STATE
    public int gameState;
    public final int titleState = 0;
    public final int playState = 1; //we can choose any number
    public final int pauseState = 2; //we can choose any number
    public final int dialogueState = 3;
    public final int characterState = 4;
    public final int optionState = 5;
    public final int gameOverState = 6;

    /* //Set player's default position 
    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4; */

    public GamePanel(){

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);

    }

    //Function designed to zoom in or out. It is abandoned for now since it does not work very well and is not necessary for the game.
    /*public  void zoomInOut(int i) {


        int oldWorldWidth = tileSize * maxWorldCol; //2400 1200 = 0.5
        tileSize +=i;
        int newWorldWidth = tileSize * maxWorldCol; //2350

        player.speedGround = (double) newWorldWidth/600;

        double multiplier = (double)newWorldWidth/oldWorldWidth;

        System.out.println("tileSize:"+ tileSize);
        System.out.println("worldWIdth:"+ newWorldWidth);
        System.out.println("player WorldX:"+ player.worldX);

        double newPlayerWorldX = player.worldX * multiplier;
        double newPlayerWorldY = player.worldY * multiplier;

        //To do with npc and objects

        player.worldX = (int) newPlayerWorldX;
        player.worldY = (int) newPlayerWorldY ;


    }*/

    public void setupGame() {

        aSetter.setObject();
        aSetter.setNPC();
        aSetter.setMonster();
        playMusic(0);
        stopMusic(); //anote this line to hear the music 
        gameState = titleState;
    } 
    
    public void retry() {
        player.inventory.deleteAllItems();
        aSetter.deleteAllMonsters();
        player.setisFighter(false);
        player.setisMagician(false);
        player.setisThief(false);
        player.hasKey=0;
        ui.playTime=0;
        gameState = titleState;
        restart();
    }

    public void restart() {

        player.setDefaultValues();
        player.setDefaultPositions();
        player.restoreLife();
        aSetter.setObject();
        aSetter.setNPC();
        aSetter.setMonster();

    }

    public void startGameThread(){

        gameThread = new Thread(this);
        gameThread.start();
    }
    
/*     @Override
    public void run() {

        double drawInterval = 1000000000/FPS; // 0.01666 seconds
        double nextDrawTime = System.nanoTime() + drawInterval;

        while(gameThread != null){

            update();

            repaint();

            try {

                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime/1000000;

                if(remainingTime < 0) {
                    remainingTime = 0;
                }

                Thread.sleep((long) remainingTime); 

                nextDrawTime += drawInterval;
            } 
            
            catch (InterruptedException e) {

                e.printStackTrace();
                
            }
        }
    } */
    
    public void run(){

        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        //int drawCount = 0;

        while(gameThread != null) {

            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;
            timer  += (currentTime - lastTime);
            lastTime = currentTime;

            if(delta >= 1) {
                update();
                repaint();
                delta--;
                //drawCount++;
            }

            if(timer >= 1000000000) {
                //System.out.println("FPS:"+ drawCount); //unnote this line and 136 150 and 155 to display
                //drawCount = 0;
                timer = 0;
            }

        }
    }

    public void update() {
        
        if(gameState == playState) {

            //PLAYER
            player.update();

            //NPC
            for(int i = 0; i < npc.length; i++) {
                if(npc[i] != null) {
                    npc[i].update();
                }
            }

            //MONSTER
            for(int i = 0; i < monster.length; i++) {
                if(monster[i] != null) {

                    if(monster[i].alive == true && monster[i].dying == false) {
                        monster[i].update();
                    }

                    if(monster[i].alive == false) {
                        monster[i] = null;
                    }

                }
            }

            //PROJECTILE
            for(int i = 0; i < projectileList.size(); i++) {

                if(projectileList.get(i) != null) {

                    if(projectileList.get(i).alive == true) {
                        projectileList.get(i).update();
                        
                    }

                    if(projectileList.get(i).alive == false) {
                        projectileList.remove(i);
                        System.out.println("Projectile Removed");
                    }

                }
            }

        }

        if(gameState == pauseState) {
            //nothing, means nothing happens so player stop moving because he doesn't know what do do, we didn't tell him
        }

        /* if(gameState == deathState && keyH.enterPressed == true) {
                gameState = playState;
            } */

    }

    public void paintComponent(Graphics g) {
        
        super.paintComponent(g );
        Graphics2D g2 = (Graphics2D)g;
        
        //DEBUG
        long drawStart = 0;
        if(keyH.showDebugText == true) {
            drawStart = System.nanoTime();
        }

        //TITLE SCREEN
        if(gameState == titleState) {
            ui.draw(g2);
        }
        //OTHERS
        else{

            //TILE
            tileM.draw(g2);
            
            //PLAYER
            //player.draw(g2);
            
            //ADD ENTITIES TO THE LIST
            entityList.add(player);

            for(int i = 0; i < npc.length; i++) {
                if(npc[i] != null){
                    entityList.add(npc[i]); //ADD NPC
                }
            }

            for(int i = 0; i < obj.length; i++) {
                if(obj[i] != null) {
                    entityList.add(obj[i]); //ADD OBJETCS
                }
            }

            for(int i = 0; i < monster.length; i++) {
                if(monster[i] != null) {
                    entityList.add(monster[i]); //ADD MONSTERS
                }
            }

            for(int i = 0; i < projectileList.size(); i++) {
                if(projectileList.get(i) != null) {
                    entityList.add(projectileList.get(i)); //ADD PROJECTILES
                }
            }


            
            //SORT
            /* Collections.sort(entityList, new Comparator<Entity>() {

                @Override
                public int compare(Entity e1, Entity e2) {
                    // eTODO Auto-generated method stub
                    //throw new UnsupportedOperationException("Unimplemented method 'compare'");
                    
                    int result = Integer.compare(e1.worldX, e2.worldY);
                    return result;
                }
                
            }); */

            Collections.sort(entityList, new Comparator<Entity>() {
                @Override
                public int compare(Entity e1, Entity e2) {
                    // Compare based on worldX values as doubles
                    return Double.compare(e1.worldX, e2.worldX);
                }
            });

            //DRAW ENTITIES
            for(int i = 0; i < entityList.size(); i++) {
                entityList.get(i).draw(g2);
            }
            
            //EMPTY ENTITY LIST
            entityList.clear();

            //UI
            ui.draw(g2);        

        //DEBUG
            if(keyH.showDebugText == true ) {
                long drawEnd = System.nanoTime();
                long passed = drawEnd - drawStart;

                g2.setFont(new Font("Arial", Font.PLAIN, 20));
                g2.setColor(Color.white);

                int x = 10;
                int y = 400;
                int lineHeight = 20;

                g2.drawString("WorldX: " + player.worldX, x, y); y += lineHeight;
                g2.drawString("WorldY: " + player.worldY, x, y); y += lineHeight;
                g2.drawString("Col: " + (player.worldX + player.solidArea.x)/tileSize, x, y); y += lineHeight;
                g2.drawString("Row: " + (player.worldY + player.solidArea.y)/tileSize, x, y); y += lineHeight;

                g2.drawString("Draw Time: " + passed, x, y);

                //System.out.println("Draw Time: "+ passed);
            }
            
            g2.dispose();
    
        }

    }

    public void playMusic(int i) {

        music.setFile(i);
        music.play();
        music.loop();
        music.stop();
    }

    public void stopMusic() {
        
        music.stop();
    }

    public void playSE(int i) {

        se.setFile(i);
        se.play();

    }
}