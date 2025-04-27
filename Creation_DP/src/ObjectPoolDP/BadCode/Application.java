package ObjectPoolDP.BadCode;

public class Application {
    public static void main(String[] args) {
        DatabaseHandler handler = new DatabaseHandler();
        handler.processRequest("SELECT * FROM users");
        handler.processRequest("UPDATE users SET name = 'John'");
    }
}
