package object;

import entity.Entity;
import main.PickableItems;
import main.DefenseItem;
import main.GamePanel;
import main.Inventory;

public class OBJ_Shield_Blue extends Entity implements PickableItems,DefenseItem{

    private String name;
    private Integer InvinciBlockTime;

    public OBJ_Shield_Blue(GamePanel gp) {
        
        super(gp);

        type = type_shield;
        this.name = "Blue Shield";
        down1 = setupground("/objects/shield_iron", gp.tileSize, gp.tileSize);
        defenseValue = 1;
        description = "[" + name + "]\nShiny blue blue shield.";
        this.InvinciBlockTime=15;
    }

    public void pick(Inventory inventory){
        inventory.pickitem(new OBJ_Shield_Blue(gp));
    }
    public void drop(Inventory inventory){
        inventory.dropitem(this.name);
    }
    public String getname(){return this.name;}
    public String getdescription(){return this.description;}
    public void blocking(Entity caster,Entity target){
        if (target.getblocked()==true && target.collisionOn==true){
            for (int i=0;i<this.InvinciBlockTime;i++){
                target.invincible=true;
            }
            target.invincible=false;
        }
    }
}