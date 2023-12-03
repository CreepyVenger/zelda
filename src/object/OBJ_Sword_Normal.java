package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Sword_Normal extends Entity {

    public OBJ_Sword_Normal(GamePanel gp) {
        
        super(gp);
        //zTODO Auto-generated constructor stub

        type = type_sword;
        name = "Normal Sword";
        attackArea.width = 30;
        attackArea.height = 30;
        down1 = setupground("/objects/sword_normal_2", gp.tileSize, gp.tileSize);
        attackValue = 1;
        description = "[" + name + "]\nAnd old Sword.";
    }

   
}
