package com.game.main;

import java.awt.*;

public abstract class GameObject {

    protected int x, y;
    protected ID id;
    protected int velx, vely;

    public GameObject(int x, int y, ID id){
        this.x = x;
        this.y = y;
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
        this.velx = velx;
    }
    public void setVely(int vely) {
        this.vely = vely;
    }
    public int getVelx() {
        return velx;
    }
    public int getVely() {
        return vely;
    }

}
