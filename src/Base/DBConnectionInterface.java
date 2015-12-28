/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Base;

import java.sql.ResultSet;
import java.sql.Connection;

/**
 *
 * @author Gabor
 */
public interface DBConnectionInterface {
/*    
public Connection DBConnect();
public ResultSet RSCreate();
*/
public void DBFill();
public void FillIn();
public void UpdateRecord();
public void InsertRecord();
    


}
