package com.todo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
 
import com.todo.model.Task;
import com.todo.util.DButil;

public class TaskDAOImplementation implements TaskDAO {
 
    private Connection conn;
 
    public TaskDAOImplementation() {
        conn = DButil.getConnection();
    }
    /* (non-Javadoc)
     * @see com.todo.dao.TaskDAO#addTask(com.todo.model.Task)
     */
    @Override
    public void addTask( Task task ) {
        try {
            String query = "insert into task (taskName, taskDescription) values (?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement( query );
            preparedStatement.setString( 1, task.getTaskName() );
            preparedStatement.setString( 2, task.getTaskDescription() );
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /* (non-Javadoc)
     * @see com.todo.dao.TaskDAO#deleteTask(int)
     */
    @Override
    public void deleteTask( int taskId ) {
        try {
            String query = "delete from task where taskId=?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, taskId);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /* (non-Javadoc)
     * @see com.todo.dao.TaskDAO#updateTask(com.todo.model.Task)
     */
    @Override
    public void updateTask( Task task ) {
        try {
            String query = "update task set taskName=?, taskDescription=? where taskId=?";
            PreparedStatement preparedStatement = conn.prepareStatement( query );
            preparedStatement.setString( 1, task.getTaskName() );
            preparedStatement.setString( 2, task.getTaskDescription() );
            preparedStatement.setInt( 3, task.getTaskId() );
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /* (non-Javadoc)
     * @see com.todo.dao.TaskDAO#getAllTasks()
     */
    @Override
    public List<Task> getAllTasks() {
        List<Task> tasks = new ArrayList<Task>();
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery( "select * from task" );
            while( resultSet.next() ) {
                Task task = new Task();
                task.setTaskId( resultSet.getInt( "taskId" ) );
                task.setTaskName( resultSet.getString( "taskName" ) );
                task.setTaskDescription( resultSet.getString( "taskDescription" ) );
                task.setAddedOn( resultSet.getString( "addedOn" ) );
                tasks.add(task);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tasks;
    }
    /* (non-Javadoc)
     * @see com.todo.dao.TaskDAO#getTaskById(int)
     */
    @Override
    public Task getTaskById(int taskId) {
        Task task = new Task();
        try {
            String query = "select * from task where taskId=?";
            PreparedStatement preparedStatement = conn.prepareStatement( query );
            preparedStatement.setInt(1, taskId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while( resultSet.next() ) {
                task.setTaskId( resultSet.getInt( "taskId" ) );
                task.setTaskName( resultSet.getString( "taskName" ) );
                task.setTaskDescription( resultSet.getString( "taskDescription" ) );
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return task;
    }
 
}