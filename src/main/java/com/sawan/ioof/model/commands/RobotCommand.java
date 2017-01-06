package com.sawan.ioof.model.commands;

import com.sawan.ioof.model.Robot;

public abstract class RobotCommand {

    public static final String PLACE_REGEX  = "^(PLACE)\\s(\\d),(\\d),(EAST|WEST|NORTH|SOUTH)$";
    public static final String MOVE_REGEX   = "^MOVE$";
    public static final String LEFT_REGEX   = "^LEFT$";
    public static final String RIGHT_REGEX  = "^RIGHT$";
    public static final String REPORT_REGEX = "^REPORT$";

    public abstract void execute(Robot robot);

}
