package ru.innopolis.course3;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Danil Popov
 */
public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String button = req.getParameter("button");

        if ("show_lectures".equals(button)) {
            getServletContext().getRequestDispatcher("/lecture").forward(req, resp);
        } else if ("show_journal".equals(button)) {
            getServletContext().getRequestDispatcher("/journal").forward(req, resp);
        } else if ("show_students".equals(button)) {
            getServletContext().getRequestDispatcher("/student").forward(req, resp);
        }
    }
}
