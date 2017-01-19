package ru.innopolis.course3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author Danil Popov
 */
public class JournalDAO implements Dao<Journal> {

    private static final String PREPARED_INSERT = "INSERT INTO JOURNAL(LECTURE_ID, DATE) VALUES " +
            "(?, ?);";
    private static final String PREPARED_SELECT_ALL = "SELECT JOURNAL_ID, LECTURE_ID, DATE FROM JOURNAL;";
    private static final String PREPARED_DELETE = "DELETE FROM JOURNAL WHERE JOURNAL_ID=?;";
    private static final String PREPARED_UPDATE = "UPDATE JOURNAL " +
            "SET LECTURE_ID=?, DATE=? " +
            "WHERE JOURNAL_ID=?;";
    private static final String PREPARED_GET = "SELECT JOURNAL_ID, LECTURE_ID, DATE FROM JOURNAL WHERE JOURNAL_ID=?;";

    private static final Logger logger = LoggerFactory.getLogger(JournalDAO.class);

    @Override
    public void add(Journal o) {

    }

    @Override
    public void update(Journal o) {

    }

    @Override
    public void deleteById(int id, int version) {

    }

    @Override
    public Journal getById(int id) {
        return null;
    }

    @Override
    public List<Journal> getAll() {
        return null;
    }
}
