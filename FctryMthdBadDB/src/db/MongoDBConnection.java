package db;

public class MongoDBConnection implements DBConnection {

    public MongoDBConnection() {
        System.out.println("MongoDBConnection object created");
    }

    @Override
    public boolean open() {
        System.out.println("MongoDB connection ==> open");
        return false;
    }

    @Override
    public boolean close() {
        System.out.println("MongoDB connection ==> close");
        return false;
    }
}
