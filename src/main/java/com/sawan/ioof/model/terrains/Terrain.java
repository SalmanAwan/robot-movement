package com.sawan.ioof.model.terrains;

import com.sawan.ioof.model.Point;

public abstract class Terrain {
    private int width;
    private int height;

    Terrain(int w, int h) {
        this.width = w;
        this.height = h;
    }

    public int getWidth() { return width; }

    public int getHeight() { return height; }

    abstract public boolean isWithinBounds(Point p);
}
