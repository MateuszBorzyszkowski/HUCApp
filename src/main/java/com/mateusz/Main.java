package com.mateusz;

import com.mateusz.reader.Reader;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Reader reader = Reader.getInstance();
        Scanner scanner = new Scanner(System.in);
        boolean appOn = true;

        while (appOn) {
            System.out.print(">> ");
            String str = scanner.nextLine();
            appOn = reader.readCommand(str);
        }
    }
}
