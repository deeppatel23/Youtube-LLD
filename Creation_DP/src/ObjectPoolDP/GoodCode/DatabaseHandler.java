package ObjectPoolDP.GoodCode;

public class DatabaseHandler {
    private DatabaseConnectionPool pool;

    public DatabaseHandler(DatabaseConnectionPool pool) {
        this.pool = pool;
    }

    public void processRequest(String query) {
        // Get connection from pool
        DatabaseConnection connection = pool.getConnection();

        // Execute query
        connection.executeQuery(query);

        // Reset and return to pool instead of closing
        connection.reset();
        pool.releaseConnection(connection);
    }
}
