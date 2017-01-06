package com.sawan.ioof.model.commands;

import com.sawan.ioof.model.Robot;

public class MoveRobotCommand extends RobotCommand {

    public void execute(Robot robot){
        robot.move();
    }

}
