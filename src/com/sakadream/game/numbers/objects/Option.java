/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sakadream.game.numbers.objects;

import java.io.Serializable;

/**
 *
 * @author haipbps04741
 */
public class Option implements Serializable{
    private String mode, difficulty;
    final String FREE_MODE = "Free Mode", TIME_LEFT_MODE = "Time Left Mode",
            EASY = "Easy", MEDIUM = "Medium", HARD = "Hard";
    int time;

    public Option() {
    }

    public Option(String difficulty) {
        this.mode = FREE_MODE;
        this.difficulty = difficulty;
        this.time = 0;
    }

    public Option(String difficulty, int time) {
        this.mode = TIME_LEFT_MODE;
        this.difficulty = difficulty;
        this.time = time;
    }

    public String getMode() {
        return mode;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public int getTime() {
        return time;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
