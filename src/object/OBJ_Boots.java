package object;

import entity.Entity;
import main.GamePanel;
import main.Inventory;
import main.PickableItems;


public class OBJ_Boots extends Entity implements PickableItems{
    
    private String name;

    public OBJ_Boots(GamePanel gp) {

        super(gp);
    
        name = "Boots";
        down1 = setupground("/objects/boots",gp.tileSize, gp.tileSize);
    }
    public void pick(Inventory inventory){
        inventory.pickitem(new OBJ_Boots(gp));
    }
    public void drop(Inventory inventory){
        inventory.dropitem(this.name);
    }
    public String getname(){
        return this.name;
    }
}
