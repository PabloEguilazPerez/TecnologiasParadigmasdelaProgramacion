package db;

public class MongoDBQuery implements DBQuery {

    public MongoDBQuery() {
        System.out.println("MongoDBQuery object created");
    }

    @Override
    public boolean execute() {
        System.out.println("MongoDB query ==> execute");
        return false;
    }

    @Override
    public boolean print() {
        System.out.println("MongoDB query ==> print");
        return false;
    }
}
