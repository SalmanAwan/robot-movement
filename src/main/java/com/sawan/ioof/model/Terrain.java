package com.sawan.ioof.model;

abstract class Terrain {
    private int width;
    private int height;

    Terrain(int w, int h) {
        this.width = w;
        this.height = h;
    }

    public int getWidth() { return width; }

    public int getHeight() { return height; }

    public void setWidth(int w) { this.width = w; }

    public void setHeight(int h) { this.height = h; }

    abstract public boolean isWithinBounds(Point p);
}
