package com.mateusz.reader;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class MainReaderTest {

    // Valid command
    @Test
    public void testVendorAddCommandValid() {
        String command = "add vendor -n test_name -u test_utility";
        String[] splitCommand = command.split("\\s");
        ArrayList<String> parseCommand = new ArrayList<String>(Arrays.asList(splitCommand));

        MainReader mainReader = MainReader.getInstance();
        boolean excepted = mainReader.readCommand(parseCommand);

        Assert.assertTrue(excepted);
    }

    @Test
    public void testVendorRemoveCommandValid() {
        String command = "remove vendor -n test_name";
        String[] splitCommand = command.split("\\s");
        ArrayList<String> parseCommand = new ArrayList<String>(Arrays.asList(splitCommand));

        MainReader mainReader = MainReader.getInstance();
        boolean excepted = mainReader.readCommand(parseCommand);

        Assert.assertTrue(excepted);
    }

    @Test
    public void testVendorShowCommandValid() {
        String command = "show vendor";
        String[] splitCommand = command.split("\\s");
        ArrayList<String> parseCommand = new ArrayList<String>(Arrays.asList(splitCommand));

        MainReader mainReader = MainReader.getInstance();
        boolean excepted = mainReader.readCommand(parseCommand);

        Assert.assertTrue(excepted);
    }

    // Invalid command for ADD
    @Test
    public void testOneVendorAddCommandInvalid() {
        String command = "add vendor -n test_name";
        String[] splitCommand = command.split("\\s");
        ArrayList<String> parseCommand = new ArrayList<String>(Arrays.asList(splitCommand));

        MainReader mainReader = MainReader.getInstance();
        boolean excepted = mainReader.readCommand(parseCommand);

        Assert.assertFalse(excepted);
    }

    @Test
    public void testTwoVendorAddCommandInvalid() {
        String command = "add vendor -n";
        String[] splitCommand = command.split("\\s");
        ArrayList<String> parseCommand = new ArrayList<String>(Arrays.asList(splitCommand));

        MainReader mainReader = MainReader.getInstance();
        boolean excepted = mainReader.readCommand(parseCommand);

        Assert.assertFalse(excepted);
    }

    @Test
    public void testThreeVendorAddCommandInvalid() {
        String command = "add vendor";
        String[] splitCommand = command.split("\\s");
        ArrayList<String> parseCommand = new ArrayList<String>(Arrays.asList(splitCommand));

        MainReader mainReader = MainReader.getInstance();
        boolean excepted = mainReader.readCommand(parseCommand);

        Assert.assertFalse(excepted);
    }

    @Test
    public void testFourVendorAddCommandInvalid() {
        String command = "add vendor -n test_name -u";
        String[] splitCommand = command.split("\\s");
        ArrayList<String> parseCommand = new ArrayList<String>(Arrays.asList(splitCommand));

        MainReader mainReader = MainReader.getInstance();
        boolean excepted = mainReader.readCommand(parseCommand);

        Assert.assertFalse(excepted);
    }

    // Invalid command for REMOVE
    @Test
    public void testOneVendorRemoveCommandInvalid() {
        String command = "remove vendor -n";
        String[] splitCommand = command.split("\\s");
        ArrayList<String> parseCommand = new ArrayList<String>(Arrays.asList(splitCommand));

        MainReader mainReader = MainReader.getInstance();
        boolean excepted = mainReader.readCommand(parseCommand);

        Assert.assertFalse(excepted);
    }

    @Test
    public void testTwoVendorRemoveCommandInvalid() {
        String command = "remove vendor";
        String[] splitCommand = command.split("\\s");
        ArrayList<String> parseCommand = new ArrayList<String>(Arrays.asList(splitCommand));

        MainReader mainReader = MainReader.getInstance();
        boolean excepted = mainReader.readCommand(parseCommand);

        Assert.assertFalse(excepted);
    }

    // Invalid command for SHOW
    @Test
    public void testOneVendorShowCommandInvalid() {
        String command = "show vendor -n";
        String[] splitCommand = command.split("\\s");
        ArrayList<String> parseCommand = new ArrayList<String>(Arrays.asList(splitCommand));

        MainReader mainReader = MainReader.getInstance();
        boolean excepted = mainReader.readCommand(parseCommand);

        Assert.assertFalse(excepted);
    }

    @Test
    public void testTwoVendorShowCommandInvalid() {
        String command = "show";
        String[] splitCommand = command.split("\\s");
        ArrayList<String> parseCommand = new ArrayList<String>(Arrays.asList(splitCommand));

        MainReader mainReader = MainReader.getInstance();
        boolean excepted = mainReader.readCommand(parseCommand);

        Assert.assertFalse(excepted);
    }
}