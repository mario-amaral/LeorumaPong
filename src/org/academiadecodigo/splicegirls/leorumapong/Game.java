package org.academiadecodigo.splicegirls.leorumapong;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.splicegirls.leorumapong.Menus.GameOverMenu;
import org.academiadecodigo.splicegirls.leorumapong.Menus.PauseMenu;
import org.academiadecodigo.splicegirls.leorumapong.Menus.StartMenu;
import org.academiadecodigo.splicegirls.leorumapong.paddles.LeftPaddle;
import org.academiadecodigo.splicegirls.leorumapong.paddles.RightPaddle;

public class Game {

    /**
     * GAME CLASS
     * the manager class, which controls the game flow
     */

    /**
     * Instance Variables ****
     */

    private final int DELAY = 6;
    private final int MAX_SCORE = 5;

    private StartMenu startMenu;
    private PauseMenu pauseMenu;
    private Grid gamefield;
    private LeftPaddle leftPaddle;
    private RightPaddle rightPaddle;
    private Ball pongBall;
    private CollisionDetector collisionDetector;
    private GameOverMenu gameOverMenu;
    private ScoreBoard scoreBoard;


    // ------ CONSTRUCTOR -------
    public Game(){
        this.gamefield = new Grid();
        this.pauseMenu = new PauseMenu();
        this.gameOverMenu = new GameOverMenu();
        this.startMenu = new StartMenu(pauseMenu, gameOverMenu);
        this.leftPaddle = new LeftPaddle(150,Color.WHITE);
        this.rightPaddle = new RightPaddle(150, Color.WHITE);
        this.pongBall = new Ball(Color.RED);
        this.collisionDetector = new CollisionDetector(pongBall, rightPaddle, leftPaddle);
        this.scoreBoard = new ScoreBoard(collisionDetector);
    }


    /**
     * STARTING MENU: starts a Pong Game ****
     * @throws InterruptedException
     */

    public void start() throws InterruptedException {

        startMenu.init();

        // ------ GAME LOOP ------

        while (collisionDetector.getRPScore() != MAX_SCORE && collisionDetector.getLPScore() !=  MAX_SCORE) {

            // Pause for a while
            Thread.sleep(DELAY);
            pongBall.play(collisionDetector, startMenu.gamePaused());
            rightPaddle.move();
            leftPaddle.move();

            if (collisionDetector.hitRightGutter()){
                collisionDetector.setLeftGutterHitCounter(1);

                pongBall.hide();
                scoreBoard.showScorecardP1();
                scoreBoard.changeP1ScoreCard();
                pongBall.show();
            }
            if (collisionDetector.hitLeftGutter()){
                collisionDetector.setRightGutterHitCounter(1);
                pongBall.hide();
                scoreBoard.showScorecardP2();
                scoreBoard.changeP2ScoreCard();
                pongBall.show();
            }
        }
        pongBall.hide();
        gameOverMenu.gameOverInit();
        scoreBoard.showFinalScore();
    }
}