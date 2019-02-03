package com.example.next;

import java.sql.*;

public class DBcon {
//    соединение к бд + выполнение запросов
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet = null;

    public DBcon(){
        try{
            this.connection = DriverManager.getConnection
                    ("jdbc:mariadb://localhost:3306/java", "dev", "eeyore_api");
            createTables();
            System.out.println("tables created");
        } catch (SQLException e){
            System.out.println(e);
        }
    }

    private void createTables(){
        try{
            String sql = " create table if not exists tasks (id integer auto_increment, " +
                    "name varchar(100), is_done tinyint, primary key(id))";
            this.statement = this.connection.createStatement();
            this.statement.execute(sql);
        } catch (SQLException e){
            System.out.println(e);
        }
    }

    public PreparedStatement createQuery(String text){
        PreparedStatement query = null;
        try {
            query = this.connection.prepareStatement(text);
        } catch (SQLException e){
            System.out.println(e);
        }
        return query;
    }

    public Statement createStatement(){
        Statement query = null;
        try {
            query = this.connection.createStatement();
        } catch (SQLException e){
            System.out.println(e);
        }
        return query;
    }

    ResultSet getDoneTasks(){
        ResultSet result = null;
        try{
            result = statement.executeQuery("select * from tasks where is_done = 1");
        } catch (SQLException e){
            System.out.println(e);
        }
        return result;
    }

//    ResultSet getPendingTasks(){
//        ResultSet result = statement.executeQuery("select * from tasks where is_done = 0");
//        return result;
//    }

    void deleteTask(){}


}