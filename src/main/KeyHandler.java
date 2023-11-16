package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    public boolean upPressed, downPressed, leftPressed, rightPressed, enterPressed;
    //DEBUG
    boolean checkDrawTime = false;
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

            // SECOND/NEXT TITLE SCREEN STATE FOR THIRD LINE FIRST PAGE (SETTINGS)
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

        //PLAY STATE
        else if(gp.gameState == gp.playState) {
            
            if (code == KeyEvent.VK_Z) {
                System.out.println("up1");
                upPressed = true;
                System.out.println("up2");
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

            if (code == KeyEvent.VK_P) {
                gp.gameState = gp.pauseState; //If we press P and if the Game is playing, then the state of the game becomes Pause

                /* if(gp.gameState == gp.playState) { 
                    gp.gameState = gp.pauseState; //If we press P and if the Game is playing, then the state of the game becomes Pause
                }
                else if(gp.gameState == gp.pauseState) {
                    gp.gameState = gp.playState;
                } */
            }

            if (e.getKeyCode() == KeyEvent.VK_M) {
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
            
            if (code == KeyEvent.VK_UP) {
                gp.zoomInOut(1);
            }

            if (code == KeyEvent.VK_DOWN) {
                gp.zoomInOut(-1);
            }

            if (code == KeyEvent.VK_ENTER) {
                enterPressed = true;
            }
            

            //DEBUG
            if(code == KeyEvent.VK_T) {
                if(checkDrawTime == false) {
                    checkDrawTime = true;
                }
                else if(checkDrawTime == true) {
                    checkDrawTime = false;
                }

            }

        }

            //PAUSE STATE
            else if(gp.gameState == gp.pauseState) {

                if (code == KeyEvent.VK_P) {
                    gp.gameState = gp.playState; //If we press P and if the Game is playing, then the state of the game becomes Pause
                }
                
            }

            //DEATH STATE
            else if(gp.gameState == gp.deathState) {

                if (code == KeyEvent.VK_ENTER) {
                    gp.gameState = gp.playState; //If we press P and if the Game is playing, then the state of the game becomes Pause
                }
                
            }

            //DIALOGUE STATE
            else if(gp.gameState == gp.dialogueState) {

                if(code == KeyEvent.VK_ENTER) {
                    gp.gameState = gp.playState;
                    //draw(ui.g2); WHY DID I WRITE THIS ??
                }

            }
        }
    
       


    @Override
    public void keyReleased(KeyEvent e) {

        int code = e.getKeyCode();

        if (code == KeyEvent.VK_Z) {
            upPressed = false;
        }

        if (code == KeyEvent.VK_Q) {
            leftPressed = false;
        }

        if (code == KeyEvent.VK_S) {
            downPressed = false;
        }

        if (code == KeyEvent.VK_D) {
            rightPressed = false;
        }

    }
}


