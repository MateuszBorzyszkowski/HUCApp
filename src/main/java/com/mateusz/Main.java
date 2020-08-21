package com.mateusz;

import com.mateusz.reader.MainReader;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MainReader mainReader = MainReader.getInstance();
        Scanner scanner = new Scanner(System.in);
        boolean appOn = true;

        while (appOn) {
            System.out.print(">> ");
            String str = scanner.nextLine();
            appOn = mainReader.readCommand(str);
        }
    }
}
