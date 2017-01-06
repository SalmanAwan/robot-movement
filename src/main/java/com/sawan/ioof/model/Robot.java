package com.sawan.ioof.model;

public class Robot {

    private int currX;

    private int currY;

    private Terrain terrain;

    Robot(Terrain t) {
        this.currX = -1;
        this.currY = -1;
        this.terrain = t;
    }

    public boolean isPositioned() {
        return terrain != null && currX != -1 && currY != -1;
    }

}
