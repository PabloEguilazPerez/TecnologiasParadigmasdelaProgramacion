package db;

public interface DBConnection {
    boolean open();
    boolean close();
}
