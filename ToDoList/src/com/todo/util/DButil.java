package com.todo.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
 
public class DButil {
 
    private static Connection conn;
 
    public static Connection getConnection() {
        if( conn != null )
            return conn;
        try {
        	//Driver used to connect with SQLite Database
            Class.forName("org.sqlite.JDBC");
            // Replace the path with your local database path
            conn = DriverManager.getConnection("jdbc:sqlite:U:\\Softwares\\Sqlite\\sqlitestudio-3.1.1\\SQLiteStudio\\Todo");
          } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
          }
 
        return conn;
    }
 
    public static void closeConnection( Connection toBeClosed ) {
        if( toBeClosed == null )
            return;
        try {
            toBeClosed.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
