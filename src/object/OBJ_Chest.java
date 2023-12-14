package object;

import entity.Entity;
import main.GamePanel;
import main.Inventory;


public class OBJ_Chest extends Entity{
    
    private String name;
    private Inventory chestinventory=new Inventory(40);

    public OBJ_Chest(GamePanel gp) {

        super(gp);
    
        this.name = "Chest";
        down1 = setupground("/objects/chest",gp.tileSize, gp.tileSize);

        collision = true;
    }
    public String getname(){
        return this.name;
    }
}
