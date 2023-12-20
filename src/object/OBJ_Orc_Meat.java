package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Orc_Meat extends OBJ_Potion_Red{

    private String name;
    private int value;

    public OBJ_Orc_Meat(GamePanel gp){
        super(gp);

        this.name="OBJ_Orc_Meat";
        down1 = setupground("/objects/lantern", gp.tileSize, gp.tileSize);
        description = "[" + this.name + "]\nconsume and heal your life by " + this.value;
        this.value=8;

    }
    
    public void use(Entity entity) {

        gp.gameState = gp.dialogueState;
        gp.ui.currentDialogue = "You drank the " + this.name + "!\n" + "Your life has now been restored by " + this.value;

        entity.life += this.value;
        
        if(gp.player.life > gp.player.maxLife) {
            gp.player.life = gp.player.maxLife;
        }

        gp.playSE(2);

    }  
}
