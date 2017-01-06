package com.sawan.ioof.model;

public class TableTopTerrain extends Terrain{

    private int width;
    private int height;

    TableTopTerrain(int w, int h) {
        width = w;
        height = h;
    }

    public boolean isWithinBounds(Point p) {
        return p.getX() >= 0 && p.getX() < width &&
               p.getY() >= 0 && p.getY() < height;
    }
}
