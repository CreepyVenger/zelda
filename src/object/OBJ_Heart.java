package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Heart extends Entity{

    public OBJ_Heart(GamePanel gp) {

        super(gp);

        name = "Heart";
        image = setupground("/objects/heart_full",gp.tileSize, gp.tileSize);
        image2 = setupground("/objects/heart_half",gp.tileSize, gp.tileSize);
        image3 = setupground("/objects/heart_blank",gp.tileSize, gp.tileSize);

        //collision = true;
    }
    
    public String getname(){return this.name;}
    public String getdescription(){return this.description;}
}



