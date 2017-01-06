package com.sawan.ioof.model;

public enum Direction {
    EAST("E"), WEST("W"), NORTH("N"), SOUTH("S");

    private String name;

    Direction(String s){
        this.name = s;
    }

    public static Direction getRightOf(Direction d) {
        switch (d) {
            case EAST:  return SOUTH;
            case WEST:  return NORTH;
            case NORTH: return EAST;
            case SOUTH: return WEST;
            default: throw new IllegalArgumentException("Unknown direction.");
        }
    }

    public static Direction getLeftOf(Direction d) {
        switch (d) {
            case EAST:  return NORTH;
            case WEST:  return SOUTH;
            case NORTH: return WEST;
            case SOUTH: return EAST;
            default: throw new IllegalArgumentException("Unknown direction.");
        }
    }
}
