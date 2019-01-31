package com.example.next;

import java.util.ArrayList;
import java.util.Scanner;

public class New {
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.run();
    }
}

class Menu {
    private ArrayList<Task> tasks;
    private ArrayList<Task> doneTasks;
    private Scanner scanner;

    Menu() {
        this.doneTasks = new ArrayList<>();
        this.tasks = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    void run(){
        while (true){
            int option = showSelf();

            if (option==0)
                continue;
            if (option==6)
                break;

            switch (option){
                case 1:
                    this.showPendingTasks();
                    break;
                case 2:
                    this.showDoneTasks();
                    break;
                case 3:
                    this.createTask();
                    break;
                case 4:
                    int result = this.markTaskDone();
                    if (result == 0){
                        System.out.println("You've entered wrong value for the task number, it doesn't exist in the tasks");
                    }
                    break;
                case 5:
                    result = this.deleteTask();
                    if (result == 0){
                        System.out.println("You've entered wrong value for the deleting, it doesn't exist in the tasks");
                    }
                    break;
            }
        }
        System.out.println("Thanks for using!");
    }

    private int showSelf(){
        System.out.println("Following options: 1 - show pending tasks, 2 - show done tasks, 3 - create task, " +
                "4 - mark task as done, 5 - delete task for pending, 6 - exit");
        int choice = this.scanner.nextInt();
        int[] possibleChoices = {1, 2, 3, 4, 5, 6};
        boolean contains = false;

        for (int possibleChoice : possibleChoices) {
            if (possibleChoice == choice) {
                contains = true;
            }
        }

        if (!contains)
            return 0;
        return choice;
    }

    private void showPendingTasks(){
        System.out.println("These are tasks that are to be done:");
        for (Task task: this.tasks){
            task.showSelf();
        }
    }

    private void showDoneTasks(){
        System.out.println("These are the tasks that you already done:");
        for (Task task: this.doneTasks){
            task.showSelf();
        }
    }

    private void createTask(){
        System.out.println("Print the text for the task");
        this.scanner.nextLine();
        String text = this.scanner.nextLine();

        Task task = new Task(text);
        this.tasks.add(task);
        System.out.println("Task is created");
    }

    private int markTaskDone(){
        System.out.println("Enter the number of the task to be mark as done");
        int choice = this.scanner.nextInt() - 1;
        if (choice >= this.tasks.size()){
            return 0;
        }

        Task t = this.tasks.get(choice);
        t.isDone = true;
        this.tasks.remove(choice);
        this.doneTasks.add(t);

        System.out.println("Task is marked as done!");
        return 1;
    }

    private int deleteTask(){
        System.out.println("Enter the number of the task to be deleted");
        int choice = this.scanner.nextInt() - 1;

        if (choice >= this.tasks.size()){
            return 0;
        }

        this.tasks.remove(choice);
        System.out.println("Task is deleted from the pending list");
        return 1;
    }
}

class Task{
    boolean isDone;
    private String text;

    Task(String text) {
        this.isDone = false;
        this.text = text;
    }

    void showSelf() {
        System.out.println(this.text);
    }

    void showSelf(int num) {
        System.out.println(num + " " + this.text);
    }
}
