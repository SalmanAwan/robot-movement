package com.sawan.ioof.model;

/**
 * Represents position on a two dimensional plane
 */
public class Point {

    public static final int VOID = -1;

    private int x;
    private int y;

    public Point() {
        x = VOID;
        y = VOID;
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() { return this.x; }

    public int getY() { return this.y; }

    @Override
    public String toString() {
        return String.format("%d,%d", x, y);
    }

}
