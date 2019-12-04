package org.academiadecodigo.splicegirls.leorumapong;

import org.academiadecodigo.Randomizer;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Ellipse;

public class Ball {

    /**
     * BALL CLASS
     * set the position and movement of the ball during the game
     */

    /**
     * Instance Variables ****
     */

    private final int RADIUS = 20;
    private final int V_COMP_MAX = 4;
    private final int V_COMP_MIN = 3;
    private boolean pause;

    private int x; //X-coordinate (in pixels)
    private int y; //Y-coordinate (in pixels)

    private int vx;
    private int vy;

    private CollisionDetector collisionDetector;
    private Ellipse ball;

    private SoundPlayer soundPlayer;
    private String leftPaddleAudio ="/resources/leftpong.wav";
    private String rightPaddleAudio ="/resources/rightpong.wav";
    private String wallsAudio ="/resources/walls.wav";
    private String scoreAudio="/resources/score.wav";

    // ------ CONSTRUCTOR ------
    public Ball(Color color){
        setInitialXY();
        setRandomDirection();

        pause = false;
        ball = new Ellipse(x,y,RADIUS,RADIUS);
        ball.setColor(color);
        ball.fill();
        this.soundPlayer = new SoundPlayer();
    }

    /**
     * SHOW or HIDE the ball on the playground
     */

    public void show(){
        ball.fill();
    }

    public void hide(){
        ball.delete();
    }



    public void setXY(int x, int y){
        this.x = x;
        this.y = y;
    }

    /**
     * SET THE INITIAL POSITION OF THE BALL
     */

    public void setInitialXY(){

       this.x = 512;
       this.y = 365;
    }

    public void setPause(boolean pause) {
        this.pause = pause;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setRandomDirection(){

        int vxSign = Randomizer.getRandomInt(0,1);

        switch (vxSign){
            case(0): // vx will be negative
                vx = - Randomizer.getRandomInt(V_COMP_MIN,V_COMP_MAX);
                break;
            case(1): //vx will be positive
                vx = Randomizer.getRandomInt(V_COMP_MIN,V_COMP_MAX);
                break;
            default:
                System.err.println("Unable to set random movement direction vx");
        }

        int vySign = Randomizer.getRandomInt(0,1);

        switch (vySign){
            case(0): // vy will be negative
                vy = - Randomizer.getRandomInt(V_COMP_MIN,V_COMP_MAX-1);
                break;
            case(1): // vy will be positive
                vy = Randomizer.getRandomInt(V_COMP_MIN,V_COMP_MAX-1);
                break;
            default:
                System.err.println("Unable to set random movement direction vy");
        }
    }

    public void setMoveDirection(int vx, int vy){
        this.vx = vx;
        this.vy = vy;
    }

    public void play(CollisionDetector collisionDetector, boolean pause){

        if (pause){
            stop();
        } else {
            move(collisionDetector);
        }
    }

    private void move(CollisionDetector collisionDetector){
        int xi = x;
        int yi = y;
        int xf = moveX(collisionDetector);
        int yf = moveY();
        ball.translate(xf - xi, yf - yi);
    }

    private void stop(){
//        this.x = 300;
//        this.y = 100;

    }

    private int moveX(CollisionDetector collisionDetector){

        if (collisionDetector.hitLeftGutter()){
            x = Grid.PLAYFIELD_WIDTH/2;
            y = Grid.PLAYFIELD_HEIGHT/2;
            setRandomDirection();


        }

        if (collisionDetector.hitRightGutter()){
            x = Grid.PLAYFIELD_WIDTH/2;
            y = Grid.PLAYFIELD_HEIGHT/2;
            setRandomDirection();
        }

        x = x + vx;

        if (collisionDetector.hitLeftPaddle()) {
            vx = -vx;
            x = x + vx;
            try {
                soundPlayer.play(leftPaddleAudio);
            } catch (Exception e){
                System.err.println(e.getMessage());
            }
        }
        if (collisionDetector.hitRightPaddle()) {
            vx = -vx;
            x = x + vx;
            try {
                soundPlayer.play(rightPaddleAudio);
            } catch (Exception e){
                System.err.println(e.getMessage());
            }
        }
        return x;
    }

    private int moveY(){

        y = y + vy;

        if (y < Grid.PLAYFIELD_PADDING || y > Grid.PLAYFIELD_HEIGHT){
            vy = -vy;
            y = y + vy;
            try {
                soundPlayer.play(wallsAudio);
            } catch (Exception e){
                System.err.println(e.getMessage());
            }
        }
        return y;
    }
}
