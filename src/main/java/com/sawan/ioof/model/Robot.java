package com.sawan.ioof.model;

import com.sawan.ioof.model.terrains.Terrain;

import static com.sawan.ioof.model.Direction.*;

/**
 * Exposes public api for a robot
 */
public class Robot {

    private Terrain terrain;
    private Point point;
    private Direction direction;

    public Robot(Terrain t) {
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

        // Avoiding switch for better coverage
        if(direction.equals(EAST))  { x += 1; }
        if(direction.equals(WEST))  { x -= 1; }
        if(direction.equals(NORTH)) { y += 1; }
        if(direction.equals(SOUTH)) { y -= 1; }

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

    public void report() {
        if(!isPlaced()) { return; }
        System.out.println(toString());
    }

    @Override
    public String toString(){
        return String.format("%s,%s", point.toString(), direction.toString());
    }

}
