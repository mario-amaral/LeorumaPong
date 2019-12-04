package org.academiadecodigo.splicegirls.leorumapong.paddles;

import org.academiadecodigo.Randomizer;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.splicegirls.leorumapong.CollisionDetector;
import org.academiadecodigo.splicegirls.leorumapong.Grid;

public abstract class Paddle{

    /**
     * PADDLE CLASS
     * set the position and movement of the paddle during the game
     */


    /**
     * Instance Variables ****
     */

    private final int VELOCITY = 7;
    private final int MAX_LENGTH = 150;
    static final int THICKNESS = 20;

    private int length; // Changing length of paddles not implemeted (this variable is initialized to MAX_LENGTH)

    private int x;
    private int y;

    private boolean moveUp;
    private boolean moveDown;

    private Rectangle paddle;
    private Color color;


    // ------ CONSTRUCTOR -------
    public Paddle (int x, int length, Color color) {

        this.x = x;
        this.y = (Grid.PLAYFIELD_HEIGHT - length)/2;
        this.length = MAX_LENGTH;

        this.color = color;
        paddle = new Rectangle(x,y, THICKNESS, length - CollisionDetector.COLLISION_MARGIN);
        paddle.setColor(color);
        paddle.draw();
        paddle.fill();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getLength() {
        return length;
    }

    public void setMoveDown(boolean moveDown) {
        this.moveDown = moveDown;
    }

    public void setMoveUp(boolean moveUp) {
        this.moveUp = moveUp;
    }


    /**
     * MOVE method determines the movement of the paddle
     */
    public void move(){

        int yi; // temporary variable to save the position of the paddle before instructing movement
        int yf; // temporary variable to save the position of the paddle after instructing movement

        yi = y;

        if(moveUp && !moveDown){
            if (y - VELOCITY < Grid.PLAYFIELD_PADDING + Grid.BG_PADDING){
                y = Grid.PLAYFIELD_PADDING + Grid.BG_PADDING;
            } else {
                y = y - VELOCITY;
            }
        }

        if (moveDown && !moveUp){
            if((y + VELOCITY) + length > Grid.PLAYFIELD_HEIGHT + Grid.BG_PADDING){
                y = Grid.BG_PADDING + Grid.PLAYFIELD_HEIGHT - length;
            } else {
                y = y + VELOCITY;
            }
        }

        yf = y;
        paddle.translate(0,yf-yi);
    }
}
