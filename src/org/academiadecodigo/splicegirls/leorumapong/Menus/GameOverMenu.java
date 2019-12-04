package org.academiadecodigo.splicegirls.leorumapong.Menus;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class GameOverMenu {

    /**
     * GAME OVER MENU CLASS
     * creates the Game Over Menu when the game ends.
     * dimensions (1024 x 720)
     */

    /**
     * Instance Variables ****
     */
    private final int BG_PADDING = 10; //same padding used in Grid_BG
    private Picture gameOverBackground;
    private boolean isGameEnded;

    //------ CONSTRUCTOR -------
    public GameOverMenu(){
        this.gameOverBackground = new Picture(BG_PADDING, BG_PADDING,
                "resources/GameOverMenu.png");
    }

    /**
     * Init Game Over when the game is ended
     */

    public void gameOverInit(){
        this.gameOverBackground.draw();
        isGameEnded = !isGameEnded;
    }

    public void gameOverHide(){
        this.gameOverBackground.delete();
    }

    /**
     * Get the status of the game
     */

    public boolean getGameStatus(){
        return isGameEnded;
    }
}

