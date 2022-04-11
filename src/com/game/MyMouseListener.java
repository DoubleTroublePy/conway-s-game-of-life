package com.game;


import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

class MyMouseListener implements MouseListener {
    private Field field;
    private HUD hud;

    public MyMouseListener(Field field, HUD hud){
        this.field = field;
        this.hud = hud;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int tileDim = Game.WIDTH/Game.tileFieldWidth;

        int x = e.getX()/tileDim;
        int y = e.getY()/tileDim;

        if (hud.getSettingBox().intersects(new Rectangle(x, y, 1, 1)))
            System.out.println("penis");
        else
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
