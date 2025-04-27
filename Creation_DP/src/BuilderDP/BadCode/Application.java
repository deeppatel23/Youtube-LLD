package BuilderDP.BadCode;

public class Application {
    public static void main(String[] args) {
        SQLQuery query = new SQLQuery("Employees", "age > 30", "salary DESC");
        System.out.println(query.getQuery());

        //always need to provide all three parameters
        SQLQuery query2 = new SQLQuery("Employees", null, "salary DESC");
        System.out.println(query2.getQuery());
    }
}
