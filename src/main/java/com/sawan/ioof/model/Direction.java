package com.sawan.ioof.model;

public enum Direction {
    EAST("E"), WEST("W"), NORTH("N"), SOUTH("S");

    private String name;

    Direction(String s){
        this.name = s;
    }

}
