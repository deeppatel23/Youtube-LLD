package DependencyInversion.Repository;

public class MySQLDatabase implements Database{
    @Override
    public void save() {
        System.out.println("Saved to MySQL");
    }
}
