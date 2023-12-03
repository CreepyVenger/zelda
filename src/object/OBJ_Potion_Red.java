package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Potion_Red extends Entity {

    GamePanel gp;
    int value = 5;

    public OBJ_Potion_Red(GamePanel gp) {
        
        super(gp);

        this.gp = gp;

        type = type_consumable;
        name = "Red potion";
        down1 = setupground("/objects/potion_red_2", gp.tileSize, gp.tileSize);
        description = "[" + name + "]\nheals your life by " + value;
    }

    public void use(Entity entity) {

        gp.gameState = gp.dialogueState;
        gp.ui.currentDialogue = "You drank the " + name + "!\n" + "Your life has now been restored by " + value;

        entity.life += value;
        
        if(gp.player.life > gp.player.maxLife) {
            gp.player.life = gp.player.maxLife;
        }

        gp.playSE(2);

    }   
   
}