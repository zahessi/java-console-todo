package com.example.next;

import java.sql.*;

public class DBcon {
    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    DBcon() throws SQLException{
        this.connection = DriverManager.getConnection
                ("jdbc:mariadb://localhost:3306/java", "dev", "eeyore_api");
        createTables();
    }

    private void createTables() throws SQLException{
        String sql = " create table if not exists tasks (id integer auto_increment, " +
                "name varchar(100), is_done tinyint, primary key(id))";
        statement.execute(sql);
    }

    void addTask(String name) throws SQLException{
        try{
            preparedStatement = this.connection.prepareStatement("insert into tasks (name, is_done) values (?, 0);");
            preparedStatement.setString(1, name);
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            System.out.println(e);
        }
    }

    void markTaskDone(Integer id){

    }

    ResultSet getDoneTasks() throws SQLException{
        ResultSet result = statement.executeQuery("select * from tasks where is_done = 1");
        return result;
    }

    ResultSet getPendingTasks() throws SQLException{
        ResultSet result = statement.executeQuery("select * from tasks where is_done = 0");
        return result;
    }

    void deleteTask(){}


}