package db;

public class MongoDBConnectionFactory implements ConnectionFactory {

    public MongoDBConnectionFactory() {
        System.out.println("MongoDBConnectionFactory instantiated");
    }

    @Override
    public DBConnection createConnection() {
        return new MongoDBConnection();
    }
}
