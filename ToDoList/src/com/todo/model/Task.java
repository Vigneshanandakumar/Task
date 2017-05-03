package com.todo.model;
 
public class Task {
 
    private int taskId; //Task ID of the user-defined task; auto - incremented in the database
    private String taskName; //Task Name of the user-defined task
    private String taskDescription; // Task Description for the user-defined task 
    private String addedOn; //Timestamp on which the task was added; auto - incremented in the database
 
    //Getters and setters for the respective attributes of Task
    
    public void setTaskId(int taskId) {
		this.taskId = taskId;
	}


	public void setAddedOn(String addedOn) {
		this.addedOn = addedOn;
	}


	public String getTaskName() {
		return taskName;
	}


	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}


	public String getTaskDescription() {
		return taskDescription;
	}


	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}


	public int getTaskId() {
		return taskId;
	}


	public String getAddedOn() {
		return addedOn;
	}


	@Override
    public String toString() {
        return "Task [TaskId=" + taskId + ", taskName=" + taskName
                + ", taskDescription=" + taskDescription + ", addedOn=" + addedOn + "]";
    }
 
}