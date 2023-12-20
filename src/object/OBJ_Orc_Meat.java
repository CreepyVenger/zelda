package object;

import entity.Entity;
import main.GamePanel;
import main.Inventory;

public class OBJ_Orc_Meat extends OBJ_Potion_Red{

    private String name;
    int value=8;

    public OBJ_Orc_Meat(GamePanel gp){
        super(gp);

        this.name="OBJ_Orc_Meat";
        down1 = setupground("/objects/lantern", gp.tileSize, gp.tileSize);
        description = "[" + name + "]\nconsume and heal your life by " + value;

    }

    public void use(Entity entity) {

        gp.gameState = gp.dialogueState;
        gp.ui.currentDialogue = "You ate the " + name + "!\n" + "Your life has now been restored by " + value;

        entity.life += value;
        
        if(gp.player.life > gp.player.maxLife) {
            gp.player.life = gp.player.maxLife;
        }

        gp.playSE(2);

    } 

    public void pick(Inventory inventory){
        inventory.pickitem(new OBJ_Orc_Meat(gp));
    }
}
