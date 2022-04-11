package com.game;

import java.awt.*;
import java.lang.reflect.Type;
import java.net.PortUnreachableException;
import java.sql.Time;
import java.util.LinkedList;

public class Field{
    private int sx;
    private int sy;
    private int tileDim;
    private boolean run = true;

    private long timer1 = System.currentTimeMillis();

    private Handler handler;
    private Game game;

    private BoolLinkedList2D field = new BoolLinkedList2D();

    public Field(int x, int y, int width, int height, Handler handler) {
        sx = x;
        sy = y;
        this.handler = handler;

        tileDim = Game.WIDTH/width;

        for (int tmpx = 0; tmpx < width; tmpx++) {
            LinkedList<Boolean> tmpField = new LinkedList<Boolean>();
            for (int tmpy = 0; tmpy < height; tmpy++) {
                tmpField.add(false);
                handler.addObject(new Tile(tmpx*tileDim, tmpy*tileDim, tmpx, tmpy, tileDim, tileDim, false, ID.Tile));
            }
            field.add(tmpField);
        }
    }

    public void tick() {

    }

    public void render(Graphics g) {
        for (GameObject object : handler.objects){
            if (object.id == ID.Tile){
                Tile tile = (Tile)object;
                tile.setAlive(field.get(tile.getIDx()).get(tile.getIDy()));
            }
        }
        update();
    }

    public void update(){
        if (run && System.currentTimeMillis() - timer1 > 500){
            int ng;
            BoolLinkedList2D tmpField= new BoolLinkedList2D();
            tmpField.setAll(field);

            for (int x = 0; x < field.size(); x++) {
                for (int y = 0; y < field.get(x).size(); y++) {
                    ng = neighbours(x, y, field);
                    if (ng == 3 || (ng ==2 && field.get(x).get(y))) {
                        tmpField.set(x, y, true);
                    }else if (ng < 2 || ng > 3) {
                        tmpField.set(x, y, false);
                    }
                }
            }
            field = tmpField;
            timer1 = System.currentTimeMillis();
        }
    }

    private int neighbours(int x, int y, final LinkedList<LinkedList<Boolean>> field) {
        int ng = 0;
        int[][] neighbor = {
                {-1, 1},
                {-1, 0},
                {-1, -1},
                {1, 1},
                {1, 0},
                {1, -1},
                {0, 1},
                {0, -1},
        };

        for (int[] ints : neighbor) {
            int tmpx = x + ints[0];
            int tmpy = y + ints[1];

            if (tmpx >= 0 && tmpx < field.size() && tmpy >= 0 && tmpy < field.size() && field.get(tmpx).get(tmpy)) {
                ng += 1;
            }
        }
        return ng;
    }

    public void fieldReset() {
        for (int x = 0; x < field.size(); x++) {
            for (int y = 0; y < field.size(); y++) {
                field.get(x).set(y, false);
            }
        }
    }
    public void fieldRnd() {
        for (int x = 0; x < field.size(); x++) {
            for (int y = 0; y < field.size(); y++) {
                double rnd = Math.random();
                if (rnd > .9)
                    field.get(x).set(y, true);
            }
        }
    }

    public void setTile(int x, int y, boolean status) {
        field.get(x).set(y, status);

    }
    public boolean getTile(int x, int y){
        return field.get(x).get(y);
    }
    public void play_stop(){
        run = !run;
    }
}
