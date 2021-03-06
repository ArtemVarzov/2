package org.example.repo;

import java.sql.SQLException;
import java.util.List;

public interface GenericRepo<T, ID> {

    void add(T t) throws SQLException;

    List<T> getAll() throws SQLException;

    T getById(ID id) throws SQLException;

    T update(T t) throws SQLException;

    void delete(ID id) throws SQLException;
}
