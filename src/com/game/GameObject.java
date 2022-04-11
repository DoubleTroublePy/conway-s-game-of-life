package com.game;

import java.awt.*;

public abstract class GameObject {

    protected int x, y;
    protected ID id;
    protected int height, width;

    public GameObject(int x, int y, int height, int width, ID id){
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
        this.id = id;
    }

    public abstract void tick();
    public abstract void render(Graphics g);

    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public void setId(ID id){
        this.id = id;
    }
    public ID getId() {
        return id;
    }
    public void setVelx(int velx) {
        this.height = velx;
    }
    public void setVely(int vely) {
        this.width = vely;
    }
    public int getVelx() {
        return height;
    }
    public int getVely() {
        return width;
    }

}
