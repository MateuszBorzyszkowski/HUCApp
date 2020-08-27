package com.mateusz.reader.parser;

import java.util.ArrayList;
import java.util.Arrays;

public class ReaderParser {
    private static ReaderParser instance = null;

    private ReaderParser() {
    }

    public static ReaderParser getInstance() {
        if (instance == null) {
            instance = new ReaderParser();
        }
        return instance;
    }

    public ArrayList<String> initParser(String command) {
        String[] splitCommand = command.split("\\s");
        ArrayList<String> parseCommand = new ArrayList<String>(Arrays.asList(splitCommand));

        return parseCommand;
    }

}
