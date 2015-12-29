/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Base;

import static Base.Kennelek.logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import javax.swing.JOptionPane;

/**
 *
 * @author Gabor
 */
public class DBResult 
{
    private String host= "jdbc:derby://localhost:1527/Kutya_menhely";
    private String Name = "user1";
    private String Pass = "user1";
    
    int curRow = 0;
    Connection con;
    Statement stmt;
    
    
    

    
    public Connection DBConnect()
    {
        try{
        Connection connection_ = DriverManager.getConnection(host, Name, Pass);
        return connection_;
        }
        catch(Exception e)
        {JOptionPane.showMessageDialog(null, e.getMessage());
        return null;
        }
    }
    
    public ResultSet RSCreate(String SQL)
    {
        try{
        con = DBConnect();
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                                      ResultSet.CONCUR_UPDATABLE);
            
            
            ResultSet result = stmt.executeQuery(SQL);
            return result;
        }
        catch(Exception e)
        {JOptionPane.showMessageDialog(null, e.getMessage());
        return null;
        }
    }
    
    public int NextID(ResultSet rs)
    {
        try
        {
        int curentRow = rs.getRow();
        rs.last();
        int rownumber = rs.getInt("ID");
        rs.absolute(curentRow);
        logger.log(Level.INFO, "Új egyed ID-ja: "+rownumber+1);
        return rownumber + 1;
        }
        catch (SQLException e)
        {
            logger.log(Level.INFO, "Új ID kiszámítás közben fellépett hiba: "+e);
            JOptionPane.showMessageDialog(null, e.getMessage());
            return -1;
        }
}
}
