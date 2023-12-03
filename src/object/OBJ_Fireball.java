package object;

import entity.Projectile;
import main.GamePanel;

public class OBJ_Fireball extends Projectile{

    GamePanel gp;       

    public OBJ_Fireball(GamePanel gp) {
        //zTODO Auto-generated constructor stub

        super(gp);
        this.gp = gp;

        name = "Fireball";
        speed = 5;
        maxLife = 30;
        life = maxLife;
        attack = 2;
        useCost = 1;
        alive = false;
        getImage();

    }

    public void getImage() {

        up1 = setupground("/Projectile/fireball_up_1",gp.tileSize, gp.tileSize);
        up2 = setupground("/Projectile/fireball_up_2",gp.tileSize, gp.tileSize);
        down1 = setupground("/Projectile/fireball_down_1",gp.tileSize, gp.tileSize);
        down2 = setupground("/Projectile/fireball_down_2",gp.tileSize, gp.tileSize);
        left1 = setupground("/Projectile/fireball_left_1",gp.tileSize, gp.tileSize);
        left2 = setupground("/Projectile/fireball_left_2",gp.tileSize, gp.tileSize);
        right1 = setupground("/Projectile/fireball_right_1",gp.tileSize, gp.tileSize);
        right2 = setupground("/Projectile/fireball_right_2",gp.tileSize, gp.tileSize);

    }

    
}
