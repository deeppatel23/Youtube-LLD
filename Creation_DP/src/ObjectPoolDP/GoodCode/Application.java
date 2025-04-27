package ObjectPoolDP.GoodCode;

public class Application {
    public static void main(String[] args) {
        DatabaseConnectionPool pool = new DatabaseConnectionPool();
        DatabaseHandler handler = new DatabaseHandler(pool);
        handler.processRequest("SELECT * FROM users");
        handler.processRequest("UPDATE users SET name = 'Name1'");
        handler.processRequest("UPDATE users SET name = 'Name2'");
    }
}
