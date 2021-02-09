/*
@author Júlia Gonzaga
*/

package julia.bd.pdcase;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PostgresqlJDBCConnection implements ConnectionDB{
    private final static String dbDriver = "org.postgresql.Driver";
    private final static String dbURL = "jdbc:postgresql://localhost:5432/juliabdpdcase";
    private final static String user = "postgres";
    private final static String pass = "postgres";
    
    @Override
    public java.sql.Connection getConnection() throws Exception{
        try{
            Class.forName(dbDriver);
            return DriverManager.getConnection(dbURL, user, pass);
        }catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception(ex);
        }
    }
}
