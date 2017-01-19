package ru.innopolis.course3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Danil Popov
 */
@org.springframework.stereotype.Service
public class LectureService {

    private LectureDAO lectureDao;

    public LectureDAO getDao() {
        return lectureDao;
    }

    @Autowired
    public void setDao(LectureDAO dao) {
        lectureDao = dao;
    }

    public void add(Lecture o) {
        getDao().add(o);
    }

    public void update(Lecture o) {
        getDao().update(o);
    }

    public void deleteById(int id, int version) {
        getDao().deleteById(id, version);
    }

    public Lecture getById(int id) {
        return getDao().getById(id);
    }

    public List<Lecture> getAll() {
        return getDao().getAll();
    }
}
