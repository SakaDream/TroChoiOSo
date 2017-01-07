/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sakadream.game.numbers.objects;

/**
 *
 * @author haipbps04741
 */
public class Dot {
    private int x, y, index;

    public Dot() {
    }

    public Dot(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Dot(int index) {
        this.index = index;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getIndex() {
        return index;
    }
    
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
