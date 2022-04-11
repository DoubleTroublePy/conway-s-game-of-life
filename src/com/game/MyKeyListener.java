package com.game;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

class MyKeyListener implements KeyListener {
    private Field field;

    public MyKeyListener(Field field){
        this.field = field;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        char key = e.getKeyChar();
        if (key == KeyEvent.VK_SPACE)
            field.play_stop();
        else if (key == 'r')
            field.fieldRnd();
        else if (key == 'c')
            field.fieldReset();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
