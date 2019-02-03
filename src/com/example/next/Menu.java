package com.example.next;

class Menu {
    //    контроллер тасок
    private UserInputHandler scanner;
    private TaskController taskController;
    private DBcon connection;

    Menu() {
        this.scanner = new UserInputHandler();
        this.connection = new DBcon();
        this.taskController = new TaskController(this.connection);
    }

    public void run() {
        while (true) {
            int option = showMenu();

            if (option == 6)
                break;

            switch (option) {
                case 0:
                    continue;
                case 1:
                    this.taskController.createTask();
                    break;
                case 2:
                    this.taskController.showPendingTasks();
                    break;
                case 3:
                    this.taskController.showDoneTasks();
                    break;
                case 4:
                    this.taskController.markTaskDone();
                    break;
                case 5:
                    this.taskController.deleteTask();
                    break;
            }
        }
        System.out.println("Thanks for using!");
    }

    private int showMenu() {
        System.out.println("Following options: 1 - create task, 2 - show pending tasks, 3 - show done tasks, " +
                "4 - mark task as done, 5 - delete task from pending, 6 - exit");
        int choice = this.scanner.getInt();
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
}