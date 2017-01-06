package com.sawan.ioof;

import com.sawan.ioof.model.Robot;
import com.sawan.ioof.model.commands.RobotCommand;
import com.sawan.ioof.model.terrains.TableTopTerrain;
import com.sawan.ioof.model.terrains.Terrain;
import com.sawan.ioof.services.CommandsService;

public class Application {

    static final String DEFAULT_PATH = "src/main/resources/commands.txt";

    public static void main(String args[]) {

        CommandsService commandsService = new CommandsService(getFilePath(args));
        Terrain terrain = new TableTopTerrain(5, 5);
        Robot robot = new Robot(terrain);

        for (RobotCommand rc : commandsService.getRobotCommands()) {
            rc.execute(robot);
        }

    }

    private static String getFilePath(String args[]) {
        return args.length > 0 && args[0] != null ? args[0] : DEFAULT_PATH;
    }

}
