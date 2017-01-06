package com.sawan.ioof.services;

import com.sawan.ioof.commands.*;

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
        if(line.matches(RobotCommand.PLACE_REGEX))  { return Optional.of(new PlaceRobotCommand());  }
        if(line.matches(RobotCommand.MOVE_REGEX))   { return Optional.of(new MoveRobotCommand());   }
        if(line.matches(RobotCommand.LEFT_REGEX))   { return Optional.of(new LeftRobotCommand());   }
        if(line.matches(RobotCommand.RIGHT_REGEX))  { return Optional.of(new RightRobotCommand());  }
        if(line.matches(RobotCommand.REPORT_REGEX)) { return Optional.of(new ReportRobotCommand()); }
        return Optional.empty();
    }

}
