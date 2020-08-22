package com.mateusz.reader;

import org.junit.Assert;
import org.junit.Test;

public class MainReaderTest {

    // Valid command
    @Test
    public void testVendorAddCommandValid() {
        String command = "add vendor -n test_name -u test_utility";

        MainReader mainReader = MainReader.getInstance();
        boolean excepted = mainReader.initMainCommand(command);

        Assert.assertTrue(excepted);
    }

    @Test
    public void testVendorRemoveCommandValid() {
        String command = "remove vendor -n test_name";

        MainReader mainReader = MainReader.getInstance();
        boolean excepted = mainReader.initMainCommand(command);

        Assert.assertTrue(excepted);
    }

    @Test
    public void testVendorShowCommandValid() {
        String command = "show vendor";

        MainReader mainReader = MainReader.getInstance();
        boolean excepted = mainReader.initMainCommand(command);

        Assert.assertTrue(excepted);
    }

    // Invalid command for ADD
    @Test
    public void testOneVendorAddCommandInvalid() {
        String command = "add vendor -n test_name";

        MainReader mainReader = MainReader.getInstance();
        boolean excepted = mainReader.initMainCommand(command);

        Assert.assertFalse(excepted);
    }

    @Test
    public void testTwoVendorAddCommandInvalid() {
        String command = "add vendor -n";

        MainReader mainReader = MainReader.getInstance();
        boolean excepted = mainReader.initMainCommand(command);

        Assert.assertFalse(excepted);
    }

    @Test
    public void testThreeVendorAddCommandInvalid() {
        String command = "add vendor";

        MainReader mainReader = MainReader.getInstance();
        boolean excepted = mainReader.initMainCommand(command);

        Assert.assertFalse(excepted);
    }

    @Test
    public void testFourVendorAddCommandInvalid() {
        String command = "add vendor -n test_name -u";

        MainReader mainReader = MainReader.getInstance();
        boolean excepted = mainReader.initMainCommand(command);

        Assert.assertFalse(excepted);
    }

    // Invalid command for REMOVE
    @Test
    public void testOneVendorRemoveCommandInvalid() {
        String command = "remove vendor -n";

        MainReader mainReader = MainReader.getInstance();
        boolean excepted = mainReader.initMainCommand(command);

        Assert.assertFalse(excepted);
    }

    @Test
    public void testTwoVendorRemoveCommandInvalid() {
        String command = "remove vendor";

        MainReader mainReader = MainReader.getInstance();
        boolean excepted = mainReader.initMainCommand(command);

        Assert.assertFalse(excepted);
    }

    // Invalid command for SHOW
    @Test
    public void testOneVendorShowCommandInvalid() {
        String command = "show vendor -n";

        MainReader mainReader = MainReader.getInstance();
        boolean excepted = mainReader.initMainCommand(command);

        Assert.assertFalse(excepted);
    }

    @Test
    public void testTwoVendorShowCommandInvalid() {
        String command = "show";

        MainReader mainReader = MainReader.getInstance();
        boolean excepted = mainReader.initMainCommand(command);

        Assert.assertFalse(excepted);
    }

}
