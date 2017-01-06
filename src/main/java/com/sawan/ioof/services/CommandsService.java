package com.sawan.ioof.services;

import com.sawan.ioof.commands.Command;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CommandsService {

    FileService fileService;

    public List<Command> commands = new ArrayList<>();

    public CommandsService(String fileName) {
        fileService = new FileService(fileName);

        List<String> lines = fileService.getLines();

        commands = lines.stream()
                .map(CommandsService::CommandFactory)
                .collect(Collectors.toList());
    }

    public List<Command> getCommands() {
        return this.commands;
    }

    private static Command CommandFactory(String line) {
        return new Command();
    }

}
