package main;

// import java.awt.Rectangle;

public class EventHandler {
    
    GamePanel gp;
    //Rectangle eventRect; DONE BEFORE, NOW NEW METHOD
    //int eventRectDefautlX, eventRectDefautlY; DONE BEFORE, NOW NEW METHOD

    EventRect eventRect [][];

    int previousEventX, previousEventY;
    boolean canTouchEvent = true;

    
    public EventHandler(GamePanel gp) {

        this.gp = gp;

        eventRect = new EventRect[gp.maxWorldCol][gp.maxWorldRow]; //Now, we have an event rectangle on every single tile of the map

        int col = 0;
        int row = 0;
        while(col < gp.maxWorldCol && row < gp.maxWorldRow) {

        eventRect[col][row] = new EventRect();
        eventRect[col][row].x = 23;
        eventRect[col][row].y = 23;
        eventRect[col][row].width = 2;
        eventRect[col][row].height = 2;
        eventRect[col][row].eventRectDefautlX = eventRect[col][row].x;
        eventRect[col][row].eventRectDefautlY = eventRect[col][row].y; //Middle of the tile

        col++;
        if(col == gp.maxWorldCol) {
            col = 0;
            row++;
              
        }

        }

        
    }

    public void checkEvent() {

        //Check if the player character is more tha 1 tile away from the last event 
        int xDistance = (int) Math.abs(gp.player.worldX - previousEventX);
        int yDistance = (int) Math.abs(gp.player.worldY - previousEventY);
        int distance = Math.max(xDistance, yDistance);
            
        if(distance > gp.tileSize) {
            canTouchEvent = true;
        }

        if(canTouchEvent == true) {

            //if(hit(27,16,"right") == true) {/*Event Happens*/damagePit(27, 16, gp.dialogueState);}

            //if(hit(23,19,"any") == true) {/*Event Happens*/damagePit(27, 16, gp.dialogueState);}
            if(hit(27,16,"right") == true) {/*Event Happens*/teleport(27,16,gp.dialogueState); damagePit(27, 16, gp.dialogueState);}

            if(hit(21,12,"up") == true) {/*Event Happens*/healingPool(21,12, gp.dialogueState);}
            if(hit(23,11,"up") == true) {/*Event Happens*/healingPool(23, 11, gp.dialogueState);}
            if(hit(22,10,"up") == true) {/*Event Happens*/healingPool(22, 10, gp.dialogueState);}


            //canTouchEvent = false;
        }

        


    }

    public boolean hit(int col, int row, String reqDirection) {

        boolean hit = false;

        gp.player.solidArea.x = (int) (gp.player.worldX + gp.player.solidArea.x);
        gp.player.solidArea.y = (int) (gp.player.worldY + gp.player.solidArea.y);

        eventRect[col][row].x = col*gp.tileSize + eventRect[col][row].x;
        eventRect[col][row].y = row*gp.tileSize + eventRect[col][row].y;

        if(gp.player.solidArea.intersects(eventRect[col][row]) && eventRect[col][row].eventDone == false) {
            if(gp.player.direction.contentEquals(reqDirection) || reqDirection.contentEquals("any")) {
                hit = true;

                previousEventX = (int) gp.player.worldX;
                previousEventY = (int) gp.player.worldY;
            }
        }

        gp.player.solidArea.x =  gp.player.solidAreaDedaultX;
        gp.player.solidArea.y =  gp.player.solidAreaDedaultY;        
        
        eventRect[col][row].x = eventRect[col][row].eventRectDefautlX;
        eventRect[col][row].y = eventRect[col][row].eventRectDefautlY;

        return hit;
    } 

    public void teleport(int col, int row, int gameState) {

        gp.gameState = gameState;
        gp.ui.currentDialogue = "Teleportation";
        gp.player.worldX = gp.tileSize*37;
        gp.player.worldY = gp.tileSize*10;

    }

    public void damagePit(int col, int row, int gameState) {

        gp.gameState = gameState;
        gp.ui.currentDialogue = "You fell into a rabbit hole!";
        gp.player.life -= 1;
        //eventRect[col][row].eventDone = true; // Change to false to multiple time event
        canTouchEvent = false;
    }

    public void healingPool(int col, int row, int gameState) {

        System.out.print("healing!");

        /* if(gp.keyH.upPressed == true) { //enterPressed
            gp.gameState = gameState;
            //gp.ui.currentDialogue = "You found the fountain of Youth.\nYour life has been fully restored!";
            gp.player.life = gp.player.maxLife;
            
             //HANDLE LIFE REGEN ZONE
            if(gp.player.life == gp.player.maxLife) {
                if(gp.keyH.upPressed == true) {
                    //DO NOTHING
                    gp.gameState = gameState;
                }
            } 
        } */

        while(gp.player.life != gp.player.maxLife) {
            gp.ui.currentDialogue = "You found the fountain of Youth.\nYour life has been fully restored!";
            gp.gameState = gameState;
            gp.player.life = gp.player.maxLife;

        }

        //gp.keyH.enterPressed = false; // NOT USEFULL
    }

}
