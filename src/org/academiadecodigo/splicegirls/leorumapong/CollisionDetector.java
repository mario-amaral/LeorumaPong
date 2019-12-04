package org.academiadecodigo.splicegirls.leorumapong;

import org.academiadecodigo.splicegirls.leorumapong.paddles.LeftPaddle;
import org.academiadecodigo.splicegirls.leorumapong.paddles.RightPaddle;

import java.io.IOException;

public class CollisionDetector {

    /**
     * COLLISION DETECTOR CLASS
     * class which detects the hits between ball vs paddles and ball vs gutters
     */
    public static final int COLLISION_MARGIN = 3;
    private int rightGutterHitCounter;
    private int leftGutterHitCounter;

    private RightPaddle rightPaddle;
    private LeftPaddle leftPaddle;
    private Ball ball;
    private SoundPlayer soundPlayer;

    private String scoreAudio="/resources/score.wav";

    // ------ CONSTRUCTOR -------
    public CollisionDetector(Ball ball, RightPaddle rightPaddle, LeftPaddle leftPaddle){
        this.ball = ball;
        this.rightPaddle = rightPaddle;
        this.leftPaddle = leftPaddle;

        this.soundPlayer = new SoundPlayer();
    }

    /**
     *  ** GET PLAYER SCORES
     */

    public int getLPScore(){
        return leftGutterHitCounter;
    }

    public int getRPScore(){
        return rightGutterHitCounter;
    }

    /**
     *  ** COLLISION DETECTION:
     *  hitting the paddles or the gutter returns a boolean that is then used in the Ball
     *  class to determine move behaviour.
     */

    public boolean hitRightPaddle() {

        if (ball.getX() > Grid.PLAYFIELD_WIDTH ){

            return true;
        }
        return false;
    }

    public boolean hitLeftPaddle(){
        if (ball.getX() < Grid.PLAYFIELD_PADDING){

            return true;
        }
        return false;
    }

    public boolean hitRightGutter(){
        if (ball.getX() > Grid.PLAYFIELD_WIDTH - COLLISION_MARGIN && (ball.getY() < rightPaddle.getY() || ball.getY() > (rightPaddle.getY()+ rightPaddle.getLength()))){
            try {
                soundPlayer.play(scoreAudio);
            } catch (Exception e){
                System.err.println(e.getMessage());
            }
            return true;
        }
        return false;
    }

    public boolean hitLeftGutter(){
        if ( ball.getX() < Grid.PLAYFIELD_PADDING + COLLISION_MARGIN && (ball.getY() < leftPaddle.getY() || ball.getY() > (leftPaddle.getY() + leftPaddle.getLength()))){
            try {
                soundPlayer.play(scoreAudio);
            } catch (Exception e){
                System.err.println(e.getMessage());
            }
            return true;
        }
        return false;
    }

    /**
     * Set the current score
     * @param score
     */

    public void setRightGutterHitCounter(int score){
        this.rightGutterHitCounter += score;
    }

    public void setLeftGutterHitCounter(int score){
        this.leftGutterHitCounter += score;
    }
}
