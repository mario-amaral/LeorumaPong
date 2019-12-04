package org.academiadecodigo.splicegirls.leorumapong.Menus;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class PauseMenu {

    /**
     * PAUSE MENU CLASS
     * creates the Pause Menu when the LeoRuMa Pong Game is paused.
     * dimensions (1024 x 720)
     */

    /**
     * Instance Variables ****
     */

    private final int BG_PADDING = 10; //same padding used in Grid_BG
    private Picture pauseBackground;


    // ----- CONSTRUCTOR ----
    public PauseMenu (){
        this.pauseBackground = new Picture(BG_PADDING, BG_PADDING,
                "resources/pauseMenu.png");
    }

    /**
     * Init Pause Menu: method to open the Pause menu in the Game Screen
     */

    public void initPauseMenu(boolean gamePaused){
        if (!gamePaused){
            pauseBackground.delete();
            return;
        }
        pauseBackground.draw();
    }
}
