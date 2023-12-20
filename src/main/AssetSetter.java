package main;

import entity.NPC_Duck;
import entity.NPC_Frog;
import entity.NPC_OldMan_1;
import entity.NPC_OldMan_2;
import monster.MON_GreenSlime;
import monster.MON_Orc;
import monster.MON_Bat;
import monster.MON_RedSlime;
import object.OBJ_Axe;
//import object.OBJ_Boots;
import object.OBJ_Chest;
import object.OBJ_Door;
import object.OBJ_Door_Not_Spawnable;
import object.OBJ_Key;
import object.OBJ_Potion_Red;
import object.OBJ_Shield_Blue;

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

        int i = 0;
        /* gp.obj[0] = new OBJ_Door(gp);
        gp.obj[0].worldX = gp.tileSize*21;
        gp.obj[0].worldY = gp.tileSize*22;

        gp.obj[1] = new OBJ_Door(gp);
        gp.obj[1].worldX = gp.tileSize*23;
        gp.obj[1].worldY = gp.tileSize*25; */

        gp.obj[i] = new OBJ_Key(gp);
        gp.obj[i].worldX = 31 * gp.tileSize;
        gp.obj[i].worldY = 29 * gp.tileSize;
        i++;

        gp.obj[i] = new OBJ_Potion_Red(gp);
        gp.obj[i].worldX = 28 * gp.tileSize;
        gp.obj[i].worldY = 30 * gp.tileSize;
        i++;

        //////////////////////  s

        gp.obj[i] = new OBJ_Key(gp);
        gp.obj[i].worldX = 19 * gp.tileSize;
        gp.obj[i].worldY = 17 * gp.tileSize;
        i++;

        gp.obj[i] = new OBJ_Key(gp);
        gp.obj[i].worldX = 18 * gp.tileSize;
        gp.obj[i].worldY = 14 * gp.tileSize;
        i++;
        
        gp.obj[i] = new OBJ_Key(gp);
        gp.obj[i].worldX = 15 * gp.tileSize;
        gp.obj[i].worldY = 11 * gp.tileSize;
        i++;

        //////////////////////

        gp.obj[i] = new OBJ_Axe(gp);
        gp.obj[i].worldX = 12 * gp.tileSize;
        gp.obj[i].worldY = 32 * gp.tileSize;
        i++;

        gp.obj[i] = new OBJ_Shield_Blue(gp);
        gp.obj[i].worldX = 10 * gp.tileSize;
        gp.obj[i].worldY = 33 * gp.tileSize;
        i++;




        


        /* gp.obj[i] = new OBJ_Key(gp);
        gp.obj[i].worldX = 25 * gp.tileSize;
        gp.obj[i].worldY = 23 * gp.tileSize;
        i++;
        gp.obj[i] = new OBJ_Key(gp);
        gp.obj[i].worldX = 21 * gp.tileSize;
        gp.obj[i].worldY = 19 * gp.tileSize;
        i++;
        gp.obj[i] = new OBJ_Key(gp);
        gp.obj[i].worldX = 26 * gp.tileSize;
        gp.obj[i].worldY = 21 * gp.tileSize;
        i++; */



        //TOWER DOOR
        gp.obj[i] = new OBJ_Door_Not_Spawnable(gp);
        gp.obj[i].worldX = 10 * gp.tileSize;
        gp.obj[i].worldY = 12 * gp.tileSize;
        i++;

        gp.obj[i] = new OBJ_Door(gp);
        gp.obj[i].worldX = 12 * gp.tileSize;
        gp.obj[i].worldY = 23 * gp.tileSize;
        i++;

        gp.obj[i] = new OBJ_Chest(gp);
        gp.obj[i].worldX = 10 * gp.tileSize;
        gp.obj[i].worldY = 8 * gp.tileSize;
        i++;

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

        int i = 0;
        /*gp.npc[i] = new NPC_OldMan_1(gp);
        gp.npc[i].worldX = gp.tileSize*22;
        gp.npc[i].worldY = gp.tileSize*21;
        i++;
        //////////////////////

        gp.npc[i] = new NPC_OldMan_2(gp);
        gp.npc[i].worldX = gp.tileSize*10;
        gp.npc[i].worldY = gp.tileSize*30;
        i++;

        gp.npc[i] = new NPC_Duck(gp);
        gp.npc[i].worldX = gp.tileSize*21; //22
        gp.npc[i].worldY = gp.tileSize*21; //22
        i++;*/

        /*gp.npc[i] = new NPC_Duck(gp);
        gp.npc[i].worldX = gp.tileSize*41; //22
        gp.npc[i].worldY = gp.tileSize*21; //22
        i++;
    


        gp.npc[i] = new NPC_Frog(gp);
        gp.npc[i].worldX = gp.tileSize*22; //24
        gp.npc[i].worldY = gp.tileSize*11; //21
        i++;

        gp.npc[i] = new NPC_Frog(gp);
        gp.npc[i].worldX = gp.tileSize*22; //24
        gp.npc[i].worldY = gp.tileSize*31; //21 
        i++;*/

        //OLD MAN IN THE TOWER
        gp.npc[i] = new NPC_OldMan_1(gp);
        gp.npc[i].worldX = gp.tileSize*9; //24
        gp.npc[i].worldY = gp.tileSize*10; //21
        
    }

    public void setMonster() {

        int i = 0;
        gp.monster[i] = new MON_GreenSlime(gp, null);
        gp.monster[i].worldX = gp.tileSize*20;
        gp.monster[i].worldY = gp.tileSize*36;
        i++;

        gp.monster[i] = new MON_GreenSlime(gp, null);
        gp.monster[i].worldX = gp.tileSize*23;
        gp.monster[i].worldY = gp.tileSize*39;
        i++;

        gp.monster[i] = new MON_GreenSlime(gp, null);
        gp.monster[i].worldX = gp.tileSize*24;
        gp.monster[i].worldY = gp.tileSize*37;
        i++;

        gp.monster[i] = new MON_GreenSlime(gp, null);
        gp.monster[i].worldX = gp.tileSize*38;
        gp.monster[i].worldY = gp.tileSize*42;
        i++;

        gp.monster[i] = new MON_Orc(gp, null);
        gp.monster[i].worldX = gp.tileSize*38;
        gp.monster[i].worldY = gp.tileSize*8;
        i++;

        gp.monster[i] = new MON_Orc(gp, null);
        gp.monster[i].worldX = gp.tileSize*36;
        gp.monster[i].worldY = gp.tileSize*30;
        i++;

        gp.monster[i] = new MON_Bat(gp, null);
        gp.monster[i].worldX = gp.tileSize*10;
        gp.monster[i].worldY = gp.tileSize*13;
        i++;

        gp.monster[i] = new MON_Bat(gp, null);
        gp.monster[i].worldX = gp.tileSize*12;
        gp.monster[i].worldY = gp.tileSize*16;
        i++;


        /* //Green Slime in the tower to test collision 
        gp.monster[2] = new MON_GreenSlime(gp);
        gp.monster[2].worldX = gp.tileSize*11;
        gp.monster[2].worldY = gp.tileSize*10;

        gp.monster[3] = new MON_GreenSlime(gp);
        gp.monster[3].worldX = gp.tileSize*11;
        gp.monster[3].worldY = gp.tileSize*11; */ 
    }

}
