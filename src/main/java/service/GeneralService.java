package service;


import java.sql.SQLException;
import java.util.List;

public interface GeneralService<T> {

    public List<T> findAll();

    public boolean add(T t) throws SQLException;

    public boolean update(T t) throws SQLException;

    public boolean delete(int id) throws SQLException;

    public T findById(int id);
}