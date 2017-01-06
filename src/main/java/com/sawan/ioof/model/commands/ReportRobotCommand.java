package com.sawan.ioof.model.commands;

import com.sawan.ioof.model.Robot;

public class ReportRobotCommand extends RobotCommand {

    public void execute(Robot robot){
        robot.report();
    }

}
