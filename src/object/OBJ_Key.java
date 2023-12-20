package object;

import entity.Entity;
import main.GamePanel;
import main.Inventory;
import main.PickableItems;


public class OBJ_Key extends Entity implements PickableItems{
    
    private String name;

    public OBJ_Key(GamePanel gp) {

        super(gp);
        //zTODO Auto-generated constructor stub
        this.name = "Key";
        down1 = setupground("/objects/key",gp.tileSize, gp.tileSize);
        description = "[" + name + "]\nIt opens a door...";
    }

    public void pick(Inventory inventory){inventory.pickitem(this);}
    public void drop(Inventory inventory){inventory.dropitem(this.name);}
    public String getname(){return this.name;}
    public String getdescription(){return this.description;}
}
