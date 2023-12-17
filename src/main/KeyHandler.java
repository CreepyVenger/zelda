package main;

//import java.awt.RenderingHints.Key;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import entity.Player;

public class KeyHandler implements KeyListener {

    public boolean upPressed, downPressed, leftPressed, rightPressed, enterPressed, shiftSpeed, shotKeyPressed;
    //DEBUG
    boolean showDebugText = false; //Previously checkDrawTime
    private boolean firstPress = true;

    GamePanel gp;
    public KeyHandler(GamePanel gp) {
        this.gp = gp;

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        int code = e.getKeyCode();

        //TITLE STATE
        if(gp.gameState == gp.titleState) {
            titleState(code);  
        }

        //PLAY STATE
        else if(gp.gameState == gp.playState) {           
            playState(code);
        }

        //PAUSE STATE
        else if(gp.gameState == gp.pauseState) {
            pausetate(code);         
        }

        //DIALOGUE STATE
        else if(gp.gameState == gp.dialogueState) {
            dialogueState(code);     
        }

        //CHARACTER STATE
        else if(gp.gameState == gp.characterState) {            
            characterState(code);   
        }

        //GAME OVER STATE
        else if(gp.gameState == gp.gameOverState) {            
            gameOverState(code);   
        }



    }
    
    public void titleState(int code) {

        //FIRST TITLE SCREEN STATE
            if(gp.ui.titleScreenState == 0) {

                if (code == KeyEvent.VK_UP) {
                    gp.ui.commandNum--;
                    if(gp.ui.commandNum < 0) {
                        gp.ui.commandNum = 3;
                    }
                }

                if (code == KeyEvent.VK_DOWN) {
                    gp.ui.commandNum++;
                    if(gp.ui.commandNum > 3) {
                        gp.ui.commandNum = 0;
                    }
                }

                if(code == KeyEvent.VK_ENTER) {
                    
                    if(gp.ui.commandNum == 0) {
                        //gp.gameState = gp.playState; //done before implementing the subspace logic
                        gp.ui.titleScreenState = 1; //We are on the first title scren page, on the first line (commandNum == 0), if we click, we go to the next state of titleScreenState (=1 ), the next page
                        //gp.playMusic(0); //not necessary
                    }

                    if(gp.ui.commandNum == 1) {
                        //CODE LOADING GAME LOGIC LATER
                    }

                    if(gp.ui.commandNum == 2) {
                        //Settings window 
                        gp.ui.titleScreenState = 2;
                    }

                    if(gp.ui.commandNum == 3) {
                        System.out.println("Quitting Game start"); 
                        System.exit(0);
                        System.out.println("Quitting Game finish"); 
                    }                  
                } 
            }

            // SECOND/NEXT TITLE SCREEN STATE FOR FIRST LINE FIRST PAGE
            else if(gp.ui.titleScreenState == 1) {

                if (code == KeyEvent.VK_UP) {
                    gp.ui.commandNum--;
                    if(gp.ui.commandNum < 0) {
                        gp.ui.commandNum = 3;
                    }
                }

                if (code == KeyEvent.VK_DOWN) {
                    gp.ui.commandNum++;
                    if(gp.ui.commandNum > 3) {
                        gp.ui.commandNum = 0;
                    }
                }

                if(code == KeyEvent.VK_ENTER) {
                    
                    if(gp.ui.commandNum == 0) { //IF FIRST LINE AND ENTER, WE PLAY THE FIGHTER
                        System.out.println("Do some fighter specific stuff!");
                        gp.gameState = gp.playState;
                        gp.playMusic(0);
                    }

                    if(gp.ui.commandNum == 1) { //IF SECOND LINE AND ENTER, WE PLAY THE THIEF
                        System.out.println("Do some thief specific stuff!");
                        gp.gameState = gp.playState;
                        gp.playMusic(0);
                    }

                    if(gp.ui.commandNum == 2) { //IF THIRD LINE AND ENTER, WE PLAY THE WITCHER
                        System.out.println("Do some witcher specific stuff!");
                        gp.gameState = gp.playState;
                        gp.playMusic(0);
                    }

                    if(gp.ui.commandNum == 3) { //IF FOURTH LINE AND ENTER, WE GO BACK
                        gp.ui.titleScreenState = 0; // WE GO BACK PUTTING THE TITLE SCREEN STATE TO THE FIRST STATE, THE the 0th
                    }  

                } 
            }

            else if(gp.ui.titleScreenState == 1){
                //SECOND SCREEN OF THE SECOND LINE (LOAD GAME) TO DO
            }

            // THIRD/NEXT TITLE SCREEN STATE FOR THIRD LINE FIRST PAGE (SETTINGS)
            else if(gp.ui.titleScreenState == 2) {

                if (code == KeyEvent.VK_UP) {
                    gp.ui.commandNum--;
                    if(gp.ui.commandNum < 0) {
                        gp.ui.commandNum = 3;
                    }
                }

                if (code == KeyEvent.VK_DOWN) {
                    gp.ui.commandNum++;
                    if(gp.ui.commandNum > 3) {
                        gp.ui.commandNum = 0;
                    }
                }

                if (code == KeyEvent.VK_LEFT) {
                    gp.ui.commandNumLat--;
                    if(gp.ui.commandNumLat == 0) {
                        System.out.println("Sound Off");
                        gp.stopMusic();
                    }
                }

                if (code == KeyEvent.VK_RIGHT) {
                    gp.ui.commandNumLat++;
                    if(gp.ui.commandNumLat == 1) {
                        System.out.println("Sound On");
                        gp.playMusic(0);
                    }
                }

                //WHAT I TRIED TO DO, TO SEE WHY IT DOESN'T WORK

                /* if(code == KeyEvent.VK_RIGHT) {
                    gp.ui.commandNumLat++;
                    if(gp.ui.commandNum < 0) {
                        gp.ui.commandNum = 1;
                        System.out.println("Sound On");
                        gp.playMusic(0);
                    }
                    
                    if(gp.ui.commandNum > 1) {
                        gp.ui.commandNum = 0;
                        System.out.println("Sound off");
                        gp.stopMusic();
                    }
                }

                if(code == KeyEvent.VK_LEFT) {
                    gp.ui.commandNumLat--;
                    if(gp.ui.commandNumLat == 0) { 
                        System.out.println("Sound On");
                        gp.playMusic(0);
                    }

                    if(gp.ui.commandNum == 1) { 
                        System.out.println("Sound Off");
                        gp.stopMusic();
                    }     
                } */

                if(code == KeyEvent.VK_ENTER) {
                    
                    if(gp.ui.commandNum == 0) { 
                        
                    }

                    if(gp.ui.commandNum == 1) { 
                        //IF SECOND LINE AND ENTER, WE HANDLE LANGUE (THIRD TITLE SCREEN PAGE TO DO)
                    }

                    if(gp.ui.commandNum == 2) { 
                        //IF THIRD LINE AND ENTER, WE HANDLE DIFFICULTY (THIRD TITLE SCREEN PAGE TO DO)
                    }

                    if(gp.ui.commandNum == 3) { //IF FOURTH LINE AND ENTER, WE GO BACK
                        gp.ui.titleScreenState = 0; // WE GO BACK PUTTING THE TITLE SCREEN STATE TO THE FIRST STATE, THE the 0th
                    }
                }

            }
    }
    
    public void playState(int code) {
        
        if (code == KeyEvent.VK_Z) {
                upPressed = true;
            }

            if (code == KeyEvent.VK_Q) {
                leftPressed = true;
            }

            if (code == KeyEvent.VK_S) {
                downPressed = true;
            }

            if (code == KeyEvent.VK_D) {
                rightPressed = true;
            }

            if (code == KeyEvent.VK_ASTERISK) {
                shotKeyPressed = true;
            }

            //SPEED SHIFT KEY
            if(code == KeyEvent.VK_SHIFT) {   
                shiftSpeed = true;         
                gp.player.speedGround = 15;  
                System.out.println("Shift speed!"); 
            }

            if (code == KeyEvent.VK_I) {
                gp.gameState = gp.characterState;
            }

            if (code == KeyEvent.VK_P) {
                gp.gameState = gp.pauseState; //If we press P and if the Game is playing, then the state of the game becomes Pause
                
                /* if(gp.gameState == gp.playState) { 
                    gp.gameState = gp.pauseState; //If we press P and if the Game is playing, then the state of the game becomes Pause
                }
                else if(gp.gameState == gp.pauseState) {
                    gp.gameState = gp.playState;
                } */
            }

            if (code == KeyEvent.VK_M) {
                if (firstPress) {
                    gp.stopMusic();
                    System.out.println("Stop Music");
                    firstPress = false;
                } else {
                    gp.playMusic(0);
                    System.out.println("Play Music");
                    firstPress = true;
                }
            }

            if (code==KeyEvent.VK_SPACE  && gp.player.collisionOn==true){
                    gp.player.setblocked(true);
                    System.out.println("blocked");
            }
            
            // This is the code which sets up the arrow keys on the keyboard to zoom in or out. Disabled since code is "iffy".
            /*if (code == KeyEvent.VK_UP) {
                gp.zoomInOut(1);
            }

            if (code == KeyEvent.VK_DOWN) {
                gp.zoomInOut(-1);
            }*/

            if (code == KeyEvent.VK_ENTER) {
                enterPressed = true;
            }
            
            //DEBUG
            if(code == KeyEvent.VK_T) {
                if(showDebugText == false) {
                    showDebugText = true;
                }
                else if(showDebugText == true) {
                    showDebugText = false;
                }

            }

             if(code == KeyEvent.VK_R) {
                gp.tileM.loadMap("/maps/WorldV2.txt");
                System.out.println("Map refreshed!");
             }
    }

    public void pausetate(int code) {
        
        if (code == KeyEvent.VK_P) {
            gp.gameState = gp.playState; //If we press P and if the Game is playing, then the state of the game becomes Pause
        }
    }

    public void dialogueState(int code) {
        
        if(code == KeyEvent.VK_ENTER) {
                    gp.gameState = gp.playState;
                    //draw(ui.g2); WHY DID I WRITE THIS ??
                }
    }

    public void characterState(int code) {
        
        if(code == KeyEvent.VK_I) {
            gp.gameState = gp.playState;
        }

        if(code == KeyEvent.VK_Z) {

            if(gp.ui.slotRow != 0) {
                gp.ui.slotRow--;
                gp.playSE(9);
            }
            
        }

        if(code == KeyEvent.VK_Q) {
            if(gp.ui.slotCol != 0) {
                gp.ui.slotCol--;
                gp.playSE(9);
            }
            
        }

        if(code == KeyEvent.VK_S) {
            if(gp.ui.slotRow != 3) {
                gp.ui.slotRow++;
                gp.playSE(9);
            }
            
        }

        if(code == KeyEvent.VK_D) {
            if(gp.ui.slotCol != 4) {
                gp.ui.slotCol++;
                gp.playSE(9);
            }
            
        }

        if(code == KeyEvent.VK_ENTER) {
            gp.player.selectItems();
            System.out.println("ENTER");
        }


    }

    public void gameOverState(int code) {

        if(code == KeyEvent.VK_UP) {
            gp.ui.commandNum--;
            if(gp.ui.commandNum < 0) {
                gp.ui.commandNum = 1;
            }
            gp.playSE(9);
        }
        

        if(code == KeyEvent.VK_DOWN) {
            gp.ui.commandNum++;
            if(gp.ui.commandNum > 1) {
                gp.ui.commandNum = 0;
            }
            gp.playSE(9);
        }

        if(code == KeyEvent.VK_ENTER) {
            if(gp.ui.commandNum == 0) {
                gp.gameState = gp.playState;
                gp.retry();
            }
            
            else if(gp.ui.commandNum == 1) {
                gp.gameState = gp.titleState;
                gp.ui.titleScreenState = 0;
                gp.restart();
            }
        }
        
        
    }

    @Override
    public void keyReleased(KeyEvent e) {

        int code = e.getKeyCode();

        if (code == KeyEvent.VK_Z) {
            upPressed = false;
        }

        if (code == KeyEvent.VK_Q ) {
            leftPressed = false;
        }

        if (code == KeyEvent.VK_S) {
            downPressed = false;
        }

        if (code == KeyEvent.VK_D) {
            rightPressed = false;
        }

        if (code == KeyEvent.VK_SHIFT) {
            shiftSpeed = false;
            gp.player.speedGround = gp.worldWidth / 600;
            System.out.println("Shift speed! no "); 
        }

        if (code == KeyEvent.VK_ASTERISK) {
                shotKeyPressed = false;
            }

    }
}


