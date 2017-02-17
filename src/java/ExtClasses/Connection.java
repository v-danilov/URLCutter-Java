/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExtClasses;
import java.sql.*;
/**
 *
 * @author Vadim
 */
public class Connection {
    protected java.sql.Connection con;
    protected Statement st;
    private String serverName = "localhost";
    private String portNumber = "3306";
    private String dbName = "linkbase";
    private String url = "jdbc:mysql://" + serverName + ":" + portNumber + "/" + dbName;
    private String userName = "root";
    private String password = "root";
    
    public Connection()
    {
        
    }
    
    public java.sql.Connection Connect()
    {
        con = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver Loaded.");
            con = DriverManager.getConnection(url, userName, password);
            st = con.createStatement();
            System.out.println("Connection successful");
        }
        catch(Exception e)
        {
            System.out.println("Something goes wrong. Connection faild :(" + e.getMessage());
        }
          return con;      
    }
    
    public void Disconnect()
    {
        try{
            st.close();
            con.close();
        }
        catch(SQLException e)
        {
            System.out.println("Fail on disconnect");
        }
    }
    
 
}

  
