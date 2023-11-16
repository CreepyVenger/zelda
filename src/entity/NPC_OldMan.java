package entity;

import java.util.Random;

/* import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO; */

import main.GamePanel;
//import main.UtilityTool;

public class NPC_OldMan extends Entity{

    public NPC_OldMan(GamePanel gp) {
        super(gp);

        direction = "down";
        speed = 1;

        getImage();
        setDialogue();

    }
    
    public void getImage() {

        up1 = setupground("/npc/oldman_up_1",gp.tileSize, gp.tileSize);
        up2 = setupground("/npc/oldman_up_2",gp.tileSize, gp.tileSize);
        down1 = setupground("/npc/oldman_down_1",gp.tileSize, gp.tileSize);
        down2 = setupground("/npc/oldman_down_2",gp.tileSize, gp.tileSize);
        left1 = setupground("/npc/oldman_left_1",gp.tileSize, gp.tileSize);
        left2 = setupground("/npc/oldman_left_2",gp.tileSize, gp.tileSize);
        right1 = setupground("/npc/oldman_right_1",gp.tileSize, gp.tileSize);
        right2 = setupground("/npc/oldman_right_2",gp.tileSize, gp.tileSize);

}
    
    public void setDialogue() {

        dialogues[0] = "Hello, I'm the Wizard!";
        dialogues[1] = "So, you've come to this island to \nfind the treasure?";
        dialogues[2] = "I used to be a great Wizard \nbut now... unfortunately I'm too old to \ngo on an adventure.";
        dialogues[3] = "Good luck, blue Boy, \non your journey...";
        
    }

    public void setAction() {

        actionLockCounter++;

        if(actionLockCounter == 120) {

            Random random = new Random();
            int i  = random.nextInt(100)+1; //it will pick up a number from 0 to 100

            if(i <= 25) {
                direction = "up";
            }

            if(i > 25 && i <= 50) {
                direction = "down";
            }

            if(i > 50 && i <= 75) {
                direction = "left";
            }

            if(i > 75 && i <= 100) {
                direction = "right";        
            }

            actionLockCounter = 0;
        }
  
    }


    public void speak() {

        //Do this character  scpecific  stuff
        super.speak();
    }

}
