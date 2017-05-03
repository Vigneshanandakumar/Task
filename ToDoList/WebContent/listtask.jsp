<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show All Tasks</title>
</head>
<body>
    <table>
        <thead>
            <tr>
                <th>Task ID</th>
                <th>Task Name</th>
                <th>Task Description</th>
                <th>Added On</th>
                <th colspan="2">Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${tasks}" var="task">
                <tr>
                    <td><c:out value="${task.taskId}" /></td>
                    <td><c:out value="${task.taskName}" /></td>
                    <td><c:out value="${task.taskDescription}" /></td>
                    <td><c:out value="${task.addedOn}" /></td>
                    <td><a
                        href="TaskController?action=edit&taskId=<c:out value="${task.taskId }"/>">Update</a></td>
                    <td><a
                        href="TaskController?action=delete&taskId=<c:out value="${task.taskId }"/>">Delete</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <p>
        <a href="TaskController?action=insert">Add Task</a>
    </p>
</body>
</html>