package com.sawan.ioof.model;

import com.sawan.ioof.model.terrains.Terrain;

public class Robot {

    private Terrain terrain;
    private Point point;
    private Direction direction;

    Robot(Terrain t) {
        this.terrain = t;
    }

    public boolean isPlaced() {
        if (terrain == null || point == null || direction == null) {
            return false;
        }
        return terrain.isWithinBounds(point);
    }

    public void place(Point p, Direction d) {
        if(p == null || d == null || !terrain.isWithinBounds(p)) {
            throw new IllegalArgumentException("Placement params are not valid!");
        }
        point = p;
        direction = d;
    }
}
