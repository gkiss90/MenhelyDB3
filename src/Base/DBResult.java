/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Gabor
 */
public class DBResult {
        private String host= "jdbc:derby://localhost:1527/Kutya_menhely";
    private String Name = "user1";
    private String Pass = "user1";
    
    int curRow = 0;
    Connection con;
    Statement stmt;
    
    
    

    
    public Connection DBConnect(String SQL)
    {
        try{
        Connection connection_ = DriverManager.getConnection(host, Name, Pass);
        return connection_;
        }
        catch(Exception err)
        {JOptionPane.showMessageDialog(null, err.getMessage());
        return null;
        }
    }
    
    public ResultSet RSCreate(String SQL)
    {
        try{
        con = DBConnect(SQL);
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                                      ResultSet.CONCUR_UPDATABLE);
            
            
            ResultSet result = stmt.executeQuery(SQL);
            return result;
        }
        catch(Exception err)
        {JOptionPane.showMessageDialog(null, err.getMessage());
        return null;
        }
    }
}
