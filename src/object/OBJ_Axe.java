package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Axe extends Entity {

    public OBJ_Axe(GamePanel gp) {
        super(gp);
        //zTODO Auto-generated constructor stub

        type = type_axe;
        name = "Lumberjack's wooden axe";
        down1 = setupground("/objects/iron_axe_2", gp.tileSize, gp.tileSize);
        attackValue = 2;
        attackArea.width = 30;
        attackArea.height = 30;
        //description = "[Lumberjack's wooden axe]\nbit rusty but still \ncan cut some trees...";
        description = "[" + name + "]\nA bit rusty but still can cut \nsome trees..."; 
    }


}