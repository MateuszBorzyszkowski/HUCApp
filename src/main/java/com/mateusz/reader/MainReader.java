package com.mateusz.reader;

import com.mateusz.enums.ReaderOption;
import com.mateusz.exception.CommandNotRecognizedException;
import com.mateusz.exception.CountOfCommandsIsInvalidException;
import com.mateusz.exception.NameInDatabaseAlreadyExistException;
import com.mateusz.exception.NameToRemoveNotExistInDatabaseException;
import com.mateusz.reader.parser.ReaderParser;
import com.mateusz.reader.validator.ReaderValidator;

import java.util.*;

public class MainReader {
    private static MainReader instance = null;
    private final ReaderValidator readerValidator = ReaderValidator.getInstance();
    private final ReaderParser readerParser = ReaderParser.getInstance();
    private final ActionReader actionReader = ActionReader.getInstance();

    private MainReader() {
    }

    public static MainReader getInstance() {
        if (instance == null) {
            instance = new MainReader();
        }
        return instance;
    }

    public boolean initMainCommand(String command) {
        ArrayList<String> parseCommand = readerParser.splitCommand(command, "\\s");

        if (parseCommand.get(0).equals("exit")) {
            return false;
        } else {
            readCommand(parseCommand);
            return true;
        }
    }

    public void readCommand(ArrayList<String> command) {

        try {
            switch (command.get(0)) {
                case "add":
                    runCommand(command, ReaderOption.ADD);
                    break;
                case "remove":
                    runCommand(command, ReaderOption.REMOVE);
                    break;
                case "show":
                    runCommand(command, ReaderOption.SHOW);
                    break;
                case "help":
                    System.out.println("Help");
                    break;
                default:
                    throw new CommandNotRecognizedException("Command '" + command.get(0) + "' not recognized. Type 'help' command to more information.");
            }
        } catch (CommandNotRecognizedException e) {
            e.printStackTrace();
        } catch (NameToRemoveNotExistInDatabaseException e) {
            e.printStackTrace();
        } catch (NameInDatabaseAlreadyExistException e) {
            e.printStackTrace();
        }
    }

    private void runCommand(ArrayList<String> command, ReaderOption option) throws CommandNotRecognizedException, NameToRemoveNotExistInDatabaseException, NameInDatabaseAlreadyExistException {
        command.remove(0);

        if (readerValidator.readerValidate(command.size(), option, command.get(0))) {
            actionReader.initActionCommand(command, option);
        }
    }
}
