package object;


import entity.Entity;
import main.DefenseItem;
import main.GamePanel;
import main.Inventory;
import main.PickableItems;

public class OBJ_Shield_Wood extends Entity implements PickableItems,DefenseItem{

    private String name;

    public OBJ_Shield_Wood(GamePanel gp) {
        
        super(gp);

        type = type_shield;
        this.name = "Wooden Shield";
        down1 = setupground("/objects/shield_wood_2", gp.tileSize, gp.tileSize);
        defenseValue = 1;
        description = "[" + name + "]\nMade of wood.";
    }

    public void pick(Inventory inventory){
        inventory.pickitem(new OBJ_Shield_Wood(gp));
    }
    public void drop(Inventory inventory){
        inventory.dropitem(this.name);
    }
    public String getname(){return this.name;}
    public String getdescription(){return this.description;}
    public void blocking(Entity caster,Entity target){}
}