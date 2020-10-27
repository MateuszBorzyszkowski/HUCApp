package com.mateusz.reader.parser;

import com.mateusz.model.Place;

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

    public ArrayList<String> splitCommand(String command, String regex) {
        String[] splitCommand = command.split(regex);

        return new ArrayList<String>(Arrays.asList(splitCommand));
    }

    public Place splitAddress(Place place, String command) {
        ArrayList<String> splitCommand = splitCommand(command, "\\s");

        place.setStreet(splitCommand.get(0));
        splitCommand.remove(0);
        place.setHomeNumber(splitCommand.get(0));

        return place;
    }
}
