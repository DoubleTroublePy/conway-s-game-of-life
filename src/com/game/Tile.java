package com.game;

import java.awt.*;

public class Tile extends GameObject {
    private boolean alive;
    private int idx, idy;
    
    public Tile(int x, int y, int idx, int idy, int height, int tileDim, boolean alive, ID id) {
        super(x, y, tileDim, tileDim, id);
        this.alive = alive;
        this.idx = idx;
        this.idy = idy;
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        if (alive)
            g.setColor(Color.BLACK);
        else
            g.setColor(Color.WHITE);
        g.fillRect(x, y, width, height);

        g.setColor(Color.GRAY);
        g.drawRect(x, y, width, height);
    }

    public void setAlive(boolean status) {
        this.alive = status;
    }

    public int getIDx(){
        return idx;
    }

    public int getIDy() {
        return idy;
    }
}
