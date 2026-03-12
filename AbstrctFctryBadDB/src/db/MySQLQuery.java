package db;

public class MySQLQuery implements DBQuery {

    public MySQLQuery() {
        System.out.println("MySQLQuery object created");
    }

    @Override
    public boolean execute() {
        System.out.println("MySQL query ==> execute");
        return false;
    }

    @Override
    public boolean print() {
        System.out.println("MySQL query ==> print");
        return false;
    }
}
