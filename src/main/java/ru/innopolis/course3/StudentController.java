package ru.innopolis.course3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import java.util.List;

/**
 * @author Danil Popov
 */
@Controller
public class StudentController {

    //private static ApplicationContext cntx = new ClassPathXmlApplicationContext("student-servlet.xml");

    private StudentService studentService; //= cntx.getBean("student-service", StudentService.class);

    private LectureService lectureService; //= cntx.getBean("lecture-service", LectureService.class);

    @Autowired
    @Qualifier("studentService")
    public void setStudentService(StudentService service) {
        this.studentService = service;
    }

    @Autowired
    @Qualifier("lectureService")
    public void setLectureService(LectureService lectureService) {
        this.lectureService = lectureService;
    }

    @RequestMapping(value = "/new_student")
    public String addNewStudent(Model model) {
        return "/student/new_student";
    }

    @RequestMapping(value = "/add_student", method = RequestMethod.POST)
    public String addStudent(@RequestParam("student_name") String stdname,
                             @RequestParam("student_sex") String stdsex,
                             @RequestParam("student_group") String stdgroup,
                             Model model) {

        Student student = new Student();
        student.setName(stdname);
        student.setSex(stdsex);
        student.setGroup(Integer.parseInt(stdgroup));
        studentService.add(student);
        List<Student> students = studentService.getAll();
        model.addAttribute("students", students);

        return "/student/show_students";
    }

    @RequestMapping(value = "/student/show_students")
    public String showStudent(Model model) {

        List<Student> students = studentService.getAll();
        List<Lecture> lectures = lectureService.getAll();
        model.addAttribute("students", students);

        return "/student/show_students";
    }

    @RequestMapping(value = "/edit_student_page", method = RequestMethod.POST)
    public String editStudentPage(@RequestParam("student_id") String stdid,
                                  Model model) {
        int id = Integer.parseInt(stdid);
        Student student = studentService.getById(id);
        model.addAttribute("student", student);
        return "/student/edit_student";
    }

    @RequestMapping(value = "/edit_student",
            method = RequestMethod.POST)
    public String editStudent(@RequestParam("student_id") String stdid,
                              @RequestParam("student_name") String stdname,
                              @RequestParam("student_sex") String stdsex,
                              @RequestParam("student_group") String stdgroup,
                              @RequestParam("student_version") String stdversion,
                              Model model) {

        Student student = new Student();
        student.setId(Integer.parseInt(stdid));
        student.setName(stdname);
        student.setSex(stdsex);
        student.setGroup(Integer.parseInt(stdgroup));
        student.setVersion(Integer.parseInt(stdversion));
        studentService.update(student);

        List<Student> students = studentService.getAll();
        model.addAttribute("students", students);

        return "/student/show_students";
    }

    @RequestMapping(value = "/delete_student", method = RequestMethod.POST)
    public String deleteStudent(@RequestParam("student_id") String stdid,
                                @RequestParam("student_version") String stdvrs,
                                Model model) {

        int id = stdid != null ? Integer.parseInt(stdid) : 0;
        int version = stdid != null ? Integer.parseInt(stdvrs) : 0;
        studentService.deleteById(id, version);

        List<Student> students = studentService.getAll();
        model.addAttribute("students", students);

        return "/student/show_students";
    }

    @RequestMapping(value = "/login")
    public String login() {

        return "login";
    }

    @RequestMapping(value = "/logout")
    public String logout() {

        return "login";
    }
}
