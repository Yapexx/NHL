package dao;

import java.sql.Connection;


/**
 * Created by yannx_000 on 17/06/2017.
 */
public abstract class DAO<T> {
    protected Connection connect = null;

    public DAO(Connection conn) {
        this.connect = conn;
    }

    /**
     * Method to create an object in the database
     * @param obj
     * @return
     */
    public abstract boolean create(T obj);

    /**
     * Method to delete an object from the database
     * @param obj
     * @return
     */
    public abstract boolean delete(T obj);

    /**
     * Method to get an object from the database
     * @param id
     * @return
     */
    public abstract T find(int id);
}
