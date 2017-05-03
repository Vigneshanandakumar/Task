<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 
<title>Add New Task</title>
</head>
<body>
    <form action="TaskController" method="post">
        <fieldset>
            <div>
                <label for="taskId">Task ID</label> <input type="text"
                    name="taskId" value="<c:out value="${task.taskId}" />"
                    readonly="readonly" placeholder="Task ID" />
            </div>
            <div>
                <label for="taskName">Task Name</label> <input type="text"
                    name="taskName" value="<c:out value="${task.taskName}" />"
                    placeholder="Task Name" />
            </div>
            <div>
                <label for="taskDescription">Task Description</label> <input type="textarea"
                    name="taskDescription" value="<c:out value="${task.taskDescription}" />"
                    placeholder="Task Description" />
            </div>
            <div>
                <input type="submit" value="Submit" />
            </div>
        </fieldset>
    </form>
</body>
</html>