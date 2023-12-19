package object;

import entity.Entity;
import main.AttackItem;
import main.GamePanel;
import main.Inventory;
import main.PickableItems;

public class OBJ_Axe extends Entity implements PickableItems,AttackItem{

    private String name;

    public OBJ_Axe(GamePanel gp) {
        super(gp);
        
        type = type_axe;
        this.name = "Lumberjack's wooden axe";
        down1 = setupground("/objects/iron_axe_2", gp.tileSize, gp.tileSize);
        attackValue = 2;
        attackArea.width = 30;
        attackArea.height = 30;
        //description = "[Lumberjack's wooden axe]\nbit rusty but still \ncan cut some trees...";
        description = "[" + name + "]\nA bit rusty but still can cut \nsome trees..."; 
    }

    public void pick(Inventory inventory){
        inventory.pickitem(new OBJ_Axe(gp));
    }
    public void drop(Inventory inventory){
        inventory.dropitem(this.name);
    }
    public String getname(){return this.name;}
    public String getdescription(){return this.description;}
    public void attacking(Entity caster,Entity target){
        
    }
}