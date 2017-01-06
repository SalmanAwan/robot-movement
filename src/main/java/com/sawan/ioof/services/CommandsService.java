package com.sawan.ioof.services;

import com.sawan.ioof.model.Direction;
import com.sawan.ioof.model.Point;
import com.sawan.ioof.model.commands.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.sawan.ioof.model.commands.RobotCommand.*;

/**
 * Takes a file name and generates list of robot commands
 * abstracting away commands factory method from clients while
 * delegating low level file manipulation to {@code FileService}
 */
public class CommandsService {

    FileService fileService;

    public List<RobotCommand> robotCommands = new ArrayList<>();

    /**
     * Populate {@code RobotCommand} instances from file
     * @param fileName name of the file to read
     */
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
        if (line.matches(PLACE_REGEX))  { return placeCommandFactory(line);             }
        if (line.matches(MOVE_REGEX))   { return Optional.of(new MoveRobotCommand());   }
        if (line.matches(LEFT_REGEX))   { return Optional.of(new LeftRobotCommand());   }
        if (line.matches(RIGHT_REGEX))  { return Optional.of(new RightRobotCommand());  }
        if (line.matches(REPORT_REGEX)) { return Optional.of(new ReportRobotCommand()); }
        return Optional.empty();
    }

    private static Optional<RobotCommand> placeCommandFactory(String line) {
        String[] commandTokens = line.trim().split("\\s");
        String[] positionTokens = commandTokens[1].trim().split(",");

        Point p = new Point(new Integer(positionTokens[0]), new Integer(positionTokens[1]));
        Direction d = Direction.valueOf(positionTokens[2]);

        return Optional.of(new PlaceRobotCommand(p, d));
    }

}
