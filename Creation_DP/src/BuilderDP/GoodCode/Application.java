package BuilderDP.GoodCode;

public class Application {
    public static void main(String[] args) {
        SQLQuery query = new SQLQuery.Builder("Employees")
                .where("age > 30")
                .orderBy("salary DESC")
                .build();

        System.out.println(query.getQuery());

        SQLQuery query2 = new SQLQuery.Builder("Employees")
                .orderBy("salary DESC")
                .build();

        System.out.println(query2.getQuery());
    }
}
