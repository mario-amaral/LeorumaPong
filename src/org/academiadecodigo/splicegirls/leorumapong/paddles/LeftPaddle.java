package org.academiadecodigo.splicegirls.leorumapong.paddles;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.splicegirls.leorumapong.Grid;
import org.academiadecodigo.splicegirls.leorumapong.paddles.Paddle;

public class LeftPaddle extends Paddle implements KeyboardHandler {

    /**
     * LEFT PADDLE SUBCLASS
     * set the specific movement and controls of the left paddle
     */

    public LeftPaddle(int length, Color color) {
        super(Grid.BG_PADDING + Grid.PLAYFIELD_PADDING - THICKNESS+1, length, color);
        keyboardInit();
    }
    public void move(){
        super.move();
    }

    private void keyboardInit(){

        Keyboard keyboard = new Keyboard(this);

        KeyboardEvent WkeyPressed = new KeyboardEvent();
        KeyboardEvent SkeyPressed = new KeyboardEvent();

        WkeyPressed.setKey(KeyboardEvent.KEY_W);
        SkeyPressed.setKey(KeyboardEvent.KEY_S);

        WkeyPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        SkeyPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(WkeyPressed);
        keyboard.addEventListener(SkeyPressed);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()){
            case KeyboardEvent.KEY_W:
                super.setMoveUp(true);
                super.setMoveDown(false);
                break;
            case KeyboardEvent.KEY_S:
                super.setMoveDown(true);
                super.setMoveUp(false);
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent){
    }
}
