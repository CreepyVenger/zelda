package main;

import entity.NPC_Duck;
import entity.NPC_Frog;
import entity.NPC_OldMan;
import monster.MON_GreenSlime;
//import object.OBJ_Boots;
import object.OBJ_Chest;
import object.OBJ_Door;
import object.OBJ_Key;

/* import object.OBJ_speedBoots;
import object.OBJ_slowBoots;
import object.OBJ_Chest;
import object.OBJ_Key;
import object.OBJ_Door; */


public class AssetSetter {
    
    GamePanel gp;

    public AssetSetter(GamePanel gp) {
        this.gp = gp;
    }

    public void setObject() {

        /* gp.obj[0] = new OBJ_Door(gp);
        gp.obj[0].worldX = gp.tileSize*21;
        gp.obj[0].worldY = gp.tileSize*22;

        gp.obj[1] = new OBJ_Door(gp);
        gp.obj[1].worldX = gp.tileSize*23;
        gp.obj[1].worldY = gp.tileSize*25; */

        gp.obj[2] = new OBJ_Key(gp);
        gp.obj[2].worldX = 23 * gp.tileSize;
        gp.obj[2].worldY = 7 * gp.tileSize;

        gp.obj[3] = new OBJ_Key(gp);
        gp.obj[3].worldX = 23 * gp.tileSize;
        gp.obj[3].worldY = 40 * gp.tileSize;

        gp.obj[4] = new OBJ_Key(gp);
        gp.obj[4].worldX = 38 * gp.tileSize;
        gp.obj[4].worldY = 8 * gp.tileSize;

        //TOWER DOOR
        gp.obj[5] = new OBJ_Door(gp);
        gp.obj[5].worldX = 10 * gp.tileSize;
        gp.obj[5].worldY = 12 * gp.tileSize;

        gp.obj[6] = new OBJ_Door(gp);
        gp.obj[6].worldX = 8 * gp.tileSize;
        gp.obj[6].worldY = 28 * gp.tileSize;
        
        gp.obj[7] = new OBJ_Door(gp);
        gp.obj[7].worldX = 12 * gp.tileSize;
        gp.obj[7].worldY = 23 * gp.tileSize;

        gp.obj[8] = new OBJ_Chest(gp);
        gp.obj[8].worldX = 10 * gp.tileSize;
        gp.obj[8].worldY = 8 * gp.tileSize;

        /* gp.obj[7] = new OBJ_Boots(gp);
        gp.obj[7].worldX = 37 * gp.tileSize;
        gp.obj[7].worldY = 42 * gp.tileSize; */

        /*gp.obj[7] = new OBJ_speedBoots(gp);
        gp.obj[7].worldX = 37 * gp.tileSize;
        gp.obj[7].worldY = 42 * gp.tileSize;

        gp.obj[8] = new OBJ_slowBoots(gp);
        gp.obj[8].worldX = 37 * gp.tileSize;
        gp.obj[8].worldY = 40 * gp.tileSize; */

    }

    public void setNPC() {

        gp.npc[0] = new NPC_OldMan(gp);
        gp.npc[0].worldX = gp.tileSize*21;
        gp.npc[0].worldY = gp.tileSize*21;



        gp.npc[1] = new NPC_Duck(gp);
        gp.npc[1].worldX = gp.tileSize*11; //22
        gp.npc[1].worldY = gp.tileSize*21; //22

        gp.npc[2] = new NPC_Duck(gp);
        gp.npc[2].worldX = gp.tileSize*31; //22
        gp.npc[2].worldY = gp.tileSize*21; //22



        gp.npc[3] = new NPC_Frog(gp);
        gp.npc[3].worldX = gp.tileSize*22; //24
        gp.npc[3].worldY = gp.tileSize*11; //21

        gp.npc[4] = new NPC_Frog(gp);
        gp.npc[4].worldX = gp.tileSize*22; //24
        gp.npc[4].worldY = gp.tileSize*31; //21

        //OLD MAN IN THE TOWER
        /* gp.npc[5] = new NPC_OldMan(gp);
        gp.npc[5].worldX = gp.tileSize*9; //24
        gp.npc[5].worldY = gp.tileSize*10; //21 */
    }

    public void setMonster() {

        gp.monster[0] = new MON_GreenSlime(gp, null);
        gp.monster[0].worldX = gp.tileSize*20;
        gp.monster[0].worldY = gp.tileSize*36;

        gp.monster[1] = new MON_GreenSlime(gp, null);
        gp.monster[1].worldX = gp.tileSize*23;
        gp.monster[1].worldY = gp.tileSize*39;

        //Green Slime in the tower to test collision 
        /* gp.monster[2] = new MON_GreenSlime(gp);
        gp.monster[2].worldX = gp.tileSize*11;
        gp.monster[2].worldY = gp.tileSize*10;

        gp.monster[3] = new MON_GreenSlime(gp);
        gp.monster[3].worldX = gp.tileSize*11;
        gp.monster[3].worldY = gp.tileSize*11; */
    }
}
