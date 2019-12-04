package org.academiadecodigo.splicegirls.leorumapong;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Grid {

    /**
     * Instance Variables ****
     */

    private Picture background; // Background shape

    public static final int BG_PADDING = 10; // Padding (up and left) to compensate for automatic padding on down, right sides.
    public static final int BG_WIDTH = 1024; //Width of the background frame
    public static final int BG_HEIGHT = 720; //Height of the background frame

    public static final int PLAYFIELD_PADDING = 30;
    public static final int PLAYFIELD_WIDTH = BG_WIDTH - PLAYFIELD_PADDING;
    public static final int PLAYFIELD_HEIGHT = BG_HEIGHT - PLAYFIELD_PADDING;

    private Picture p1Score;
    private Picture p2Score;
    private final int XPos_LEFT_SCORE = 100;
    private final int XPos_RIGHT_SCORE = 724;
    private final int YPos_SCORE = 200;

    // ------ CONSTRUCTOR -----

    public Grid(){
        background = new Picture(BG_PADDING, BG_PADDING,"resources/playfieldBg.png");
        background.draw();
        p1Score = new Picture (XPos_LEFT_SCORE, YPos_SCORE, "resources/scorecards/p1_nm_s0.png");
        p1Score.draw();
        p2Score = new Picture(XPos_RIGHT_SCORE, YPos_SCORE, "resources/scorecards/p2_nm_s0.png");
        p2Score.draw();
    }
}
