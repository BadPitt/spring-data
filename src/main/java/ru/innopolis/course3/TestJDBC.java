package ru.innopolis.course3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.*;

/**
 * @author Danil Popov
 */
public class TestJDBC {

    private static final Logger logger = LoggerFactory.getLogger(TestJDBC.class);

    static {
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            logger.error("JDBC driver not found", e);
            throw new RuntimeException();
        }
    }

    public static final String DATABASE_URL = "jdbc:h2:~/IdeaProject/jdbc-test";
    public static final String CREATE_STUDENT_TABLE = "CREATE TABLE STUDENT " +
            " (" +
            " STUDENT_ID BIGINT AUTO_INCREMENT NOT NULL, " +
            " NAME VARCHAR(10)," +
            " SEX VARCHAR(1)," +
            " GROUP_ID INTEGER," +
            " VERSION INTEGER" +
            " );";
    public static final String CREATE_LECTURE_TABLE = "CREATE TABLE LECTURE" +
            " (" +
            " LECTURE_ID BIGINT AUTO_INCREMENT NOT NULL PRIMARY KEY , " +
            " NAME VARCHAR(10)," +
            " LENGTH INTEGER," +
            " VERSION INTEGER" +
            " );";
    public static final String CREATE_ATTENDANCE_TABLE = "CREATE TABLE ATTENDANCE " +
            "( " +
            "  ATTENDANCE_ID BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL, " +
            "  LECTURE_ID BIGINT, " +
            "  STUDENT_ID BIGINT, " +
            "  VERSION INTEGER, " +
            "  CONSTRAINT ATTENDANCE_LECTURE_LECTURE_ID_FK FOREIGN KEY (LECTURE_ID) REFERENCES LECTURE (LECTURE_ID) ON DELETE CASCADE ON UPDATE CASCADE, " +
            "  CONSTRAINT ATTENDANCE_STUDENT_STUDENT_ID_FK FOREIGN KEY (STUDENT_ID) REFERENCES STUDENT (STUDENT_ID) ON DELETE CASCADE ON UPDATE CASCADE " +
            ");";
    public static final String CREATE_JOURNAL_TABLE = "CREATE TABLE JOURNAL " +
            "( " +
            "  JOURNAL_ID BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL, " +
            "  LECTURE_ID BIGINT, " +
            "  DATE DATETIME, " +
            "  VERSION INTEGER, " +
            "  CONSTRAINT JOURNAL_LECTURE_LECTURE_ID_FK FOREIGN KEY (LECTURE_ID) REFERENCES LECTURE (LECTURE_ID) ON DELETE CASCADE ON UPDATE CASCADE " +
            ");";
    public static final LectureDAO lectureDAO = new LectureDAO();


    public static void main(String[] args) {
        /*createTables();
        //insertNewStudent(3, "Marry", "F", 314);
        List<Student> students = studentDAO.getAll();
        for (Student student: students) {
            logger.debug("| " + student.getId() + " " +
                    student.getName() + " " +
                    student.getSex() + " " +
                    student.getGroup() + " |");
        }*/


    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DATABASE_URL);
    }

    private static void createStudentTable() {
        try (Connection conn = DriverManager.getConnection(DATABASE_URL);
             Statement statement = conn.createStatement()) {

            statement.execute(CREATE_STUDENT_TABLE);
            logger.debug("students table has created");

        } catch (SQLException e) {
            logger.error("create STUDENT table sql exception", e);
        }
    }

    private static void createLectureTable() {
        try (Connection conn = DriverManager.getConnection(DATABASE_URL);
        Statement statement = conn.createStatement()) {

            statement.execute(CREATE_LECTURE_TABLE);
            logger.debug("lectures table has created");

        } catch (SQLException e) {
            logger.error("create LECTURE table sql exception", e);
        }
    }

    private static void createAttendanceTable() {
        try (Connection conn = DriverManager.getConnection(DATABASE_URL);
             Statement statement = conn.createStatement()) {

            statement.execute(CREATE_ATTENDANCE_TABLE);
            logger.debug("attendance table has created");

        } catch (SQLException e) {
            logger.error("create ATTENDANCE table sql exception", e);
        }
    }

    private static void createJournalTable() {
        try (Connection conn = DriverManager.getConnection(DATABASE_URL);
             Statement statement = conn.createStatement()) {

            statement.execute(CREATE_JOURNAL_TABLE);
            logger.debug("journal table has created");

        } catch (SQLException e) {
            logger.error("create JOURNAL table sql exception", e);
        }
    }

    public static void createTables() {
        createStudentTable();
        createLectureTable();
        createAttendanceTable();
        createJournalTable();
    }
}
