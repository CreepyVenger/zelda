package entity;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
//import java.io.IOException;

//import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;
//import main.UtilityTool;
import tile.Tile;
import tile.TileManager;

public class Player extends Entity {

    /* private BufferedImage[] spriteSheet;
    private BufferedImage[] waterSpriteSheet;
    private int currentFrame; */

    //private BufferedImage waterSpriteSheet;

    //GamePanel gp;
    KeyHandler keyH;
    TileManager tileManager;

    public final int screenX;
    public final int screenY;
    public int hasKey = 0;
    int hasBoots = 0;
    int numdoors = 0;
    
    private boolean onWater = false;
    
    public Player(GamePanel gp, KeyHandler keyH, TileManager tileManager) {
        
        super(gp);

        //this.gp = gp;
        this.keyH = keyH;
        this.tileManager = tileManager;
        
        screenX = gp.screenWidth / 2 - (gp.tileSize / 2);
        screenY = gp.screenHeight / 2 - (gp.tileSize / 2);

        solidArea = new Rectangle();
        solidArea.x = 8; // 8 left
        solidArea.y = 16; // 16 up //25
        solidAreaDedaultX = solidArea.x;
        solidAreaDedaultY = solidArea.y;
        solidArea.width = 32; // 32 right
        solidArea.height = 32; // 32 down //12
        
        attackArea.width = 36;
        attackArea.height = 36;
        
        setDefaultValues();
        getPlayerGroundImage();
        getPlayerWaterImage();
        getPlayerAttackImage();

    }

    /* private BufferedImage[] loadSpriteSheet(String path, int rows, int cols) {
        BufferedImage spriteSheetImage = null;
        try {
            spriteSheetImage = ImageIO.read(getClass().getResourceAsStream(path));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Calculate the dimensions of each sprite in the sprite sheet...
        int spriteWidth = spriteSheetImage.getWidth() / cols;
        int spriteHeight = spriteSheetImage.getHeight() / rows;

        // Split the sprite sheet into individual sprites...
        BufferedImage[] sprites = new BufferedImage[rows * cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sprites[i * cols + j] = spriteSheetImage.getSubimage(j * spriteWidth, i * spriteHeight, spriteWidth, spriteHeight);
            }
        }

        return sprites;
    } */
    

    public void detectWaterTile() {
        //TileManager tileManager = TileManager.getTileManager();
        Tile currentTile = tileManager.getTileAtPosition(worldX, worldY);
        boolean wasOnWater = onWater; // Store the previous onWater state
        
        onWater = currentTile.isWater();    

        // If the onWater state has changed, update the player's sprite image
        if (wasOnWater != onWater) {
            if (onWater) {
                getPlayerWaterImage(); // Call the method to get the water sprite image
            } else {
                getPlayerGroundImage(); // Call the method to get the regular sprite image
            }
        }
    }

    /* public boolean isOnWater() {
        return onWater;
    } */

    public void setOnWater(boolean onWater) {
            this.onWater = onWater;
        }   
    
    public void setDefaultValues() {

        //PLAYER COOREDINATES WORLD SPAWN
        worldX = gp.tileSize * 23; 
        worldY = gp.tileSize * 21; 

        speed = gp.worldWidth / 600;
        speedGround = speed*3;
        //speedWater = speed/3;
        speedWater = speed*3    ;
        //speedGroundBoots = speedGround;
        //int speedWaterBoots;
        
        direction = "down";

        //PLAYER STATUS
        maxLife = 6;
        life = maxLife;
    }

    public void getPlayerGroundImage() {
        /* try {
            up1 = ImageIO.read(getClass().getResourceAsStream("/player/ground/boy_up_1.png",gp.tileSize, gp.tileSize));
            up2 = ImageIO.read(getClass().getResourceAsStream("/player/ground/boy_up_2.png",gp.tileSize, gp.tileSize));
            down1 = ImageIO.read(getClass().getResourceAsStream("/player/ground/boy_down_1.png",gp.tileSize, gp.tileSize));
            down2 = ImageIO.read(getClass().getResourceAsStream("/player/ground/boy_down_2.png",gp.tileSize, gp.tileSize));
            left1 = ImageIO.read(getClass().getResourceAsStream("/player/ground/boy_left_1.png",gp.tileSize, gp.tileSize));
            left2 = ImageIO.read(getClass().getResourceAsStream("/player/ground/boy_left_2.png",gp.tileSize, gp.tileSize));
            right1 = ImageIO.read(getClass().getResourceAsStream("/player/ground/boy_right_1.png",gp.tileSize, gp.tileSize));
            right2 = ImageIO.read(getClass().getResourceAsStream("/player/ground/boy_right_2.png",gp.tileSize, gp.tileSize));

        } catch (IOException e) {
            e.printStackTrace();
        } */

        /* up1 = setupground("/player/ground/boy_up_1",gp.tileSize, gp.tileSize);
        up2 = setupground("/player/ground/boy_up_2",gp.tileSize, gp.tileSize);
        down1 = setupground("/player/ground/boy_down_1",gp.tileSize, gp.tileSize);
        down2 = setupground("/player/ground/boy_down_2",gp.tileSize, gp.tileSize);
        left1 = setupground("/player/ground/boy_left_1",gp.tileSize, gp.tileSize);
        left2 = setupground("/player/ground/boy_left_2",gp.tileSize, gp.tileSize);
        right1 = setupground("/player/ground/boy_right_1",gp.tileSize, gp.tileSize);
        right2 = setupground("/player/ground/boy_right_2",gp.tileSize, gp.tileSize); */

        up1 = setupground("/player/Perry_ground/Perry_up_1", gp.tileSize, gp.tileSize);
        up2 = setupground("/player/Perry_ground/Perry_up_2",gp.tileSize, gp.tileSize);
        down1 = setupground("/player/Perry_ground/Perry_down_1",gp.tileSize, gp.tileSize);
        down2 = setupground("/player/Perry_ground/Perry_down_2",gp.tileSize, gp.tileSize);
        left1 = setupground("/player/Perry_ground/Perry_left_1",gp.tileSize, gp.tileSize);
        left2 = setupground("/player/Perry_ground/Perry_left_2",gp.tileSize, gp.tileSize);
        right1 = setupground("/player/Perry_ground/Perry_right_1",gp.tileSize, gp.tileSize);
        right2 = setupground("/player/Perry_ground/Perry_right_2",gp.tileSize, gp.tileSize);

    }

    public void getPlayerWaterImage() {
    /* try {
        up = ImageIO.read(getClass().getResourceAsStream("/player/water/boy_up_water.png",gp.tileSize, gp.tileSize));
        down = ImageIO.read(getClass().getResourceAsStream("/player/water/boy_down_water.png",gp.tileSize, gp.tileSize));
        left = ImageIO.read(getClass().getResourceAsStream("/player/water/boy_left_water.png",gp.tileSize, gp.tileSize));
        right = ImageIO.read(getClass().getResourceAsStream("/player/water/boy_right_water.png",gp.tileSize, gp.tileSize));

    } catch (IOException e) {
        e.printStackTrace();
    } */

    /* waterUp = setupwater("/player/water/boy_up_water",gp.tileSize, gp.tileSize);
    waterDown = setupwater("/player/water/boy_down_water",gp.tileSize, gp.tileSize);
    waterLeft = setupwater("/player/water/boy_left_water",gp.tileSize, gp.tileSize);
    waterRight = setupwater("/player/water/boy_right_water",gp.tileSize, gp.tileSize); */

    waterUp = setupwater("/player/water/boat_up",gp.tileSize, gp.tileSize);
    waterDown = setupwater("/player/water/boat_down",gp.tileSize, gp.tileSize);
    waterLeft = setupwater("/player/water/boat_left",gp.tileSize, gp.tileSize);
    waterRight = setupwater("/player/water/boat_right",gp.tileSize, gp.tileSize); 

}

    public void getPlayerAttackImage() {
        attackUp1 = setupground("/player/Attacking_sprites/boy_attack_up_1",gp.tileSize, gp.tileSize*2);
        attackUp2 = setupground("/player/Attacking_sprites/boy_attack_up_2",gp.tileSize, gp.tileSize*2);
        attackDown1 = setupground("/player/Attacking_sprites/boy_attack_down_1",gp.tileSize, gp.tileSize*2);
        attackDown2 = setupground("/player/Attacking_sprites/boy_attack_down_2",gp.tileSize, gp.tileSize*2);
        attackLeft1 = setupground("/player/Attacking_sprites/boy_attack_left_1",gp.tileSize*2, gp.tileSize);
        attackLeft2 = setupground("/player/Attacking_sprites/boy_attack_left_2",gp.tileSize*2, gp.tileSize);
        attackRight1 = setupground("/player/Attacking_sprites/boy_attack_right_1",gp.tileSize*2, gp.tileSize);
        attackRight2 = setupground("/player/Attacking_sprites/boy_attack_right_2",gp.tileSize*2, gp.tileSize);

    }
    
    /* public BufferedImage setupground(String imageName) {

        UtilityTool uTool = new UtilityTool();
        BufferedImage image = null;
        
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/player/ground/" + imageName  + ".png"));
            image = uTool.scaleImage(image, gp.tileSize, gp.tileSize);
            
        } catch (IOException e) {
            e.printStackTrace();
        }

        return image;
    }  */

    /* public BufferedImage setupwater(String imageName) {

        UtilityTool uTool = new UtilityTool();
        BufferedImage image = null;
        
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/player/water/" + imageName  + ".png"));
            image = uTool.scaleImage(image, gp.tileSize, gp.tileSize);
            
        } catch (IOException e) {
            e.printStackTrace();
        }

        return image;
    } */

    public void update() {

        detectWaterTile();

        if(attacking == true) {
            attacking();
        }
        
        else if (keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true || keyH.rightPressed == true || keyH.enterPressed == true) {

            if (keyH.upPressed == true) {
                direction = "up";
            } else if (keyH.downPressed == true) {
                direction = "down";
            } else if (keyH.leftPressed == true) {
                direction = "left";
            } else if (keyH.rightPressed == true) {
                direction = "right";
            }

            //CHECK COLLISION
            collisionOn = false;
            gp.cChecker.checkTile(this);

            //CHECK OBJECT COLLISION
            int objIndex = gp.cChecker.CheckObject(this, true);
            PickUpObject(objIndex);

            //CHECK NPC COLLISION
            int npcIndex = gp.cChecker.checkEntity(this, gp.npc);
            interactNPC(npcIndex);

            //CHECK MONSTER COLLISION
            int monsterIndex = gp.cChecker.checkEntity(this, gp.monster);
            conctactMonster(monsterIndex);

            //CHECK EVENT
            gp.eHandler.checkEvent();

            //IF COLLISION IS FALSE, PLAYER CAN MOVE
            if (collisionOn == false && keyH.enterPressed == false ) { // isn't it if (!collisionOn) {} ?????: TO VERIFY
                switch (direction) {
                    case "up": worldY -= speed; break;
                    case "down": worldY += speed; break;
                    case "left": worldX -= speed; break;
                    case "right": worldX += speed; break;   
                }
            }

            gp.keyH.enterPressed = false;

            spriteCounter++;
            if (spriteCounter > 12) {
                if (spriteNum == 1) {
                    spriteNum = 2;
                } else if (spriteNum == 2) {
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
            //I DONT KNOW WHAT THIS IS: TO VERIFY
            /* else {
                standCounter++;
                if (standCounter == 20) {
                    spriteNum = 1;
                    standCounter = 0;

                    } else if (spriteNum == 2) {
                        spriteNum = 1;
                    }
                    standCounter = 0;
                }
         */
        }
        
        //gp.player.draw(g2)

        //This need to be outside of key if statement!
        if(invincible == true) {
            invincibleCounter++;

            if(invincibleCounter > 30) { //The damage method to the player when he hits a Green Slime gets called 60times/seconds (60frames per seconds or FPS)
                invincible = false;
                invincibleCounter = 0;
            }
        }
    }
    
    public void attacking() {

        spriteCounter++;

        if(spriteCounter <= 5) {
            spriteNum = 1;
        }

        if(spriteCounter > 5 && spriteCounter <= 25) {
            spriteNum = 2;

            //Save the current worldX, worldY, solidArea
            int currentWorldX = (int) worldX;
            int currentWorldY = (int) worldY;
            int solidAreaWidth = solidArea.width;
            int solidAreaheight = solidArea.height;

            //Adjust player's worldX/Y for the attackArea

            switch(direction) {
                case "up": worldY -= attackArea.height; break;
                case "down": worldY += attackArea.height; break;
                case "left": worldY -= attackArea.width; break;
                case "right": worldY += attackArea.width; break;
            }

            //attackArea becomes solidArea
            solidArea.width = attackArea.width;
            solidArea.height = attackArea.height;

            //Check monster collision with the updated WorldX, worldY, and solidArea
            int monsterIndex = gp.cChecker.checkEntity(this, gp.monster);
            damageMonster(monsterIndex);
            
            //After checking collision, restore the original data
            worldX = currentWorldX;
            worldY = currentWorldY;
            solidArea.width = solidAreaWidth;
            solidArea.height = solidAreaheight;

        }

        if(spriteCounter > 25) {
            spriteNum = 1;
            spriteCounter = 0;
            attacking = false;
        }

    }

    public void PickUpObject(int i) {

        if (i != 999) {

            // COMMENT THIS TO AVOID CHESS HUNTING
            String objectName = gp.obj[i].name;

            switch(objectName) {
                case "Key":
                    gp.playSE(1);
                    hasKey++;
                    gp.obj[i] = null;
                    gp.ui.showMessage("you found a key!");
                    System.out.println("Key: " + hasKey);
                    break;  

                case "Door":
                    numdoors++;
                    if (hasKey > 0) {
                        gp.playSE(3);
                        gp.obj[i] = null;
                        hasKey--;
                        gp.ui.showMessage("You oppened a door!");
                        System.out.println("Door opened: " + numdoors);
                        System.out.println("Key: " + hasKey);
                    }
                    else{
                        gp.ui.showMessage("You cannot open the door, look for a key!");                              
                    }
                    break;   

                case "speedBoots":
                    gp.playSE(2);
                    speedBoots = speedGround += 4; //increase to increase boots speed
                    //speedBoots = speedGround*2; //2 times faster but doesn't work 
                    hasBoots++;
                    gp.obj[i] = null;
                    gp.ui.showMessage("you found the SpeedBoots! Speed + 4!"); 
                    System.out.println("Boots: " + hasBoots);
                    break;  

                case "Chest":
                    gp.ui.gameFinished = true; //If we pickup the chest, gameFInished comes true and UI condition applies
                    gp.stopMusic();
                    gp.playSE(4);
                    break;
            }
        }
    }

    public void interactNPC(int i) {

        if(gp.keyH.enterPressed == true) { 

            if(i != 999){
                System.out.println("You are hitting me!");

                //Uncomment if you want the text to be displayed whenever you hit a npc

                /* gp.gameState = gp.dialogueState;
                gp.npc[i].speak(); */

                //Uncomment if you want the text to open only if the enter button is pressed

                gp.gameState = gp.dialogueState;
                gp.npc[i].speak();
            }
            
            //gp.keyH.enterPressed = false; //NOT USEFULL

            else{
                attacking = true; 
            }
        }  
    }

    public void conctactMonster(int i) {

        if(i != 999) {
            
            if(invincible == false) {
                life -= 1;
                invincible = true;
            }
        }
    }

    public void damageMonster(int i) {
        
        if(i != 999) {
            System.out.println("You hit the Green Slime !");

            if(gp.monster[i].invincible == false) {
                //System.out.println("zizi1");
                gp.monster[i].life -= 1;
                gp.monster[i].invincible = true;

                if(gp.monster[i].life <= 0) {
                    gp.monster[i] = null;
                    System.out.println("zizi");
                }
            }
        }

        /* else{
            System.out.println("Miss, retry !");

        } */

    }

    public void draw(Graphics2D g2) {

        Tile currentTile = tileManager.getTileAtPosition(worldX, worldY);
        onWater = (currentTile != null && currentTile.isWater());
        //System.out.println("Player Position: X=" + worldX + ", Y=" + worldY); 
        
        if (currentTile == null) {
            return; // Skip rendering the player if outside the game world
        }

        if (onWater) {
            // Draw the player swimming sprite
            //System.out.println("onWater: " + onWater);
            BufferedImage image = null;
            if(hasBoots > 0){
                speed  = speedGround/3;
            }
            else{
                speed  = speedWater;
            }  

            //speed = speedWater;
            switch (direction) {

                case "up":
                    if (spriteNum == 1) { image = waterUp; } 
                    if (spriteNum == 2) { image = waterUp; } 
                    break;

                case "down":
                    if (spriteNum == 1) { image = waterDown; } 
                    if (spriteNum == 2) { image = waterDown; }   
                    break;

                case "left":
                    if (spriteNum == 1) { image = waterLeft; } 
                    if (spriteNum == 2) { image = waterLeft; }
                    break;

                case "right":
                    if (spriteNum == 1) { image = waterRight; }  
                    if (spriteNum == 2) { image = waterRight; }
                    break;
            }

            if (image != null) {
                g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
            }
            
        } else {
            // Draw the regular player sprite
            BufferedImage image = null;

            if(hasBoots > 0){
                speed  = speedBoots;
            }
            else{
                speed  = speedGround;
            } 
            //speed = speedGround;

            int tempScreenX = screenX;
            int tempScreenY = screenY;

            switch (direction) {

                case "up": 
                    if(attacking == false) {
                        if (spriteNum == 1) { image = up1; } 
                        if (spriteNum == 2) { image = up2; }
                    }

                    if(attacking == true) {
                        tempScreenY = screenY - gp.tileSize;
                        if (spriteNum == 1) { image = attackUp1; } 
                        if (spriteNum == 2) { image = attackUp2; }
                    }
                    break;

                case "down": 
                    if(attacking == false) {
                        if (spriteNum == 1) { image = down1; } 
                        if (spriteNum == 2) { image = down2; }
                    }

                    if(attacking == true) {
                        if (spriteNum == 1) { image = attackDown1; } 
                        if (spriteNum == 2) { image = attackDown2; }
                    }
                    break;
                    
                case "left": 
                    if(attacking == false) {
                        if (spriteNum == 1) { image = left1; } 
                        if (spriteNum == 2) { image = left2; }
                    }

                    if(attacking == true) {
                        tempScreenX = screenX - gp.tileSize;
                        if (spriteNum == 1) { image = attackLeft1; } 
                        if (spriteNum == 2) { image = attackLeft2; }
                    }
                    break;

                case "right": 
                    if(attacking == false) {
                        if (spriteNum == 1) { image = right1; } 
                        if (spriteNum == 2) { image = right2; }
                    }

                    if(attacking == true) {
                        if (spriteNum == 1) { image = attackRight1; } 
                        if (spriteNum == 2) { image = attackRight2; }
                    }
                    break;

                 
            }

            /* if (image != null) {
                //g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
                g2.drawImage(image, screenX, screenY, null);
                //g2.fillRect(screenX + solidArea.x, screenY + solidArea.y, solidArea.width, solidArea.height); 
            } */

            if(invincible == true) {
                g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.4f)); //Transparancy
            }

            g2.drawImage(image, tempScreenX, tempScreenY, null); //This or the if condition above with this inside ?

            //RESET ALPHA
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));

            //DEBUG
            g2.setFont(new Font("Arial", Font.PLAIN, 26));
            g2.setColor(Color.white);
            g2.drawString("Invincible:" + invincibleCounter, 10, 400);

        }
    }

}   