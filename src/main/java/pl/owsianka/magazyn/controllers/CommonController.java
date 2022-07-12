package pl.owsianka.magazyn.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.owsianka.magazyn.database.ProductDatabase;

@Controller
public class CommonController {

    @Autowired
    ProductDatabase productDatabase;

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String main() {
        return "main";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String main2() {
        return "redirect:/main";
    }

    @RequestMapping(value = "/contact", method = RequestMethod.GET)
    public String contact() {
        return "contact";
    }

    @RequestMapping(value = "products", method = RequestMethod.GET)
    public String products(Model model) {
        model.addAttribute("products", this.productDatabase.getProducts());
        return "products";
    }
}
