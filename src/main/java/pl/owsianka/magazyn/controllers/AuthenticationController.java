package pl.owsianka.magazyn.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.owsianka.magazyn.database.UserDatabase;
import pl.owsianka.magazyn.model.User;

@Controller
public class AuthenticationController {

    @Autowired
    UserDatabase userDatabase;

    private boolean isLogged = false;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute User user) {
        User userFromDB = this.userDatabase.getUserByLogin(user.getLogin());
        if (userFromDB != null && userFromDB.getPassword().equals(user.getPassword())) {
                this.isLogged = true;
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
        return null;
    }
}
