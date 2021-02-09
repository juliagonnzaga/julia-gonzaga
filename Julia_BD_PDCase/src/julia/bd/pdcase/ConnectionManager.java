/*
@author Júlia Gonzaga
*/

package julia.bd.pdcase;

public class ConnectionManager {
    private static ConnectionManager instance = null;
    private java.sql.Connection connection = null;
    
    private ConnectionManager(ConnectionDB connectionDB) throws Exception{
        this.connection = connectionDB.getConnection();
    }
    
    public static ConnectionManager getInstance() throws Exception{
        if(ConnectionManager.instance == null) {
        ConnectionDB db = new PostgresqlJDBCConnection();
        ConnectionManager.instance = new ConnectionManager(db);
    }
        return ConnectionManager.instance;
    }
    
    public java.sql.Connection getConnection(){
        return this.connection;
    }
}
