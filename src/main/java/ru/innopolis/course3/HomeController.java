package ru.innopolis.course3;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author Danil Popov
 */
@Controller
public class HomeController {

    @RequestMapping("/home")
    public String getHomePage(Model model) {
        return "home/index";
    }
}
