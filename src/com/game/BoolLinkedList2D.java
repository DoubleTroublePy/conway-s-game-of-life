package com.game;

import java.util.LinkedList;

public class BoolLinkedList2D extends LinkedList<LinkedList<Boolean>> {

    public Boolean get(int x, int y){
        return this.get(x).get(y);
    }
    public void set(int x, int y, Boolean status){
        this.get(x).set(y, status);
    }
    public void setAll(BoolLinkedList2D field){
        for (LinkedList<Boolean> booleans : field) {
            LinkedList<Boolean> tmpField = new LinkedList<Boolean>();
            for (int tmpy = 0; tmpy < booleans.size(); tmpy++) {
                tmpField.add(false);
            }
            this.add(tmpField);
        }

    }

}
