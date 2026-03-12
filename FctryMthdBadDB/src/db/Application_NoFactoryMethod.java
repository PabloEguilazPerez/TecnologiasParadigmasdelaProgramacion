package db;

public class Application_NoFactoryMethod {
	
	private static void run(DBConnectionFactory factory) {
		DBConnection c = factory.createConnection();
		c.open();
		c.close();
		
	}

    // Without pattern: the client directly instantiates concrete classes
    public static void main(String[] args) {
    	
    	run(new MongoDBConnectionFactory());

        System.out.println("=== Using MySQL (no Factory Method) ===");
        DBConnection c1 = new MySQLConnection();
        c1.open();
        c1.close();

        System.out.println();
        System.out.println("=== Using MongoDB (no Factory Method) ===");
        DBConnection c2 = new MongoDBConnection();
        c2.open();
        c2.close();
        
        
        //DBFactory dbf = new DBFactory(TipoDB.MYSQL);
        
        //dbf.open();
        
       
    }

    
}
