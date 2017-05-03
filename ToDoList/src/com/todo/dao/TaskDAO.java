package com.todo.dao;

import java.util.List;

import com.todo.model.Task;
 //For CRUD operations
public interface TaskDAO {
    public void addTask( Task task );
    public void deleteTask( int taskId );
    public void updateTask( Task task );
    public List<Task> getAllTasks();
    public Task getTaskById( int taskId );
}