package DependencyInversion.Repository;

public class MongoDatabase implements Database{
    @Override
    public void save() {
        System.out.println("Saved to MongoDB");
    }
}
