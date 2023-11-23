package object;

import entity.Entity;
import main.GamePanel;


public class OBJ_Key extends Entity{
    
    public OBJ_Key(GamePanel gp) {

        super(gp);
        //zTODO Auto-generated constructor stub
        name = "Key";
        down1 = setupground("/objects/key",gp.tileSize, gp.tileSize);
        description = "[" + name + "]\nIt opens a door...";
    }
}
