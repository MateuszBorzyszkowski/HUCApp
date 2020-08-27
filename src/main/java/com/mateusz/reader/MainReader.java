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
        ArrayList<String> parseCommand = readerParser.initParser(command);

        if (parseCommand.get(0).equals("exit")) {
            return false;
        } else {
            readCommand(parseCommand);
            return true;
        }
    }

    public boolean readCommand(ArrayList<String> command) {

        try {
            if (readerValidator.readerValidate(command.size(), command.get(0))) {
                switch (command.get(0)) {
                    case "add":
                        return runCommand(command, ReaderOption.ADD);
                    case "remove":
                        return runCommand(command, ReaderOption.REMOVE);
                    case "show":
                        return runCommand(command, ReaderOption.SHOW);
                    case "help":
                        System.out.println("Help");
                        return true;
                    default:
                        throw new CommandNotRecognizedException("Command '" + command.get(0) + "' not recognized. Type 'help' command to more information.");
                }
            } else {
                throw new CountOfCommandsIsInvalidException("Number of commands is invalid! Type 'help' command to more information.");
            }
        } catch (CommandNotRecognizedException e) {
            e.printStackTrace();
        } catch (CountOfCommandsIsInvalidException e) {
            e.printStackTrace();
        } catch (NameToRemoveNotExistInDatabaseException e) {
            e.printStackTrace();
        } catch (NameInDatabaseAlreadyExistException e) {
            e.printStackTrace();
        }
        return false;
    }

    private boolean runCommand(ArrayList<String> command, ReaderOption option) throws CommandNotRecognizedException, CountOfCommandsIsInvalidException, NameToRemoveNotExistInDatabaseException, NameInDatabaseAlreadyExistException {
        command.remove(0);

        if (readerValidator.readerValidate(command.size(), option, command.get(0))) {
            switch (command.get(0)) {
                case "vendor":
                case "place":
                    return actionReader.initActionCommand(command, option);
                default:
                    throw new CommandNotRecognizedException("Command '" + command.get(0) + "' for 'add' option not recognized! Type 'help' command to more information.");
            }
        } else {
            throw new CountOfCommandsIsInvalidException("Number of commands is invalid! Type 'help' command to more information.");
        }

    }
}
