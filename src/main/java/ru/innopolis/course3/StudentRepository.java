package ru.innopolis.course3;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author Danil Popov
 */
public interface StudentRepository extends CrudRepository<Student, Integer> {
    List<Student> findById(Integer id);

    @Query("select s " +
            "from STUDENT s where s.group > ?1")
    public List<Student> getHighGroupStudent(int group_id);
}
