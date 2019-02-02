package com.example.next;

import java.sql.SQLException;

class Task{
    boolean isDone;
    private String text;
    private DBcon con;

    Task(DBcon con) throws SQLException {
        this.con = con;
        con.addTask(text);
    }

    void createTask(String text){
        this.con.addTask(text);
    }

    void showSelf() {
        System.out.println(this.text);
    }

    void showSelf(int num) {
        System.out.println(num + " " + this.text);
    }
}
