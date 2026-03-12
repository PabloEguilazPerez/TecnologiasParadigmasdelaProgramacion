package db;

public class Application_NoFactoryMethod {

    // Without pattern: the client directly instantiates concrete classes
    public static void main(String[] args) {

        System.out.println("=== Using MySQL (no Factory Method) ===");
        DBConnection c1 = new MySQLConnection();
        c1.open();
        c1.close();

        System.out.println();
        System.out.println("=== Using MongoDB (no Factory Method) ===");
        DBConnection c2 = new MongoDBConnection();
        c2.open();
        c2.close();
    }
}
