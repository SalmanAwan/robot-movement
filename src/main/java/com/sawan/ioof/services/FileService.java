package com.sawan.ioof.services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileService {

    private List<String> lines = new ArrayList<>();

    public FileService(String fileName) {
        try {
            // For better coverage not using nio stream based lines reading
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Could not read robotCommands file");
        }
    }

    public List<String> getLines() {
        return this.lines;
    }

}
