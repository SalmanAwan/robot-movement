package com.sawan.ioof.helper

class TestHelper {

    static COMMANDS_FILE_PATH = 'src/test/resources/test-commands.txt'

    public static List<String> readRawRows() {
        File commandsFile = new File(COMMANDS_FILE_PATH)
        assert(commandsFile.exists())
        def rows = commandsFile.readLines()
        return rows
    }

}
