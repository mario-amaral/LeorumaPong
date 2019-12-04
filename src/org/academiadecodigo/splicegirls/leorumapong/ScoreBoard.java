package org.academiadecodigo.splicegirls.leorumapong;

import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.concurrent.TimeUnit;

public class ScoreBoard {

    /**
     * SCORE BOARD CLASS
     * class with all the logic and images to represent the score points
     */

    private CollisionDetector collisionDetector;

    private Picture p1Score;
    private Picture p2Score;

    // ------CONSTRUCTOR------
    public ScoreBoard(CollisionDetector collisionDetector){
        this.collisionDetector = collisionDetector;
    }

    /**
     * POSITION COORDS OF THE SCORE CARDS
     */
    private final int XPos_LEFT_SCORE = 100;
    private final int XPos_RIGHT_SCORE = 724;
    private final int YPos_SCORE = 200;


    /**
     * CHANGE P1 SCORE PICTURE
     *
     * @throws InterruptedException
     */

    public void changeP1ScoreCard() throws InterruptedException {
        switch (collisionDetector.getLPScore()){
            case 1:
                p1Score = new Picture(XPos_LEFT_SCORE, YPos_SCORE, "resources/scorecards/p1_hl_s1.png");
                p1Score.draw();
                TimeUnit.SECONDS.sleep(3);
                p1Score.delete();
                break;
            case 2:
                p1Score = new Picture(XPos_LEFT_SCORE, YPos_SCORE, "resources/scorecards/p1_hl_s2.png");
                p1Score.draw();
                TimeUnit.SECONDS.sleep(3);
                p1Score.delete();
                break;
            case 3:
                p1Score = new Picture(XPos_LEFT_SCORE, YPos_SCORE, "resources/scorecards/p1_hl_s3.png");
                p1Score.draw();
                TimeUnit.SECONDS.sleep(3);
                p1Score.delete();
                break;
            case 4:
                p1Score = new Picture(XPos_LEFT_SCORE, YPos_SCORE, "resources/scorecards/p1_hl_s4.png");
                p1Score.draw();
                TimeUnit.SECONDS.sleep(3);
                p1Score.delete();
                break;
            case 5:
                p1Score = new Picture(XPos_LEFT_SCORE, YPos_SCORE, "resources/scorecards/p1_hl_s5.png");
                p1Score.draw();
                TimeUnit.SECONDS.sleep(3);
                p1Score.delete();
                break;
            default:
                break;
        }
    }

    public void changeP2ScoreCard() throws InterruptedException {
        switch (collisionDetector.getRPScore()){
            case 1:
                p2Score = new Picture(XPos_RIGHT_SCORE, YPos_SCORE, "resources/scorecards/p2_hl_s1.png");
                p2Score.draw();
                TimeUnit.SECONDS.sleep(3);
                p2Score.delete();
                break;
            case 2:
                p2Score = new Picture(XPos_RIGHT_SCORE, YPos_SCORE, "resources/scorecards/p2_hl_s2.png");
                p2Score.draw();
                TimeUnit.SECONDS.sleep(3);
                p2Score.delete();
                break;
            case 3:
                p2Score = new Picture(XPos_RIGHT_SCORE, YPos_SCORE, "resources/scorecards/p2_hl_s3.png");
                p2Score.draw();
                TimeUnit.SECONDS.sleep(3);
                p2Score.delete();
                break;
            case 4:
                p2Score = new Picture(XPos_RIGHT_SCORE, YPos_SCORE, "resources/scorecards/p2_hl_s4.png");
                p2Score.draw();
                TimeUnit.SECONDS.sleep(3);
                p2Score.delete();
                break;
            case 5:
                p2Score = new Picture(XPos_RIGHT_SCORE, YPos_SCORE, "resources/scorecards/p2_hl_s5.png");
                p2Score.draw();
                TimeUnit.SECONDS.sleep(3);
                p2Score.delete();
                break;
            default:
                break;
        }
    }

    public void showScorecardP1() {
        switch (collisionDetector.getLPScore()) {
            case 0:
                p1Score = new Picture(XPos_LEFT_SCORE, YPos_SCORE, "resources/scorecards/p1_nm_s0.png");
                p1Score.draw();
                break;
            case 1:
                p1Score = new Picture(XPos_LEFT_SCORE, YPos_SCORE, "resources/scorecards/p1_nm_s1.png");
                p1Score.draw();
                break;
            case 2:
                p1Score = new Picture(XPos_LEFT_SCORE, YPos_SCORE, "resources/scorecards/p1_nm_s2.png");
                p1Score.draw();
                break;
            case 3:
                p1Score = new Picture(XPos_LEFT_SCORE, YPos_SCORE, "resources/scorecards/p1_nm_s3.png");
                p1Score.draw();
                break;
            case 4:
                p1Score = new Picture(XPos_LEFT_SCORE, YPos_SCORE, "resources/scorecards/p1_nm_s4.png");
                p1Score.draw();
                break;
            case 5:
                p1Score = new Picture(XPos_LEFT_SCORE, YPos_SCORE, "resources/scorecards/p1_nm_s5.png");
                p1Score.draw();
                break;
            default:
                break;
        }
    }

    public void showScorecardP2(){
        switch (collisionDetector.getRPScore()){
            case 0:
                p2Score = new Picture(XPos_RIGHT_SCORE, YPos_SCORE, "resources/scorecards/p2_nm_s0.png");
                p2Score.draw();
                break;
            case 1:
                p2Score = new Picture(XPos_RIGHT_SCORE, YPos_SCORE, "resources/scorecards/p2_nm_s1.png");
                p2Score.draw();
                break;
            case 2:
                p2Score = new Picture(XPos_RIGHT_SCORE, YPos_SCORE, "resources/scorecards/p2_nm_s2.png");
                p2Score.draw();
                break;
            case 3:
                p2Score = new Picture(XPos_RIGHT_SCORE, YPos_SCORE, "resources/scorecards/p2_nm_s3.gif");
                p2Score.draw();
                break;
            case 4:
                p2Score = new Picture(XPos_RIGHT_SCORE, YPos_SCORE, "resources/scorecards/p2_nm_s4.png");
                p2Score.draw();
                break;
            case 5:
                p2Score = new Picture(XPos_RIGHT_SCORE, YPos_SCORE, "resources/scorecards/p2_nm_s5.png");
                p2Score.draw();
                break;
            default:
                break;
        }
    }

    /**
     * SHOW FINAL SCORE
     */

    public void showFinalScore() throws InterruptedException {

        if (collisionDetector.getLPScore() > collisionDetector.getRPScore()) {
            p1Score = new Picture(XPos_LEFT_SCORE, YPos_SCORE, "resources/scorecards/p1_hl_s5.png");
            p1Score.draw();
            switch (collisionDetector.getRPScore()) {
                case 0:
                    p2Score = new Picture(XPos_RIGHT_SCORE, YPos_SCORE, "resources/scorecards/p2_nm_s0.png");
                    p2Score.draw();
                    break;
                case 1:
                    p2Score = new Picture(XPos_RIGHT_SCORE, YPos_SCORE, "resources/scorecards/p2_hl_s1.png");
                    p2Score.draw();
                    break;
                case 2:
                    p2Score = new Picture(XPos_RIGHT_SCORE, YPos_SCORE, "resources/scorecards/p2_hl_s2.png");
                    p2Score.draw();

                    break;
                case 3:
                    p2Score = new Picture(XPos_RIGHT_SCORE, YPos_SCORE, "resources/scorecards/p2_hl_s3.png");
                    p2Score.draw();
                    break;
                case 4:
                    p2Score = new Picture(XPos_RIGHT_SCORE, YPos_SCORE, "resources/scorecards/p2_hl_s4.png");
                    p2Score.draw();
                    break;
                case 5:
                    p2Score = new Picture(XPos_RIGHT_SCORE, YPos_SCORE, "resources/scorecards/p2_hl_s5.png");
                    p2Score.draw();
                    break;
                default:
                    break;
            }
        } else {
            p2Score = new Picture(XPos_RIGHT_SCORE, YPos_SCORE, "resources/scorecards/p2_hl_s5.png");
            p2Score.draw();
            switch (collisionDetector.getLPScore()) {
                case 0:
                    p1Score = new Picture(XPos_LEFT_SCORE, YPos_SCORE, "resources/scorecards/p1_nm_s0.png");
                    p1Score.draw();
                    break;
                case 1:
                    p1Score = new Picture(XPos_LEFT_SCORE, YPos_SCORE, "resources/scorecards/p1_hl_s1.png");
                    p1Score.draw();
                    break;
                case 2:
                    p1Score = new Picture(XPos_LEFT_SCORE, YPos_SCORE, "resources/scorecards/p1_hl_s2.png");
                    p1Score.draw();
                    break;
                case 3:
                    p1Score = new Picture(XPos_LEFT_SCORE, YPos_SCORE, "resources/scorecards/p1_hl_s3.png");
                    p1Score.draw();
                    break;
                case 4:
                    p1Score = new Picture(XPos_LEFT_SCORE, YPos_SCORE, "resources/scorecards/p1_hl_s4.png");
                    p1Score.draw();
                    break;
                case 5:
                    p1Score = new Picture(XPos_LEFT_SCORE, YPos_SCORE, "resources/scorecards/p1_hl_s5.png");
                    p1Score.draw();
                    break;
                default:
                    break;
            }
        }
        TimeUnit.SECONDS.sleep(5);
    }
}
