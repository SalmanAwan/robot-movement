package com.sawan.ioof.model;

public class Robot {

    private Terrain terrain;
    private Point curr;
    private Direction facing;

    Robot(Terrain t) {
        this.terrain = t;
    }

    public boolean isPlaced() {
        if (terrain == null || curr == null || facing == null) {
            return false;
        }
        return curr.getX() != Point.VOID && curr.getY() != Point.VOID;
    }


}
