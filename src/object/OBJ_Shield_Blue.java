package object;

import entity.Entity;
import main.PickableItems;
import main.GamePanel;
import main.Inventory;

public class OBJ_Shield_Blue extends Entity implements PickableItems{

    private String name;

    public OBJ_Shield_Blue(GamePanel gp) {
        
        super(gp);

        type = type_shield;
        this.name = "Blue Shield";
        down1 = setupground("/objects/shield_iron", gp.tileSize, gp.tileSize);
        defenseValue = 1;
        description = "[" + name + "]\nShiny blue blue shield.";
    }

    public void pick(Inventory inventory){
        inventory.pickitem(new OBJ_Shield_Blue(gp));
    }
    public void drop(Inventory inventory){
        inventory.dropitem(this.name);
    }
    public String getname(){
        return this.name;
    }
}