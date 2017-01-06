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

    public void move() {
        if(!isPlaced()) { return; }

        int x = this.point.getX();
        int y = this.point.getY();
        switch (direction) {
            case EAST:  y += 1; break;
            case WEST:  y -= 1; break;
            case NORTH: x += 1; break;
            case SOUTH: x -= 1; break;
        }
        Point newPos = new Point(x, y);
        if(terrain.isWithinBounds(newPos)) {
            this.point = newPos;
        }
    }

    public void turnRight() {
        if(!isPlaced()) { return; }
        this.direction = Direction.getRightOf(this.direction);
    }

    public void turnLeft() {
        if(!isPlaced()) { return; }
        this.direction = Direction.getLeftOf(this.direction);
    }

}
