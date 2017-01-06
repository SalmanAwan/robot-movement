package com.sawan.ioof.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class FileService {

    private List<String> lines = new ArrayList<>();

    public FileService(String fileName) {
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            stream.forEach(lines::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> getLines() {
        return this.lines;
    }

}
