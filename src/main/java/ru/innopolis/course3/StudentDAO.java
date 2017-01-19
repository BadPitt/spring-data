package ru.innopolis.course3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static ru.innopolis.course3.TestJDBC.getConnection;

/**
 * @author Danil Popov
 */
@Repository
public class StudentDAO implements Dao<Student> {

    private static final String PREPARED_INSERT = "INSERT INTO STUDENT(NAME, SEX, GROUP_ID, VERSION) VALUES " +
            "(?, ?, ?, ?);";
    private static final String PREPARED_SELECT_ALL = "SELECT STUDENT_ID, NAME, SEX, GROUP_ID, VERSION FROM STUDENT;";
    private static final String PREPARED_DELETE = "DELETE FROM STUDENT WHERE STUDENT_ID=? AND VERSION=?;";
    private static final String PREPARED_EDIT = "UPDATE STUDENT " +
            "SET NAME=?, SEX=?, GROUP_ID=? , VERSION=?" +
            "WHERE STUDENT_ID=? AND VERSION=?;";
    private static final String PREPARED_GET_STUDENT = "SELECT STUDENT_ID, NAME, SEX, GROUP_ID, VERSION FROM STUDENT WHERE STUDENT_ID=?;";

    private static final Logger logger = LoggerFactory.getLogger(StudentDAO.class);

    private static final String PERSISTENCE_UNIT_NAME = "hibernate-persistence";
    private static EntityManagerFactory factory;

    @Override
    public void add(Student student) {

            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
            EntityManager em = factory.createEntityManager();

            em.getTransaction().begin();
            em.persist(student);
            em.getTransaction().commit();
            em.close();
    }

    @Override
    public Student getById(int id) {

        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();

        em.getTransaction().begin();
        Student student = em.find(Student.class, id);
        em.getTransaction().commit();
        em.close();


        /*Student student = null;
        try (Connection conn = getConnection();
        PreparedStatement statement = conn.prepareStatement(PREPARED_GET_STUDENT)) {

            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                student = new Student();
                student.setId(result.getInt(1));
                student.setName(result.getString(2));
                student.setSex(result.getString(3));
                student.setGroup(result.getInt(4));
                student.setVersion(result.getInt(5));
            }*/

        /*} catch (SQLException e) {
            logger.error("get student by id sql exception", e);
        }*/
        return student;
    }

    @Override
    public void update(Student student) {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();

        em.getTransaction().begin();
        em.merge(student);
        em.getTransaction().commit();
        em.close();
        /*try (Connection conn = getConnection();
             PreparedStatement statement = conn.prepareStatement(PREPARED_EDIT)) {

            statement.setString(1, student.getName());
            statement.setString(2, student.getSex());
            statement.setInt(3, student.getGroup());
            statement.setInt(4, student.getVersion() + 1);
            statement.setInt(5, student.getId());
            statement.setInt(6, student.getVersion());

            statement.execute();

        } catch (SQLException e) {
            logger.error("update student sql exception", e);
        }*/
    }

    @Override
    public void deleteById(int id, int version) {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(PREPARED_DELETE)) {

            statement.setInt(1, id);
            statement.setInt(2, version);
            statement.execute();

        } catch (SQLException e) {
            logger.error("delete student sql exception", e);
        }
    }

    @Override
    public List<Student> getAll() {
        List<Student> list = new ArrayList<>();

        try (Connection connection = getConnection();
             PreparedStatement pStatement = connection.prepareStatement(PREPARED_SELECT_ALL)) {

            ResultSet result = pStatement.executeQuery();
            while (result.next()) {
                Student student = new Student();
                student.setId(result.getInt(1));
                student.setName(result.getString(2));
                student.setSex(result.getString(3));
                student.setGroup(result.getInt(4));
                student.setVersion(result.getInt(5));
                list.add(student);
            }

        } catch (SQLException e) {
            logger.error("show all students SQL exception", e);
        }
        return list;
    }
}
