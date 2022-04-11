package com.game;


import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

class MyMouseListener implements MouseListener {
    private Field field;

    public MyMouseListener(Field field){
        this.field = field;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        int tileDim = Game.WIDTH/Game.tileFieldWidth;

        int x = e.getX()/tileDim;
        int y = e.getY()/tileDim;

        field.setTile(x, y, !field.getTile(x, y));
    }

    @Override
    public void mouseEntered(MouseEvent e) { }

    @Override
    public void mouseExited(MouseEvent e) { }

    @Override
    public void mousePressed(MouseEvent arg0) { }

    @Override
    public void mouseReleased(MouseEvent arg0) { }

}
