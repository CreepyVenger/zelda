package main;

import entity.Entity;
//import main.GamePanel;

public class CollisionChecker {
    
    GamePanel gp;

    public CollisionChecker(GamePanel gp) {
        this.gp = gp;
    }

    
    public void checkTile(Entity entity) {

        int entityLeftWorldX = (int) (entity.worldX + entity.solidArea.x);
        int entityRightWorldX = (int) (entity.worldX + entity.solidArea.x + entity.solidArea.width);
        int entityTopWorldY = (int) (entity.worldY + entity.solidArea.y);
        int entityBottomWorldY = (int) (entity.worldY + entity.solidArea.y + entity.solidArea.height);


        int entityLeftCol = entityLeftWorldX/gp.tileSize;
        int entityRightCol = entityRightWorldX/gp.tileSize;
        int entityTopRow = entityTopWorldY/gp.tileSize;
        int entityBottomRow = entityBottomWorldY/gp.tileSize;

        int tileNum1, tileNum2;

        switch(entity.direction) {
        case "up":
            entityTopRow = (int)(entityTopWorldY - entity.speedGround) / gp.tileSize;
            tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
            tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
            if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true) {
                entity.collisionOn = true;  
            }
            break;

        case "down":
            entityBottomRow = (int)(entityBottomWorldY + entity.speedGround) / gp.tileSize;
            tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
            tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
            if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true) {
                entity.collisionOn = true;  
            }

            

            break;

        case "left":
            entityLeftCol = (int)(entityLeftWorldX - entity.speedGround) / gp.tileSize;
            tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
            tileNum2 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
            if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true) {
                entity.collisionOn = true;  
            }
            break;

        case "right":
            entityRightCol = (int)(entityRightWorldX + entity.speedGround) / gp.tileSize;
            tileNum1 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
            tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
            if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true) {
                entity.collisionOn = true;  
            }
            break;
        }
    }

    public int CheckObject(Entity entity, boolean player) {

        int index = 999;

        for(int i =0; i < gp.obj.length; i++) {
            
            if(gp.obj[i] != null) {
                //Get entity's solid area position. 
                entity.solidArea.x = (int) entity.worldX + entity.solidArea.x;
                entity.solidArea.y = (int) entity.worldY + entity.solidArea.y;
                //Get the object solid area position.
                gp.obj[i].solidArea.x = (int) (gp.obj[i].worldX + gp.obj[i].solidArea.x);
                gp.obj[i].solidArea.y = (int) gp.obj[i].worldY + gp.obj[i].solidArea.y;

                switch(entity.direction) {
                case "up": entity.solidArea.y -= entity.speedGround; break;
                case "down":entity.solidArea.y += entity.speedGround; break;
                case "left": entity.solidArea.x -= entity.speedGround; break;      
                case "right": entity.solidArea.x += entity.speedGround; break; 
                }

                if(entity.solidArea.intersects(gp.obj[i].solidArea)) {
                    if(gp.obj[i].collision == true) {
                        entity.collisionOn = true;
                    }
                    if(player == true) {
                        index = i;
                    }
                }

                entity.solidArea.x = entity.solidAreaDedaultX;
                entity.solidArea.y = entity.solidAreaDedaultY;
                gp.obj[i].solidArea.x = gp.obj[i].solidAreaDedaultX;
                gp.obj[i].solidArea.y = gp.obj[i].solidAreaDedaultY;
            }
        }
        return index;
    }

    //NPC or MONSTERS
    public int checkEntity(Entity entity, Entity[] target) {
        
        int index = 999;

        for(int i =0; i < target.length; i++) {
            
            if(target[i] != null) {

                //Get entity's solid area position. 
                entity.solidArea.x = (int) entity.worldX + entity.solidArea.x;
                entity.solidArea.y = (int) entity.worldY + entity.solidArea.y;
                //Get the object solid area position.
                target[i].solidArea.x = (int) target[i].worldX + target[i].solidArea.x;
                target[i].solidArea.y = (int) target[i].worldY + target[i].solidArea.y;

                switch(entity.direction) {
                case "up": entity.solidArea.y -= entity.speedGround; break;
                case "down": entity.solidArea.y += entity.speedGround; break;
                case "left": entity.solidArea.x -= entity.speedGround; break;                   
                case "right": entity.solidArea.x += entity.speedGround; break;    
                }
                //break; is here ? 

                if(entity.solidArea.intersects(target[i].solidArea)) {
                    if(target[i] != entity) {
                        entity.collisionOn = true;
                        index = i;
                    }
                    
                }
                entity.solidArea.x = entity.solidAreaDedaultX;
                entity.solidArea.y = entity.solidAreaDedaultY;
                target[i].solidArea.x = target[i].solidAreaDedaultX;
                target[i].solidArea.y = target[i].solidAreaDedaultY;
            }
        }
        return index;
    }

    public boolean checkPlayer(Entity entity) {

        boolean contactPlayer = false;

        //Get entity's solid area position. 
        entity.solidArea.x = (int) entity.worldX + entity.solidArea.x;
        entity.solidArea.y = (int) entity.worldY + entity.solidArea.y;
        //Get the object solid area position.
        gp.player.solidArea.x = (int) gp.player.worldX + gp.player.solidArea.x;
        gp.player.solidArea.y = (int) gp.player.worldY + gp.player.solidArea.y;

        switch(entity.direction) {
        case "up": entity.solidArea.y -= entity.speedGround; break;
        case "down": entity.solidArea.y += entity.speedGround; break;
        case "left": entity.solidArea.x -= entity.speedGround; break;           
        case "right": entity.solidArea.x += entity.speedGround; break; 
        }

        if(entity.solidArea.intersects(gp.player.solidArea)) {
                entity.collisionOn = true;    
                contactPlayer = true;                
        }

        entity.solidArea.x = entity.solidAreaDedaultX;
        entity.solidArea.y = entity.solidAreaDedaultY;
        gp.player.solidArea.x = gp.player.solidAreaDedaultX;
        gp.player.solidArea.y = gp.player.solidAreaDedaultY;

        return contactPlayer;
    }

}
