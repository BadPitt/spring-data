package ru.innopolis.course3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Danil Popov
 */
public abstract class Service<T> {

    public void add(T o) {
        getDao().add(o);
    }

    public void update(T o) {
        getDao().update(o);
    }

    public void deleteById(int id, int version) {
        getDao().deleteById(id, version);
    }
    //T getByField(Object obj);
    public T getById(int id) {
        return getDao().getById(id);
    }

    public List<T> getAll() {
        return getDao().getAll();
    }

    public abstract Dao<T> getDao();

    public abstract void setDao(Dao<T> dao);
}
