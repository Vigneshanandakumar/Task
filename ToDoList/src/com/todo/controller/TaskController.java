package com.todo.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import com.todo.dao.TaskDAO;
import com.todo.dao.TaskDAOImplementation;
import com.todo.model.Task;
 
/**
 * @author vignesh
 *
 */
@WebServlet("/TaskController")
public class TaskController extends HttpServlet {
 
    private TaskDAO dao;
    private static final long serialVersionUID = 1L;
    public static final String lIST_task = "/listtask.jsp";
    public static final String INSERT_OR_EDIT = "/task.jsp";
 
    public TaskController() {
        dao = new TaskDAOImplementation();
    }
 
    /* (non-Javadoc)
     * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward = "";
        String action = request.getParameter( "action" );
 
        if( action.equalsIgnoreCase( "delete" ) ) {
            forward = lIST_task;
            int taskId = Integer.parseInt( request.getParameter("taskId") );
            dao.deleteTask(taskId);
            request.setAttribute("tasks", dao.getAllTasks() );
        }
        else if( action.equalsIgnoreCase( "edit" ) ) {
            forward = INSERT_OR_EDIT;
            int taskId = Integer.parseInt( request.getParameter("taskId") );
            Task task = dao.getTaskById(taskId);
            request.setAttribute("task", task);
        }
        else if( action.equalsIgnoreCase( "insert" ) ) {
            forward = INSERT_OR_EDIT;
        }
        else {
            forward = lIST_task;
            request.setAttribute("tasks", dao.getAllTasks() );
        }
        RequestDispatcher view = request.getRequestDispatcher( forward );
        view.forward(request, response);
    }
 
    /* (non-Javadoc)
     * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Task task = new Task();
        task.setTaskName( request.getParameter( "taskName" ) );
        task.setTaskDescription( request.getParameter( "taskDescription" ) );
        String taskId = request.getParameter("taskId");
 
        if( taskId == null || taskId.isEmpty() )
            dao.addTask(task);
        else {
            task.setTaskId( Integer.parseInt(taskId) );
            dao.updateTask(task);
        }
        RequestDispatcher view = request.getRequestDispatcher( lIST_task );
        request.setAttribute("tasks", dao.getAllTasks());
        view.forward(request, response);
    }
}
