/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ucuenca.edu.optii.ecu911.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Savepoint;

public class DatabaseManager {
	private Connection connection;
	private Savepoint svpt;

	public DatabaseManager()
	{
         try {
                    String url = "jdbc:postgresql://localhost/baseEcu?user=postgres&password=43844384";
                    connection = DriverManager.getConnection(url);
                    connection.setAutoCommit(false);
		} catch (SQLException e) {	e.printStackTrace();
		}
        }

	public void commit(){
		try
		{
			connection.commit();
			svpt = connection.setSavepoint();
		} catch (SQLException e){      e.printStackTrace();
		}
	}

	public Connection getConnection(){
		return connection;
	}
    //en caso que necesite hacer conexiones paralelas
	public void openConnectionTo(String url){
		try
		{			
			connection = DriverManager.getConnection(url, "postgres", "clave");
		} catch (SQLException e){  e.printStackTrace();
		}
	}
        //borrar todo lo hecho
	public void rollBack(){
		try
		{
			if (svpt != null)
			{
				connection.rollback(svpt);
				connection.commit();
			}
		} catch (SQLException e){
			e.printStackTrace();
		}
	}    
}
