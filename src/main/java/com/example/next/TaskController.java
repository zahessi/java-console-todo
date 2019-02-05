package com.example.next;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TaskController {
    private Task taskModel;
    private DBcon connection;
    private UserInputHandler scanner;

    public TaskController(DBcon connection) {
        this.connection = connection;
        this.taskModel = new Task(connection);
        this.scanner = new UserInputHandler();
    }

    public void createTask() {
        System.out.println("Print the text for the task");

        this.taskModel.addTask(this.scanner.getString());
        System.out.println("Task is created");
    }

    public void showPendingTasks(){
        System.out.println("Printing pending tasks");
        ResultSet result = taskModel.showTasks("0");
        printTasks(result);
    }

    public void showDoneTasks(){
        System.out.println("Printing done tasks");
        ResultSet result = taskModel.showTasks("1");
        printTasks(result);
    }

    public void markTaskDone(){
        System.out.println("Enter the number of the task");
        taskModel.markTaskDone(this.scanner.getInt());
        System.out.println("Success!");
    }

    public void deleteTask(){
        System.out.println("Enter the number of the task");
        taskModel.deleteTask(this.scanner.getInt());
        System.out.println("All done!");
    }

    private void printTasks(ResultSet result){
        try{
            while (result.next()){
                System.out.println(
                        result.getInt("id") + " \"" + result.getString("name") + "\""
                );
            }
        } catch (SQLException e){
            System.out.println(e);
        }
    }
}
