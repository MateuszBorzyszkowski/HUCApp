package com.mateusz;

import com.mateusz.reader.MainReader;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MainReader mainReader = MainReader.getInstance();
        Scanner scanner = new Scanner(System.in);
        boolean appOn = true;

        while (appOn) {
            String str = scanner.nextLine();
            appOn = mainReader.initMainCommand(str);
        }
    }
}
