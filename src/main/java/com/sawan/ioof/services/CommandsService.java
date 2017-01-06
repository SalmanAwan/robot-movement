package com.sawan.ioof.services;

import com.sawan.ioof.model.Direction;
import com.sawan.ioof.model.Point;
import com.sawan.ioof.model.commands.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CommandsService {

    FileService fileService;

    public List<RobotCommand> robotCommands = new ArrayList<>();

    public CommandsService(String fileName) {
        fileService = new FileService(fileName);

        List<String> lines = fileService.getLines();

        robotCommands = lines.stream()
                .map(CommandsService::CommandFactory)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }

    public List<RobotCommand> getRobotCommands() {
        return this.robotCommands;
    }

    private static Optional<RobotCommand> CommandFactory(String line) {
        if(line.matches(RobotCommand.PLACE_REGEX))  { return placeCommandFactory(line); }
        if(line.matches(RobotCommand.MOVE_REGEX))   { return Optional.of(new MoveRobotCommand());   }
        if(line.matches(RobotCommand.LEFT_REGEX))   { return Optional.of(new LeftRobotCommand());   }
        if(line.matches(RobotCommand.RIGHT_REGEX))  { return Optional.of(new RightRobotCommand());  }
        if(line.matches(RobotCommand.REPORT_REGEX)) { return Optional.of(new ReportRobotCommand()); }
        return Optional.empty();
    }

    private static Optional<RobotCommand> placeCommandFactory(String line) {
        try {
            String[] commandTokens = line.trim().split("\\s");
            String[] positionTokens = commandTokens[1].trim().split(",");

            Point p = new Point(new Integer(positionTokens[0]), new Integer(positionTokens[1]));
            Direction d = Direction.valueOf(positionTokens[2]);

            return Optional.of(new PlaceRobotCommand(p, d));
        } catch (Exception e) {
            return Optional.empty();
        }
    }

}
