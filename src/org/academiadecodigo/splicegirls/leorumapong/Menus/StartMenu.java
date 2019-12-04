package org.academiadecodigo.splicegirls.leorumapong.Menus;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Ellipse;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.splicegirls.leorumapong.Grid;
import org.academiadecodigo.splicegirls.leorumapong.SoundPlayer;

import javax.sound.sampled.Clip;

public class StartMenu implements KeyboardHandler {

    /**
     * START MENU CLASS
     * creates the initial menu game when the LeoRuMa Pong Game is launched.
     * dimensions (1024 x 720)
     */

    /**
     * Instance Variables ****
     */

    private boolean isGamePaused;
    private boolean isGameStarted;
    private PauseMenu pauseMenu;
    private GameOverMenu gameOverMenu;

    private SoundPlayer soundPlayer;
    private String introMusic ="/resources/leorumaintro.wav";
    private String pauseSound ="/resources/pause.wav";
    private Clip clip;

    // ------ BACKGROUND -------
    private Picture background;
    private final int BG_PADDING = Grid.BG_PADDING; //same padding used in Grid_BG

    // ------ READY CARD
    private Picture readyCard;
    private String readyCardfile = "resources/readyCard.png";

    //------ SCREEN CURSOR ------
    private Ellipse cursor;
    private final int cursor_RADIUS = 15;

    //------ ABOUT SCREEN -------
    private Picture about;
    private boolean isAboutActive = false;

    //------ CONSTRUCTOR -------

    public StartMenu(PauseMenu pauseMenu, GameOverMenu gameOverMenu){
        this.pauseMenu = pauseMenu;
        this.gameOverMenu = gameOverMenu;
        isGamePaused = true;
        isGameStarted = false;
        this.soundPlayer = new SoundPlayer();
    }

    /**
     * Init method will create all the Menu Start shapes, when the START MENU object was called by Game
     */

    public void init(){
        this.background = new Picture(BG_PADDING, BG_PADDING,
                "resources/startMenu.png");
        background.draw();

        // ------ READY CARD

        this.readyCard = new Picture(260, 70, readyCardfile);

        // ------ CURSOR ------
        this.cursor = new Ellipse(30 + BG_PADDING, 257 + BG_PADDING, cursor_RADIUS, cursor_RADIUS);
        cursor.setColor(Color.WHITE);
        cursor.fill();

        // ------ INIT THE MOVEMENT KEYBOARD INPUT ------
        keyboardInit();

        // ------ PLAY INTRO MUSIC
        playIntroMusic();
    }

    /**
     * Hide the START MENU
     */
    public void startMenuHide(){
        background.delete();
        cursor.delete();
        this.isGameStarted = true;
    }

    public void playIntroMusic(){
            try {
                clip = soundPlayer.playLoop(introMusic);
            } catch (Exception e){
                System.err.println(e.getMessage());
            }
    }

    /**
     * Returns if the Pong Game is paused or not
     */

    public boolean gamePaused() {
        return isGamePaused;
    }


    /**
     * MOVE THE SELECTION BUTTONS
     */

    private void keyboardInit(){

        Keyboard keyboard = new Keyboard(this);

        /**
         * Set the KEY_DOWN
         */

        KeyboardEvent downKeyPressed = new KeyboardEvent();
        downKeyPressed.setKey(KeyboardEvent.KEY_DOWN);
        downKeyPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(downKeyPressed);

        /**
         * Set the KEY_UP
         */

        KeyboardEvent upKeyPressed = new KeyboardEvent();
        upKeyPressed.setKey(KeyboardEvent.KEY_UP);
        upKeyPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(upKeyPressed);

        /**
         * Set the SPACE KEY
         */

        KeyboardEvent spaceKeyPressed = new KeyboardEvent();
        spaceKeyPressed.setKey(KeyboardEvent.KEY_SPACE);
        spaceKeyPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(spaceKeyPressed);

        /**
         * Set the P KEY
         */

        KeyboardEvent pKeyPressed = new KeyboardEvent();
        pKeyPressed.setKey(KeyboardEvent.KEY_P);
        pKeyPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(pKeyPressed);

        /**
         * Set the Q KEY
         */

        KeyboardEvent qKeyPressed = new KeyboardEvent();
        qKeyPressed.setKey(KeyboardEvent.KEY_Q);
        qKeyPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(qKeyPressed);

    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_DOWN:

                //IF - to limit the movement of the Selection button in the screen
                if (cursor.getY() == 457 + BG_PADDING) {
                    break;
                }
                cursor.translate(0, 100);
                break;


            case KeyboardEvent.KEY_UP:
                //IF - to limit the movement of the Selection button in the screen
                if (cursor.getY() == 257 + BG_PADDING) {
                    break;
                }
                cursor.translate(0, -100);
                break;

            case KeyboardEvent.KEY_SPACE:
                if (isGameStarted) {
                    isGamePaused = false;
                    readyCardHide();
                    soundPlayer.stopLoop(clip);
                    break;

                } else if (isAboutActive) {
                    isAboutActive = false;
                    about.delete();

                } else {
                    if (cursor.getY() == 257 + BG_PADDING) {
                        startMenuHide();
                        readyCardShow();
                        break;

                    } else if (cursor.getY() == 357 + BG_PADDING && !isAboutActive) {
                        aboutInit();
                        break;

                    } else {
                        quitGame();
                    }
                    break;
                }

            case KeyboardEvent.KEY_P:
                if (!isGameStarted){
                    break;
                } else {
                    isGamePaused = !isGamePaused;
                    pauseMenu.initPauseMenu(isGamePaused);

                    try {
                        soundPlayer.play(pauseSound);
                    } catch (Exception e){
                        System.err.println(e.getMessage());
                    }
                    break;
                }

            case KeyboardEvent.KEY_Q:
                if (isGameStarted && isGamePaused && !gameOverMenu.getGameStatus()){
                    quitGame();
                    break;

                } else if (gameOverMenu.getGameStatus()){
                    quitGame();
                    break;
                }
                break;

            default:
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
    }

    /**
     * Method to show an image of LeoRuMa Pong Game instructions
     */

    public void aboutInit(){
        if(isAboutActive) {
            return;
        }
        isAboutActive = true;
        this.about = new Picture(BG_PADDING, BG_PADDING,
                "resources/aboutMenu.png");
        about.draw();
    }

    private void readyCardShow(){
        readyCard.draw();
    }

    private void readyCardHide(){
        readyCard.delete();
    }

    /**
     * Method to exit the game (stop the Runtime)
     */

    public void quitGame(){
        System.exit(0);
    }

}
