package pl.owsianka.magazyn.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.owsianka.magazyn.database.IUserDAO;
import pl.owsianka.magazyn.exceptions.ValidationException;
import pl.owsianka.magazyn.model.User;
import pl.owsianka.magazyn.validators.UserDataValidator;

import java.util.Optional;

@Controller
public class AuthenticationController {

    @Autowired
    IUserDAO userDAO;

    public static boolean isLogged = false;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute User user) {
        try {
            UserDataValidator.validateLogin(user.getLogin());
            UserDataValidator.validatePassword(user.getPassword());
        } catch (ValidationException e) {
            return "redirect:/login";
        }
        Optional<User> userFromDB = this.userDAO.getUserByLogin(user.getLogin());
        if (userFromDB.isPresent() && userFromDB.get().getPassword().equals(user.getPassword())) {
            isLogged = true;
            return "redirect:/products";
        }
        return "redirect:/login";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register2(@ModelAttribute User user, @RequestParam String password2) {
        try {
            UserDataValidator.validateLogin(user.getLogin());
            UserDataValidator.validatePassword(user.getPassword());
            UserDataValidator.validatePasswordMatch(user.getPassword(), password2);
        } catch (ValidationException e) {
            return "redirect:/register";
        }
        if (this.userDAO.isLoginExist(user.getLogin())) {
            return "redirect:/register";
        }
        this.userDAO.addUser(user);
        return "redirect:/main";
    }
}
