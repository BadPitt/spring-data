package ru.innopolis.course3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static ru.innopolis.course3.TestJDBC.DATABASE_URL;

/**
 * @author Danil Popov
 */
@Component
public class LectureDAO implements Dao<Lecture>{

    private static final String PREPARED_INSERT = "INSERT INTO LECTURE(NAME, LENGTH) VALUES " +
            "(?, ?);";
    private static final String PREPARED_SELECT_ALL = "SELECT LECTURE_ID, NAME, LENGTH FROM LECTURE;";
    private static final String PREPARED_DELETE = "DELETE FROM LECTURE WHERE LECTURE_ID=?;";
    private static final String PREPARED_UPDATE = "UPDATE LECTURE " +
            "SET NAME=?, LENGTH=? " +
            "WHERE LECTURE_ID=?;";
    private static final String PREPARED_GET_LECTURE = "SELECT LECTURE_ID, NAME, LENGTH FROM LECTURE WHERE LECTURE_ID=?;";

    private static final Logger logger = LoggerFactory.getLogger(LectureDAO.class);

    @Override
    public void add(Lecture lecture) {
        try (Connection conn = DriverManager.getConnection(DATABASE_URL);
             PreparedStatement statement = conn.prepareStatement(PREPARED_INSERT)) {

            statement.setString(1, lecture.getName());
            statement.setInt(2, lecture.getLength());
            statement.execute();

        } catch (SQLException e) {
            logger.error("add lecture sql exception", e);
        }
    }

    @Override
    public void update(Lecture o) {
        try (Connection conn = DriverManager.getConnection(DATABASE_URL);
        PreparedStatement statement = conn.prepareStatement(PREPARED_UPDATE)) {

            statement.setString(1, o.getName());
            statement.setInt(2, o.getLength());
            statement.setInt(3, o.getId());
            statement.execute();

        } catch (SQLException e) {
            logger.error("update lecture sql exception", e);
        }
    }

    @Override
    public void deleteById(int id, int version) {
        try (Connection conn = DriverManager.getConnection(DATABASE_URL);
             PreparedStatement statement = conn.prepareStatement(PREPARED_DELETE)) {

            statement.setInt(1, id);
            statement.execute();

        } catch (SQLException e) {
            logger.error("delete lecture sql exception", e);
        }
    }

    @Override
    public Lecture getById(int id) {
        Lecture lecture = new Lecture();
        try (Connection conn = DriverManager.getConnection(DATABASE_URL);
             PreparedStatement statement = conn.prepareStatement(PREPARED_GET_LECTURE)) {

            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                lecture.setId(result.getInt(1));
                lecture.setName(result.getString(2));
                lecture.setLength(result.getInt(3));
            }

        } catch (SQLException e) {
            logger.error("getById lecture sql exception", e);
        }
        return lecture;
    }

    @Override
    public List<Lecture> getAll() {
        List<Lecture> lectures = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(DATABASE_URL);
             PreparedStatement statement = conn.prepareStatement(PREPARED_SELECT_ALL)) {

            ResultSet result = statement.executeQuery();
            while (result.next()) {
                Lecture lecture = new Lecture();
                lecture.setId(result.getInt(1));
                lecture.setName(result.getString(2));
                lecture.setLength(result.getInt(3));
                lectures.add(lecture);
            }

        } catch (SQLException e) {
            logger.error("get all lecture sql exception", e);
        }
        return lectures;
    }
}
