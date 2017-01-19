package ru.innopolis.course3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Danil Popov
 */
@Service
public class StudentService {

    /*private StudentDAO studentDAO;

    public StudentDAO getDao() {
        return studentDAO;
    }

    @Autowired
    @Qualifier("studentDAO")
    public void setDao(StudentDAO dao) {
        this.studentDAO = dao;
    }*/

    private StudentRepository studentRepository;

    public StudentRepository getRepository() {
        return studentRepository;
    }

    @Autowired
    public void setStudentRepository(StudentRepository repository) {
        this.studentRepository = repository;
    }

    public void add(Student o) {
        getRepository().save(o);
    }

    public void update(Student o) {
        getRepository().save(o);
    }

    public void deleteById(int id, int version) {
        getRepository().delete(id);
    }

    public Student getById(int id) {
        return getRepository().findOne(id);
    }

    public List<Student> getAll() {
        //List<Student> st = getRepository().getHighGroupStudent(400);
        List<Student> students = new ArrayList<>();
        Iterable<Student> iterable = getRepository().findAll();
        for (Student student: iterable) {
            students.add(student);
        }
        return students;
    }
}
