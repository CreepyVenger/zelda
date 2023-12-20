package monster;

import java.util.Random;
import entity.Entity;
//import entity.Player;
import main.GamePanel;
import main.Inventory;
import object.OBJ_Potion_Red;
//import tile.Tile;
//import main.UtilityTool;
import tile.TileManager;

import main.ConsumableItem;
import main.PickableItems;

public class MON_Orc extends Entity{
    
    GamePanel gp;
    //private boolean onWater = false;
    //TileManager tileManager;

    public MON_Orc(GamePanel gp, TileManager tileManager) {
        super(gp);
        this.gp = gp;   

        type = type_monster;
        name = "Orc";
        speed = 0.5;
        maxLife = 20;
        life = maxLife;
        attack = 10;
        defense = 0; //Player's default attack is 1 and if slime's defense is one os slime cannot take any damage
        exp = 10;

        solidArea.x = 3;
        solidArea.y = 18;
        solidArea.width = 30;
        solidArea.height = 30;
        solidAreaDedaultX = solidArea.x;
        solidAreaDedaultY = solidArea.y;

        getImage();

    }
    
    public void getImage() {

        up1 = setupground("/monster/orc_up_1",gp.tileSize, gp.tileSize);
        up2 = setupground("/monster/orc_up_2",gp.tileSize, gp.tileSize);
        down1 = setupground("/monster/orc_down_1",gp.tileSize, gp.tileSize);
        down2 = setupground("/monster/orc_down_2",gp.tileSize, gp.tileSize);
        left1 = setupground("/monster/orc_left_1",gp.tileSize, gp.tileSize);
        left2 = setupground("/monster/orc_left_2",gp.tileSize, gp.tileSize);
        right1 = setupground("/monster/orc_right_1",gp.tileSize, gp.tileSize);
        right2 = setupground("/monster/orc_right_2",gp.tileSize, gp.tileSize);

}
 

    public void setAction() {

    actionLockCounter++;

    //if(TileManager.getTileImage(setup(a, b, false, true)));
    if(actionLockCounter == 120) {

        Random random = new Random();
        int i  = random.nextInt(100)+1; //it will pick up a number from 0 to 100
        
        if(i <= 25) {
            direction = "up";
        }

        if(i > 25 && i <= 50) {
            direction = "down";
        }

        if(i > 50 && i <= 75) {
            direction = "left";
        }

        if(i > 75 && i <= 100) {
            direction = "right";        
        }


        actionLockCounter = 0;
    }

    //;
    
}

public void damageReaction(){

    actionLockCounter = 0;
    direction = gp.player.direction;
}


}
