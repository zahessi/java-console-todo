package com.example.next;

import java.util.Scanner;

public class UserInputHandler {

    private Scanner scanner;

    public UserInputHandler() {
        this.scanner = new Scanner(System.in);
    }

    public String getString() {
        return this.scanner.nextLine();
    }

    public int getInt() {
        return Integer.parseInt(this.scanner.nextLine());
    }
}
