package service;

import dao.DatabaseQueries;

public interface CRUDContainer {
    public abstract void add(DatabaseQueries databaseQueries);
    public abstract void read(DatabaseQueries databaseQueries);
    public abstract void readall(DatabaseQueries databaseQueries);
    public abstract void update(DatabaseQueries databaseQueries);
    public abstract void delete(DatabaseQueries databaseQueries);
	public static <T> CRUDContainer newInstance(Class<T> class1) {
		// TODO Auto-generated method stub
		return null;
	}
}
