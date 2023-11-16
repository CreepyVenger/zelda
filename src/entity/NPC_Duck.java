package entity;

import java.util.Random;

/* import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO; */

import main.GamePanel;
//import main.UtilityTool;

public class NPC_Duck extends Entity{

    public NPC_Duck(GamePanel gp) {
        super(gp);

        direction = "down";
        speed = 1;

        getImage();
        setDialogue();

    }
    
    public void getImage() {

        up1 = setupground("/npc/duck/Duck_up_1",gp.tileSize, gp.tileSize);
        up2 = setupground("/npc/duck/Duck_up_2",gp.tileSize, gp.tileSize);
        down1 = setupground("/npc/duck/Duck_down_1",gp.tileSize, gp.tileSize);
        down2 = setupground("/npc/duck/Duck_down_2",gp.tileSize, gp.tileSize);
        left1 = setupground("/npc/duck/Duck_left_1",gp.tileSize, gp.tileSize);
        left2 = setupground("/npc/duck/Duck_left_2",gp.tileSize, gp.tileSize);
        right1 = setupground("/npc/duck/Duck_right_1",gp.tileSize, gp.tileSize);
        right2 = setupground("/npc/duck/Duck_right_2",gp.tileSize, gp.tileSize);

}
    
    public void setDialogue() {

        dialogues[0] = "Hello, I'm the Duck!";
        dialogues[1] = "Coin Coin!";
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

        ;
        
    }

    //OLD METHOD

    /* public void speak() {

        gp.ui.currentDialogue = dialogues[0];
    } */

    public void speak() {

        super.speak();

        //Same way of doing for every npc so we just call the method and put this code below in entity class in the speak(); method.

        /* if(dialogues[dialogueIndexDuck] == null) {
            dialogueIndexDuck = 0;
        } 
        
        gp.ui.currentDialogue = dialogues[dialogueIndexDuck];
        dialogueIndexDuck++;

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

        }  */
    }

}
