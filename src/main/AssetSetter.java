package main;

import entity.NPC_Duck;
import entity.NPC_Frog;
import entity.NPC_OldMan;
import monster.MON_GreenSlime;
import monster.MON_Orc;
import monster.MON_Bat;
import monster.MON_RedSlime;
import object.OBJ_Axe;
//import object.OBJ_Boots;
import object.OBJ_Chest;
import object.OBJ_Door;
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
        gp.obj[i].worldX = 23 * gp.tileSize;
        gp.obj[i].worldY = 7 * gp.tileSize;
        i++;

        gp.obj[i] = new OBJ_Key(gp);
        gp.obj[i].worldX = 23 * gp.tileSize;
        gp.obj[i].worldY = 40 * gp.tileSize;
        i++;

        gp.obj[i] = new OBJ_Key(gp);
        gp.obj[i].worldX = 38 * gp.tileSize;
        gp.obj[i].worldY = 8 * gp.tileSize;
        i++;

        gp.obj[i] = new OBJ_Axe(gp);
        gp.obj[i].worldX = 33 * gp.tileSize;
        gp.obj[i].worldY = 21 * gp.tileSize;
        i++;

        gp.obj[i] = new OBJ_Shield_Blue(gp);
        gp.obj[i].worldX = 35 * gp.tileSize;
        gp.obj[i].worldY = 21 * gp.tileSize;
        i++;

        gp.obj[i] = new OBJ_Potion_Red(gp);
        gp.obj[i].worldX = 23 * gp.tileSize;
        gp.obj[i].worldY = 27 * gp.tileSize;
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
        gp.obj[i] = new OBJ_Door(gp);
        gp.obj[i].worldX = 10 * gp.tileSize;
        gp.obj[i].worldY = 12 * gp.tileSize;
        i++;

        gp.obj[i] = new OBJ_Door(gp);
        gp.obj[i].worldX = 8 * gp.tileSize;
        gp.obj[i].worldY = 28 * gp.tileSize;
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
        gp.npc[5] = new NPC_OldMan(gp);
        gp.npc[5].worldX = gp.tileSize*9; //24
        gp.npc[5].worldY = gp.tileSize*10; //21
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

        gp.monster[i] = new MON_RedSlime(gp, null);
        gp.monster[i].worldX = gp.tileSize*40;
        gp.monster[i].worldY = gp.tileSize*42;
        i++;
        
        gp.monster[i] = new MON_Orc(gp, null);
        gp.monster[i].worldX = gp.tileSize*10;
        gp.monster[i].worldY = gp.tileSize*34;
        i++;

        gp.monster[i] = new MON_Orc(gp, null);
        gp.monster[i].worldX = gp.tileSize*8;
        gp.monster[i].worldY = gp.tileSize*34;
        i++;

        gp.monster[i] = new MON_Orc(gp, null);
        gp.monster[i].worldX = gp.tileSize*6;
        gp.monster[i].worldY = gp.tileSize*34;
        i++;

        gp.monster[i] = new MON_Orc(gp, null);
        gp.monster[i].worldX = gp.tileSize*4;
        gp.monster[i].worldY = gp.tileSize*34;
        i++;

        gp.monster[i] = new MON_Bat(gp, null);
        gp.monster[i].worldX = gp.tileSize*12;
        gp.monster[i].worldY = gp.tileSize*34;
        i++;

        gp.monster[i] = new MON_Bat(gp, null);
        gp.monster[i].worldX = gp.tileSize*14;
        gp.monster[i].worldY = gp.tileSize*34;
        i++;

        gp.monster[i] = new MON_Bat(gp, null);
        gp.monster[i].worldX = gp.tileSize*16;
        gp.monster[i].worldY = gp.tileSize*34;
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
