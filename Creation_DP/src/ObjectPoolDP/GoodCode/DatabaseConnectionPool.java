package ObjectPoolDP.GoodCode;

import java.util.ArrayList;
import java.util.List;

public class DatabaseConnectionPool {
    private List<DatabaseConnection> availableConnections;
    private List<DatabaseConnection> usedConnections;
    private final int MAX_POOL_SIZE = 2;

    public DatabaseConnectionPool() {
        availableConnections = new ArrayList<>();
        usedConnections = new ArrayList<>();

        // Initialize pool with some connections
        for (int i = 0; i < MAX_POOL_SIZE; i++) {
            availableConnections.add(new DatabaseConnection());
        }
    }

    public synchronized DatabaseConnection getConnection() {
        if (availableConnections.isEmpty()) {
            if (usedConnections.size() < MAX_POOL_SIZE) {
                // Create new connection if pool size limit not reached
                DatabaseConnection conn = new DatabaseConnection();
                usedConnections.add(conn);
                return conn;
            } else {
                // Wait for a connection to be released
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                return getConnection(); // Try again
            }
        } else {
            // Get existing connection from pool
            DatabaseConnection conn = availableConnections.remove(0);
            usedConnections.add(conn);
            return conn;
        }
    }

    public synchronized void releaseConnection(DatabaseConnection conn) {
        usedConnections.remove(conn);
        availableConnections.add(conn);
        notifyAll(); // Notify waiting threads that a connection is available
    }
}
