package object;

import entity.Entity;
import main.GamePanel;
import main.Inventory;
import main.PickableItems;

public class OBJ_Potion_Red extends Entity implements PickableItems{

    private String name;
    GamePanel gp;
    int value = 5;

    public OBJ_Potion_Red(GamePanel gp) {
        
        super(gp);

        this.gp = gp;

        type = type_consumable;
        this.name = "Red potion";
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
    public void pick(Inventory inventory){
        inventory.pickitem(new OBJ_Potion_Red(gp));
    }
    public void drop(Inventory inventory){
        inventory.dropitem(this.name);
    }
    public String getname(){
        return this.name;
    }
}