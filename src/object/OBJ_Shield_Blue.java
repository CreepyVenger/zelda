package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Shield_Blue extends Entity {

    public OBJ_Shield_Blue(GamePanel gp) {
        
        super(gp);

        type = type_shield;
        name = "Blue Shield";
        down1 = setupground("/objects/shield_iron", gp.tileSize, gp.tileSize);
        defenseValue = 1;
        description = "[" + name + "]\nShiny blue blue shield.";
    }

   
}