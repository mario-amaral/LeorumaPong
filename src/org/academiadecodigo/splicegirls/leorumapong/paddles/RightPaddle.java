package org.academiadecodigo.splicegirls.leorumapong.paddles;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.splicegirls.leorumapong.Grid;
import org.academiadecodigo.splicegirls.leorumapong.paddles.Paddle;

public class RightPaddle extends Paddle implements KeyboardHandler {

    /**
     * RIGHT PADDLE SUBCLASS
     * set the specific movement and controls of the left paddle
     */

    public RightPaddle(int length, Color color) {
        super(Grid.BG_PADDING + Grid.PLAYFIELD_WIDTH, length, color);
        keyboardInit();
    }

    public void move(){
        super.move();
    }

    private void keyboardInit(){

        Keyboard keyboard = new Keyboard(this);

        KeyboardEvent UpKeyPressed = new KeyboardEvent();
        KeyboardEvent DownKeyPressed = new KeyboardEvent();

        UpKeyPressed.setKey(KeyboardEvent.KEY_UP);
        DownKeyPressed.setKey(KeyboardEvent.KEY_DOWN);

        UpKeyPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        DownKeyPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(UpKeyPressed);
        keyboard.addEventListener(DownKeyPressed);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()){
            case KeyboardEvent.KEY_UP:
//                yi = super.getY();
                super.setMoveUp(true);
                super.setMoveDown(false);
                break;
            case KeyboardEvent.KEY_DOWN:
                super.setMoveDown(true);
                super.setMoveUp(false);
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
    }
}
