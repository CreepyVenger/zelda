package monster;

import java.util.Random;
import entity.Entity;
//import entity.Player;
import main.GamePanel;
//import tile.Tile;
//import main.UtilityTool;
import tile.TileManager;

public class MON_Bat extends Entity{
    
    GamePanel gp;
    //private boolean onWater = false;
    //TileManager tileManager;

    public MON_Bat(GamePanel gp, TileManager tileManager) {
        super(gp);
        this.gp = gp;   

        type = type_monster;
        name = "Green Slime";
        speed = 3;
        maxLife = 1;
        life = maxLife;
        attack = 1;
        defense = 0; //Player's default attack is 1 and if slime's defense is one os slime cannot take any damage
        exp = 2;

        solidArea.x = 3;
        solidArea.y = 18;
        solidArea.width = 16;
        solidArea.height = 16;
        solidAreaDedaultX = solidArea.x;
        solidAreaDedaultY = solidArea.y;

        getImage();

    }
    
    public void getImage() {

        up1 = setupground("/monster/bat_down_1",gp.tileSize, gp.tileSize);
        up2 = setupground("/monster/bat_down_2",gp.tileSize, gp.tileSize);
        down1 = setupground("/monster/bat_down_1",gp.tileSize, gp.tileSize);
        down2 = setupground("/monster/bat_down_2",gp.tileSize, gp.tileSize);
        left1 = setupground("/monster/bat_down_1",gp.tileSize, gp.tileSize);
        left2 = setupground("/monster/bat_down_2",gp.tileSize, gp.tileSize);
        right1 = setupground("/monster/bat_down_1",gp.tileSize, gp.tileSize);
        right2 = setupground("/monster/bat_down_2",gp.tileSize, gp.tileSize);

}
 

    public void setAction() {

    actionLockCounter++;

    //if(TileManager.getTileImage(setup(a, b, false, true)));
    if(actionLockCounter == 60) {

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
