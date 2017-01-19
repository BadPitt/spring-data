package ru.innopolis.course3;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author Danil Popov
 */
public class LectureServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String button = req.getParameter("button");

        if ("new_lecture".equals(button)) {
            getServletContext().getRequestDispatcher("/lecture/new_lecture.jsp").forward(req, resp);
        } else if ("add_lecture".equals(button)) {
            Lecture lecture = new Lecture();
            lecture.setName(req.getParameter("lecture_name"));
            lecture.setLength(Integer.parseInt(req.getParameter("lecture_length")));
            TestJDBC.lectureDAO.add(lecture);
            List<Lecture> lectures = TestJDBC.lectureDAO.getAll();
            req.setAttribute("lectures", lectures);
            getServletContext().getRequestDispatcher("/lecture/show_lectures.jsp").forward(req, resp);
        } else if ("show_lectures".equals(button)) {
            List<Lecture> lectures = TestJDBC.lectureDAO.getAll();
            req.setAttribute("lectures", lectures);
            getServletContext().getRequestDispatcher("/lecture/show_lectures.jsp").forward(req, resp);
        } else if ("edit_lecture_page".equals(button)) {
            String str = req.getParameter("id");
            int id = Integer.parseInt(str);
            Lecture lecture = TestJDBC.lectureDAO.getById(id);
            req.setAttribute("lecture", lecture);
            getServletContext().getRequestDispatcher("/lecture/edit_lecture.jsp").forward(req, resp);
        } else if ("delete_lecture".equals(button)) {
            String str = req.getParameter("id");
            int id = str != null ? Integer.parseInt(str) : 0;
            // FIXME version
            TestJDBC.lectureDAO.deleteById(id, 0);

            List<Lecture> lectures = TestJDBC.lectureDAO.getAll();
            req.setAttribute("lectures", lectures);

            getServletContext().getRequestDispatcher("/lecture/show_lectures.jsp").forward(req, resp);
        } else if ("edit_lecture".equals(button)) {
            Lecture lecture = new Lecture();
            lecture.setId(Integer.parseInt(req.getParameter("lecture_id")));
            lecture.setName(req.getParameter("lecture_name"));
            lecture.setLength(Integer.parseInt(req.getParameter("lecture_length")));
            TestJDBC.lectureDAO.update(lecture);

            List<Lecture> lectures = TestJDBC.lectureDAO.getAll();
            req.setAttribute("lectures", lectures);

            getServletContext().getRequestDispatcher("/lecture/show_lectures.jsp").forward(req, resp);
        }
    }
}
