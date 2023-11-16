package entity;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.UtilityTool;

public class Entity {

    GamePanel gp; 
    
    /* public double speedOfSpeedBoots;
    public double speedofSlowBoots; */
    
    public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2, waterUp, waterDown, waterLeft, waterRight;
    public BufferedImage attackUp1, attackUp2, attackDown1, attackDown2, attackLeft1, attackLeft2, attackRight1, attackRight2;
    public BufferedImage image, image2, image3;
    public Rectangle solidArea = new Rectangle(0, 0, 48, 48);
    public Rectangle attackArea = new Rectangle(0, 0, 0, 0);
    public int solidAreaDedaultX, solidAreaDedaultY;
    String dialogues[] = new String[20];

    //STATE
    public double worldX, worldY;
    public String direction = "down"; //objects don't change dirrection so it's ok
    public int spriteNum = 1;
    int dialogueIndexglobal = 0;
        int dialogueIndexOldMan = 0;
        int dialogueIndexDuck = 0;
        int dialogueIndexFrog = 0;
    public boolean collisionOn = false;
    public boolean invincible = false;
    boolean attacking  = false;

    //COUNTER
    public int spriteCounter = 0;
    public int actionLockCounter = 0;
    public int invincibleCounter = 0;

    public int standCounter = 0; //not usefull ?

    //CHARACTER ATTRIBUTES
    public int type; //0 = Player, 1 = NPC, 2 = Monster
    public String name;
    public double speed;
        public double speedGround; 
        public double speedWater; 
        public double speedBoots;
    public int maxLife;
    public int life;

    public boolean collision = false; //not usefull ?

    //public boolean isSwmiming = false;
    //public boolean waterDetectionOn = false;
    //public boolean collisionOn;



    public Entity(GamePanel gp) {
        this.gp = gp;
    }

    public void setAction() {}
    
    public void speak() {

        if(dialogues[dialogueIndexglobal] == null) {
            dialogueIndexglobal = 0;
        } 
        
        gp.ui.currentDialogue = dialogues[dialogueIndexglobal];
        dialogueIndexglobal++;

        switch(gp.player.direction) { //Switch or if statement
            case "up":
                direction = "down";
                break;
            
            case "down":
                direction = "up";
                break;
            
            case "right":
                direction = "left";
                break;

            case "left":
                direction = "right";
                break;
        } 

        if(invincible == true) {
            invincibleCounter++;
            if(invincibleCounter > 20) { //The damage method to the player when he hits a Green Slime gets called 60times/seconds (60frames per seconds or FPS)
                invincible = false;
                invincibleCounter = 0;
            }
        }
    }
    public void update() {

        setAction();

        collisionOn = false;
        gp.cChecker.checkTile(this);
        gp.cChecker.CheckObject(this, false);
        gp.cChecker.checkEntity(this, gp.npc);
        gp.cChecker.checkEntity(this, gp.monster);
        boolean contactPlayer = gp.cChecker.checkPlayer(this);

        if(this.type == 2 && contactPlayer == true) {
            if(gp.player.invincible == false) {
                //We can give damage
                gp.player.life -=1;
                gp.player.invincible = true;
            }
        }

        //IF COLLISION IS FALSE, PLAYER CAN MOVE
        if (collisionOn == false) { // isn't it if (!collisionOn) {} ?????: TO VERIFY
                switch (direction) {
                    case "up": worldY -= speed; break;
                    case "down": worldY += speed; break;
                    case "left": worldX -= speed; break;
                    case "right": worldX += speed; break;   
                }
            }

            spriteCounter++;
            if (spriteCounter > 12) {
                if (spriteNum == 1) {
                    spriteNum = 2;
                } else if (spriteNum == 2) {
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }

            if(invincible == true) {
                invincibleCounter++;

                if(invincibleCounter > 30) {
                    invincible = false;
                    invincibleCounter = 0;
                }
            }
    } 

    public void draw(Graphics2D g2) {

        BufferedImage image = null;

        double screenX = worldX - gp.player.worldX + gp.player.screenX;
        double screenY = worldY - gp.player.worldY + gp.player.screenY;

            if(worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
               worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
               worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
               worldY - gp.tileSize < gp.player.worldY + gp.player.screenY) {

                switch (direction) {
                    case "up":
                        if (spriteNum == 1) { image = up1; }
                        if (spriteNum == 2) { image = up2; }
                        break;

                    case "down":
                        if (spriteNum == 1) { image = down1; } 
                        if (spriteNum == 2) { image = down2; }
                        break;

                    case "left":
                        if (spriteNum == 1) { image = left1; } 
                        if (spriteNum == 2) { image = left2; }
                        break;
                        
                    case "right":
                        if (spriteNum == 1) { image = right1; } 
                        if (spriteNum == 2) { image = right2; }
                        break;
                }

                if(invincible == true) {
                    g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.4f)); //Transparancy
                }

                g2.drawImage(image, (int)screenX, (int)screenY, gp.tileSize, gp.tileSize, null);
               
                g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));

            }
    }

    public BufferedImage setupground(String imagePath, int width, int height) {

        UtilityTool uTool = new UtilityTool();
        BufferedImage image = null;
        
        try {
            image = ImageIO.read(getClass().getResourceAsStream(imagePath  + ".png"));
            image = uTool.scaleImage(image, width, height); //before, it was gp.tileSize for both
            
        } catch (IOException e) {
            e.printStackTrace();
        }

        return image;
    }

    public BufferedImage setupwater(String imagePath, int width, int height) {

        UtilityTool uTool = new UtilityTool();
        BufferedImage image = null;
        
        try {
            image = ImageIO.read(getClass().getResourceAsStream(imagePath  + ".png"));
            image = uTool.scaleImage(image, width, height);
            
        } catch (IOException e) {
            e.printStackTrace();
        }

        return image;
    }
}