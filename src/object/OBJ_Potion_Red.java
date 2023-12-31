package object;

import entity.Entity;
import main.ConsumableItem;
import main.GamePanel;
import main.Inventory;
import main.PickableItems;

public class OBJ_Potion_Red extends Entity implements PickableItems,ConsumableItem{

    private String name;
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
        gp.ui.currentDialogue = "You drank the " + this.name + "!\n" + "Your life has now been restored by " + this.value;

        entity.life += this.value;
        
        if(gp.player.life > gp.player.maxLife) {
            gp.player.life = gp.player.maxLife;
        }

        gp.playSE(2);

    }   
    public void pick(Inventory inventory){inventory.pickitem(this);}
    public void drop(Inventory inventory){inventory.dropitem(this.name);}
    public String getname(){return this.name;}
    public String getdescription(){return this.description;}
    public void consumeItem(Entity item){}
}