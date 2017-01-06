package com.sawan.ioof.commands;

public class PlaceRobotCommand extends RobotCommand {

    public void execute(){
        if(getRobot() == null) {
            throw new IllegalStateException("Command executed when no robot set");
        }
    }

}
