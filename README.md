# Here are the step by step instructions for the given task

# Make sure you have Apache Tomcat installed and running, driver for sqlite.jar, jstl - standard.jar and jstl - 1.2.jar for taglibs in jsp
# the .jar files are to be added directly to the lib folder in Tomcat

#The TaskController.java contains the logic for the program - redirects to the respective method to perform the CRUD functionalities

#TaskDAO.java contains the abstract for the methods used in the CRUD operation - TaskDAO is an interface

#TaskDAOImplementation.java contains the method implementation of the methods in the interface

#DButil.java contains the DB connection functionality to perform the CRUD operations

#dbscript.sql contains the sql query to create the table required for the CRUD operations - make sure you run this before running the program

#index.jsp - the landing page which directs to List of Tasks from listtask.jsp

#task.jsp contains the necessary fields to add/update the task

#web.xml contains the configuration for the tomcat to identify the correct Servlet class and url-pattern followed
