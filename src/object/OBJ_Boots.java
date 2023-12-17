package object;

import entity.Entity;
import main.GamePanel;
import main.Inventory;
import main.PickableItems;


public class OBJ_Boots extends Entity implements PickableItems{
    
    private String name;
    public OBJ_Boots(GamePanel gp) {

        super(gp);
    
        this.name = "Boots";
        down1 = setupground("/objects/boots",gp.tileSize, gp.tileSize);
        description="[" + name + "]Not the best boots in the world\nBut you would not trade them for any others...";
    }
    public void pick(Inventory inventory){
        inventory.pickitem(new OBJ_Boots(gp));
    }
    public void drop(Inventory inventory){
        inventory.dropitem(this.name);
    }
    public String getname(){return this.name;}
    public String getdescription(){return this.description;}
}
