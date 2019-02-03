package com.example.next;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

class Task {
    //    конструктор и обработчик запросов
    private DBcon con;

    Task(DBcon con) {
        this.con = con;
    }

    void addTask(String name) {
        try {
            PreparedStatement query = this.con.createQuery("insert into tasks (name, is_done) values (?, 0);");
            if (query != null) {
                query.setString(1, name);
                query.executeUpdate();
            } else
                System.out.println("An error occurred");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    ResultSet showTasks(String isDone) {
        ResultSet result = null;
        try {
            PreparedStatement query = this.con.createQuery("select * from tasks where is_done = ?;");
            if (query != null){
                query.setString(1, isDone);
                result = query.executeQuery();
            } else
                System.out.println("An error occured");
        } catch (SQLException e) {
            System.out.println(e);
        }
        return result;
    }

    void markTaskDone(Integer number) {
        try {
            PreparedStatement query = this.con.createQuery("update tasks set is_done = 1 where id = ?;");
            if ( query != null){
                query.setInt(1, number);
                query.executeUpdate();
            } else
                System.out.println("An error occurred");
        } catch (SQLException e){
            System.out.println(e);
        }
    }

    void deleteTask(Integer number){
        try {
            PreparedStatement query = this.con.createQuery("delete from tasks where id = ? and is_done = 0;");
            query.setInt(1, number);
            query.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
