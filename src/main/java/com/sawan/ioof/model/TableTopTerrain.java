package com.sawan.ioof.model;

public class TableTopTerrain extends Terrain{

    private int width;
    private int height;

    TableTopTerrain(int w, int h) {
        width = w;
        height = h;
    }

    public boolean isWithinBounds(int i, int j) {
        return i >= 0 && i < width && j >= 0 && j < height;
    }
}
