package object;

import entity.Entity;
import main.AttackItem;
import main.GamePanel;
import main.Inventory;
import main.PickableItems;

public class OBJ_Sword_Normal extends Entity implements PickableItems,AttackItem{

    private String name;

    public OBJ_Sword_Normal(GamePanel gp) {
        
        super(gp);
        //zTODO Auto-generated constructor stub

        type = type_sword;
        this.name = "Normal Sword";
        attackArea.width = 30;
        attackArea.height = 40;
        down1 = setupground("/objects/sword_normal_2", gp.tileSize, gp.tileSize);
        attackValue = 1;
        description = "[" + name + "]\nAnd old Sword.";
    }

    public void pick(Inventory inventory){inventory.pickitem(this);}
    public void drop(Inventory inventory){inventory.dropitem(this.name);}
    public String getname(){return this.name;}
    public String getdescription(){return this.description;}
    public void attacking(Entity caster,Entity victim){}
}
