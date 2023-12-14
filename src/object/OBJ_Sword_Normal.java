package object;

import entity.Entity;
import main.GamePanel;
import main.Inventory;
import main.PickableItems;

public class OBJ_Sword_Normal extends Entity implements PickableItems{

    private String name;

    public OBJ_Sword_Normal(GamePanel gp) {
        
        super(gp);
        //zTODO Auto-generated constructor stub

        type = type_sword;
        this.name = "Normal Sword";
        attackArea.width = 30;
        attackArea.height = 30;
        down1 = setupground("/objects/sword_normal_2", gp.tileSize, gp.tileSize);
        attackValue = 1;
        description = "[" + name + "]\nAnd old Sword.";
    }

    public void pick(Inventory inventory){
        inventory.pickitem(new OBJ_Sword_Normal(gp));
    }
    public void drop(Inventory inventory){
        inventory.dropitem(this.name);
    }
    public String getname(){
        return this.name;
    }
}
