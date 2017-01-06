package com.sawan.ioof.model;

/**
 * Provides orientation support and facilates
 * anti/clcokwise rotation of objects on cardinal scale
 *
 * NOTE: In favour of better coverage if-else are
 * preffered over switch due to default statement
 */
public enum Direction {

    EAST, WEST, NORTH, SOUTH;

    /**
     * Determine cardinal direction on the right
     * @param d current direction
     * @return direction on the right
     */
    public static Direction getRightOf(Direction d) {
        if (d.equals(EAST))       { return SOUTH; }
        else if (d.equals(WEST))  { return NORTH; }
        else if (d.equals(NORTH)) { return EAST;  }
        else { return WEST; }
    }

    /**
     * Determine cardinal direction on the left
     * @param d current direction
     * @return direction on the left
     */
    public static Direction getLeftOf(Direction d) {
        if (d.equals(EAST))       { return NORTH; }
        else if (d.equals(WEST))  { return SOUTH; }
        else if (d.equals(NORTH)) { return WEST;  }
        else { return EAST; }
    }
}
