/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExtClasses;

import ExtClasses.Connection;
import java.sql.*;
        
        
        
public class AccesLinks extends Connection{
    private ResultSet resultSet;

    public AccesLinks() {
        Connect();
    }
    
    public boolean KeyMatch (String key){
        try{
            resultSet = st.executeQuery("SELECT * FROM links WHERE shturl = '" + key + "'" );
            if(!resultSet.next())
            {
                return true;
            }
            return false;    
        }
        catch(SQLException se)
        {
            System.out.println("Error:" + se.getMessage());
            return false;
        }
    }
    
    public String GetLong(String shtU) {
        String direct = "";
        try{
            resultSet = st.executeQuery("SELECT url FROM links WHERE shturl = '" + shtU + "'");
                while (resultSet.next()) {
                    direct = resultSet.getString("url");
                }
            return direct;
        }
        catch(SQLException se)
        {
            System.err.println("Exception:" + se.getMessage());
            return null;
        }
    }
    
    public void Insert(String lngU, String shtU) {
        
        try{
            st.executeUpdate("INSERT INTO links (url, shturl) values('"+ lngU +"', '" + shtU + "')");
        }
        catch(SQLException se)
        {
            System.out.println("Excrption:" + se.getMessage());
        }
        
    }
    
    
}
