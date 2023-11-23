package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Shield_Wood extends Entity {

    public OBJ_Shield_Wood(GamePanel gp) {
        
        super(gp);
        name = "Wooden Shield";
        down1 = setupground("/objects/shield_wood", gp.tileSize, gp.tileSize);
        defenseValue = 999999;
        description = "[" + name + "]\nMade of wood.";
    }

   
}