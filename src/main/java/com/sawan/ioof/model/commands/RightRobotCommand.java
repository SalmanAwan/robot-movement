package com.sawan.ioof.model.commands;

import com.sawan.ioof.model.Robot;

public class RightRobotCommand extends RobotCommand {

    public void execute(Robot robot){
        validateRobot();
    }

}
