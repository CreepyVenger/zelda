package main;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
//import java.awt.image.BufferedImage;
//import java.io.File;
//import java.awt.RenderingHints;
import java.io.IOException;
//import java.awt.image.BufferedImage;
//import java.text.DecimalFormat;
import java.io.InputStream;
import java.text.DecimalFormat;

import entity.Entity;
import object.OBJ_Heart;
//import object.SuperObject; PREVIOUSLY USED

//import javax.imageio.ImageIO;

//import object.OBJ_Key;

public class UI {
    
    GamePanel gp;
    Graphics2D g2;
    Font arial_40, arial_80B;
    Font maruMonica, purisaB;
    BufferedImage heart_full, heart_half, heart_blank;
    //BufferedImage keyImage;
    public boolean messageOn = false;
    public String message = "";
    int messageCounter = 0;
    public boolean gameFinished = false;
    public String currentDialogue = "";
    public int commandNum = 0;
    public int commandNumLat = 0; //lateral or horizontal selection
    public int titleScreenState = 0; //0: the first screen, 1: the second screen...
    //public int StettingsSoundState = 0; //0: sound on, 1:sound off //Evetually not needded


    double playTime;
    DecimalFormat dFormat = new DecimalFormat("#0.00");

    public UI(GamePanel gp) {
        this.gp = gp;

        try {
            InputStream is = getClass().getResourceAsStream("/font/x12y16pxMaruMonica.ttf");
            maruMonica = Font.createFont(Font.TRUETYPE_FONT, is);

            is = getClass().getResourceAsStream("/font/Purisa Bold.ttf"); //why isn't there InputStream in front of "is" like before? 
            purisaB = Font.createFont(Font.TRUETYPE_FONT, is);

        } catch (FontFormatException e) {      
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //CREATE HUD OBJECT
        Entity heart = new OBJ_Heart(gp);
        heart_full = heart.image;
        heart_half = heart.image2;
        heart_blank = heart.image3;
            
        arial_40 = new Font("Arial", Font.PLAIN, 40);
        arial_80B = new Font("Arial", Font.BOLD, 80);
        //OBJ_Key key = new OBJ_Key(gp);
        //keyImage = key.image;
    }

    public void showMessage(String text) {

        message = text;
        messageOn = true;
    }

    public void draw(Graphics2D g2) {

        this.g2 = g2;

        int x = gp.tileSize;        ;
        int y = gp.tileSize;

        g2.setFont(maruMonica);
        //g2.setFont(purisaB);
        //g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON); //use this line for purisaB font for better font resolution
        g2.setColor(Color.white);


        //g2.setColor(new Color(0, 120, 80, 220));
        //g2.fillRect(40, 20, gp.tileSize*3+15, gp.tileSize*2);

        //HOTBAR LIKE IN ZELDA
        //g2.setColor(new Color(0, 0,0));
        g2.setColor(new Color(0, 120, 80, 220));
        g2.fillRect(0, 0, gp.worldHeight, gp.screenWidth/6-12);

        //LIFE TEXT
        String text = "-- Life --";
        g2.setColor(Color.WHITE);
        x += gp.tileSize-50;
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN,48F));
        y += gp.tileSize/2-10;
        g2.drawString(text, x, y);


        //TITLE STATE
        if(gp.gameState == gp.titleState) {
            drawTitleScreen();
        }

        //PLAY STATE
        if(gp.gameState == gp.playState) {
            drawPlayerLife();

            //PREVIOUSLY, THIS WAS IN THE ELSE SECTION , BELOW CONGRATS

            //g2.setFont(arial_40);
            g2.setFont(g2.getFont().deriveFont(Font.PLAIN,48F));
            g2.setColor(Color.WHITE);
            //g2.drawImage(keyImage, gp.tileSize/2, gp.tileSize/2, gp.tileSize, gp.tileSize, null); 
            g2.drawString("|  Keys: x " + gp.player.hasKey, 220, y); // Initially, x=72, y=65
            //x += gp.tileSize-50;
            y += gp.tileSize/2-10;

            //TIME DISPLAY
            /* playTime +=(double)1/60; //x+=1 means x = x+1 so here it's playTime = playTime + (double)1/60
            g2.drawString("Time:"+ dFormat.format(playTime), gp.tileSize*11, 65);
            y += gp.tileSize/2-10; */
            
            //MESSAGE (WHAT TF IS THIS????)
            if(messageOn == true) {

                g2.setFont(g2.getFont().deriveFont(30F));
                g2.drawString(message, gp.tileSize/2, gp.tileSize*5);

                messageCounter++;

                if(messageCounter > 120) {
                    messageCounter = 0;
                    messageOn = false;
                }
            }

        } 

        //DEATH STATE
        if(gp.gameState == gp.deathState) {

            //if(gp.player.life <= 0) {
                drawDeathScreen();
            //}
            
        }

        //PAUSE STATE
        if(gp.gameState == gp.pauseState) {
            drawPlayerLife();
            

            //g2.setFont(arial_40);
            g2.setFont(g2.getFont().deriveFont(Font.PLAIN,48F));
            g2.setColor(Color.WHITE);
            //g2.drawImage(keyImage, gp.tileSize/2, gp.tileSize/2, gp.tileSize, gp.tileSize, null); 
            g2.drawString("|  Keys: x " + gp.player.hasKey, 220, y); // Initially, x=72, y=65
            //x += gp.tileSize-50;
            y += gp.tileSize/2-10;

            //TIME
            //playTime +=(double)1/60; //x+=1 means x = x+1 so here it's playTime = playTime + (double)1/60
            g2.drawString("Time:"+ dFormat.format(playTime), gp.tileSize*11, 65);
            y += gp.tileSize/2-10;
            
            //MESSAGE (WHAT TF IS THIS????)
            if(messageOn == true) {

                g2.setFont(g2.getFont().deriveFont(30F));
                g2.drawString(message, gp.tileSize/2, gp.tileSize*5);

                messageCounter++;

                if(messageCounter > 120) {
                    messageCounter = 0;
                    messageOn = false;
                }
            }

            drawPauseScreen();

        }

        //DIALOG STATE
        if(gp.gameState == gp.dialogueState) {
            drawPlayerLife();
            drawDialogueScreen();
        }

        //For Treasure Hunting Game, un comment this whole paragraph to handle it 

        if(gameFinished == true) { 

            g2.setFont(arial_40);
            g2.setColor(Color.WHITE);

            //String text;
            int textLength;
            //int x;
            //int y;

            text = "You found the treasure!";
            
            textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
            //g2.setColor(Color.WHITE);
            x = gp.screenWidth/2 - textLength/2;
            y = gp.screenHeight/2 - (gp.tileSize*3); //- (gp.tileSize*3);
            g2.drawString(text, x, y);

            text = "Your time is "+dFormat.format(playTime) + "!";
            //g2.setColor(Color.BLUE);
            textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
            x = gp.screenWidth/2 - textLength/2;
            y = gp.screenHeight/2 + (gp.tileSize*4); //+ (gp.tileSize*4);
            g2.drawString(text, x, y);

            g2.setFont(arial_80B);
            g2.setColor(Color.YELLOW);
            text = "Congrats!";
            textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
            x = gp.screenWidth/2 - textLength/2;
            y = gp.screenHeight/2 + (gp.tileSize*2); //+ (gp.tileSize*2);
            g2.drawString(text, x, y);

            gp.gameThread = null;

        }

        else{

        }
        
    }

    public void drawPlayerLife(){
        
        /* g2.setColor(new Color(0, 120, 80, 220));
        g2.fillRect(40, 20, gp.tileSize*3+15, gp.tileSize*2);  */

        //gp.player.life = 5;

        int x = gp.tileSize/2+20;
        int y = gp.tileSize/2+40;
        int i = 0;

        //DRAW BLANK HEART
        while (i < gp.player.maxLife / 2) {
            g2.drawImage(heart_blank, x, y, null);
            i++;
            x += gp.tileSize;
        }   

        //RESET
        x = gp.tileSize/2+20;
        y = gp.tileSize/2+40;
        i = 0; 

        //DRAW CURRENT LIFE
        while(i < gp.player.life) {
            g2.drawImage(heart_half, x, y, null);
            i++;
            if(i < gp.player.life) {
                g2.drawImage(heart_full, x, y, null);
            }
            i++;
            x += gp.tileSize;            
        }
        
        //LIFE TEXT
        /* String text = "-- Life --";
        g2.setColor(Color.WHITE);
        x += gp.tileSize-190;
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN,48F));
        y += gp.tileSize/2-30;
        g2.drawString(text, x, y); */

    }

    public void drawTitleScreen(){

        //FIRST SCREEN UI
        if(titleScreenState == 0) {

            g2.setColor(new Color(70, 120, 80));
            g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);

            //TITLE NAME
            g2.setFont(g2.getFont().deriveFont(Font.BOLD,96F));
            String text = "Sagitta Viridis";
            int x = getXforCenteredText(text);
            int y = gp.tileSize*2;

            //SHADOW
            g2.setColor(Color.black);
            g2.drawString(text, x+5, y+5);
            
            //MAIN COLOR
            g2.setColor(Color.white);
                /* try {
                    BufferedImage image = ImageIO.read(new File("/tiles/new/grass00", "grass00.png"));
                    draw(g2);
                } catch (IOException e) {
                    e.printStackTrace();
                } */
            g2.drawString(text, x, y);

            //BLUE BOY IMAGE
            x = gp.screenWidth/2 - (gp.tileSize*2)/2;
            y += gp.tileSize*2;
            g2.drawImage(gp.player.down1, x, y, gp.tileSize*2, gp.tileSize*2, null);

            //MENU
            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 48F));

            text = "New Game";
            x = getXforCenteredText(text);
            y += gp.tileSize*3.5;
            g2.drawString(text, x, y);
            if(commandNum == 0) {
                g2.drawString(">", x - gp.tileSize, y);
            }

            text = "Load game";
            x = getXforCenteredText(text);
            y += gp.tileSize; //Why doesn't it gets displayed if tileSize*4 ?
            g2.drawString(text, x, y);
            if(commandNum == 1) {
                g2.drawString(">", x - gp.tileSize, y);
            }

            text = "Settings";
            x = getXforCenteredText(text);
            y += gp.tileSize; //Why doesn't it gets displayed if tileSize*4 ?
            g2.drawString(text, x, y);
            if(commandNum == 2) {
                g2.drawString(">", x - gp.tileSize, y);
            }

            
            text = "Quit Game";
            x = getXforCenteredText(text);
            y += gp.tileSize; //Why doesn't it gets displayed if tileSize*4 ?
            g2.drawString(text, x, y);
            if(commandNum == 3) {
                g2.drawString(">", x - gp.tileSize, y);
            }

            

            text = "@CreepyVenger";
            x = gp.tileSize/3;
            y += gp.tileSize*2;
            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 26F));
            g2.drawString(text, x, y); 

        }

        //SECOND SCREEN UI OF FIRST LINE (New Game)
        else if(titleScreenState == 1) {    

            g2.setColor(new Color(70, 120, 80));
            g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);

            //CLASS SELECTION SCREEN
            g2.setColor(Color.white);
            
            //MENU
            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 48F));

            String text = "Select your class!";
            int x = getXforCenteredText(text);
            int y = gp.tileSize*3;
            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 48));
            g2.drawString(text, x, y);

            text = ""; //LINE SPACE 
            x = getXforCenteredText(text);
            y += gp.tileSize;
            g2.drawString(text, x, y);
            
            text = "Fighter";
            x = getXforCenteredText(text);
            y += gp.tileSize;
            g2.drawString(text, x, y);
            if(commandNum == 0) {
                g2.drawString(">", x - gp.tileSize, y);            
            }

            text = "Thief";
            x = getXforCenteredText(text);
            y += gp.tileSize;
            g2.drawString(text, x, y);
            if(commandNum == 1) {
                g2.drawString(">", x - gp.tileSize, y);            
            }

            text = "Witcher";
            x = getXforCenteredText(text);
            y += gp.tileSize;
            g2.drawString(text, x, y);
            if(commandNum == 2) {
                g2.drawString(">", x - gp.tileSize, y);            
            }

            text = "Return";
            x = getXforCenteredText(text);
            y += gp.tileSize;
            g2.drawString(text, x, y);
            if(commandNum == 3) {
                g2.drawString(">", x - gp.tileSize, y);            
            }

        }

        //SECOND SCREEN UI OF SECOND LINE (LOAD GAME) TO DO
        else if(titleScreenState == 1) {

        } 

        //SECOND SCREEN UI OF THIRD LINE (Settings)
        else if(titleScreenState == 2) {    

            g2.setColor(new Color(70, 120, 80));
            g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);

            //CLASS SELECTION SCREEN
            g2.setColor(Color.white);
            
            //MENU
            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 48F));

            String text = "Select you settings";
            int x = getXforCenteredText(text);
            int y = gp.tileSize*3;
            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 48));
            g2.drawString(text, x, y);

            text = ""; //LINE SPACE 
            x = getXforCenteredText(text);
            y += gp.tileSize;
            g2.drawString(text, x, y);
            
            text = "Sound";
            x = 250;
            y += gp.tileSize;
            g2.drawString(text, x, y);
            if(commandNum == 0) {
                g2.drawString(">", x - gp.tileSize, y);            
            }

        //if(StettingsSoundState == 0) {
            if(commandNumLat == 0) {
                text = "Sound Off";
                //x = gp.tileSize*10;
                x = 400;
                y += gp.tileSize;
                
                g2.setColor(Color.yellow);
                g2.drawString(text, x-25, y-48);         //x-153, y-48 to superpose both sound and sound options   
            }

            else if(commandNumLat == 1) {
                text = "Sound On";
                //x = gp.tileSize*10;
                x = 400;
                y += gp.tileSize;
                
                g2.setColor(Color.yellow);
                g2.drawString(text, x-25, y-48);         //x-153, y-48 to superpose both sound and sound options   
            }
        //}
            
            /* else if (StettingsSoundState == 1){
                
            } */

            g2.setColor(Color.white);
            text = "Language (WorkInProgress)";
            x = getXforCenteredText(text);
            y += gp.tileSize - 50; 
            g2.drawString(text, x, y);
            if(commandNum == 1) {
                g2.drawString(">", x - gp.tileSize, y);            
            }

            text = "Difficulty (WorkInProgress)";
            x = getXforCenteredText(text);
            y += gp.tileSize;
            g2.drawString(text, x, y);
            if(commandNum == 2) {
                g2.drawString(">", x - gp.tileSize, y);            
            }

            text = ""; //LINE SPACE 
            x = getXforCenteredText(text);
            y += gp.tileSize;
            g2.drawString(text, x, y);

            text = ""; //LINE SPACE 
            x = getXforCenteredText(text);
            y += gp.tileSize;
            g2.drawString(text, x, y);

            text = "Return";
            x = getXforCenteredText(text);
            y += gp.tileSize;
            g2.drawString(text, x, y);
            if(commandNum == 3) {
                g2.drawString(">", x - gp.tileSize, y);            
            }

        }

    }

    public void drawPauseScreen() {

        g2.setColor(new Color(70, 120, 80, 160));
        g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);

        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 80F));
        g2.setColor(Color.YELLOW);
        String text = "PAUSED";
        int x = getXforCenteredText(text);
        int y = gp.screenHeight/2;
        g2.drawString(text, x, y);
    }

    public void drawDeathScreen() {

        //if(gp.player.life <= 0){

            g2.setColor(new Color(70, 120, 80, 160));
            g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);

            g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 80F));
            g2.setColor(Color.RED);
            String text = "YOU DIED";
            int x = getXforCenteredText(text);
            int y = gp.screenHeight/2;
            g2.drawString(text, x, y);
        //}
    }

    public void drawDialogueScreen() {

        //WINDOW
        int x = gp.tileSize*2;
        int y = gp.tileSize/2;
        int width = gp.screenWidth - (gp.tileSize*4);
        int height = gp.tileSize*4;

        drawSubWindow(x, y, width, height);

        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 32F));
        x += gp.tileSize;
        y += gp.tileSize;

        for(String line : currentDialogue.split("\n")) {
            g2.drawString(line, x, y);
            y += 40;
        }
        
    }

    public void drawSubWindow(int x, int y, int width, int height) {

        Color c = new Color(0,0,0, 200);
        g2.setColor(c);
        g2.fillRoundRect(x, y, width, height, 35, 35);

        c = new Color(255, 255, 255);
        g2.setColor(c); 
        g2.setStroke(new BasicStroke(5));
        g2.drawRoundRect(x+5, y+5, width-10, height-10, 25, 25);;
    }

    public int getXforCenteredText (String text) {

        int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = gp.screenWidth/2 - length/2;
        return x;
    }

}
