package com.sawan.ioof.model.commands;

import com.sawan.ioof.model.Direction;
import com.sawan.ioof.model.Point;
import com.sawan.ioof.model.Robot;

public class PlaceRobotCommand extends RobotCommand {

    private final Point NEW_POINT;
    private final Direction NEW_DIRECTION;

    public PlaceRobotCommand(Point p, Direction d) {
        this.NEW_POINT     = p;
        this.NEW_DIRECTION = d;
    }

    public void execute(Robot robot) {
        robot.place(NEW_POINT, NEW_DIRECTION);
    }

}
