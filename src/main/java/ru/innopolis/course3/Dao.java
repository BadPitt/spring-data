package ru.innopolis.course3;

import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Danil Popov
 */
public interface Dao<T> {

    void add(T o);
    void update(T o);
    void deleteById(int id, int version);
    //T getByField(Object obj);
    T getById(int id);
    List<T> getAll();

}
