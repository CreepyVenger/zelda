package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Sword_Normal extends Entity {

    public OBJ_Sword_Normal(GamePanel gp) {
        
        super(gp);
        //zTODO Auto-generated constructor stub
        name = "Normal Sword";
        down1 = setupground("/objects/sword_normal", gp.tileSize, gp.tileSize);
        attackValue = 1;
        description = "[" + name + "]\nAnd old Sword.";
    }

   
}
