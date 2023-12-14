package object;

import entity.Entity;
import main.GamePanel;


public class OBJ_Door extends Entity{
    
    private String name;

    public OBJ_Door(GamePanel gp) {

        super(gp);
    
        this.name = "Door";
        down1 = setupground("/objects/door",gp.tileSize, gp.tileSize);
        collision = true;

        solidArea.x = 0;
        solidArea.y = 16;
        solidArea.width = 48;
        solidArea.height = 32;
        solidAreaDedaultX = solidArea.x;
        solidAreaDedaultY = solidArea.y;

        
    }

    public String getname(){
        return this.name;
    }
}
