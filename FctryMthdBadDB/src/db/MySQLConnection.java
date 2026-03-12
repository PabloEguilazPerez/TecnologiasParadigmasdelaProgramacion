package db;

public class MySQLConnection implements DBConnection {

    public MySQLConnection() {
        System.out.println("MySQLConnection object created");
    }

    @Override
    public boolean open() {
        System.out.println("MySQL connection ==> open");
        return false;
    }

    @Override
    public boolean close() {
        System.out.println("MySQL connection ==> close");
        return false;
    }
}
