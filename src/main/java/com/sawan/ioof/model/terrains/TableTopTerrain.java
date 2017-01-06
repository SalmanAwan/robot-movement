package com.sawan.ioof.model.terrains;

import com.sawan.ioof.model.Point;

public class TableTopTerrain extends Terrain{

    TableTopTerrain(int w, int h) {
        super(w, h);
    }

    @Override
    public boolean isWithinBounds(Point p) {
        return p.getX() >= 0 && p.getX() < getWidth() &&
               p.getY() >= 0 && p.getY() < getHeight();
    }
}
