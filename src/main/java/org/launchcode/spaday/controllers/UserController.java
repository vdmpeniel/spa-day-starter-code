package org.launchcode.spaday.controllers;

import org.launchcode.spaday.data.UserData;
import org.launchcode.spaday.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.format.DateTimeFormatter;

@Controller
@RequestMapping("user")
public class UserController {
    UserData userData = new UserData();

    @PostMapping
    public String user(Model model, @ModelAttribute User user, String verify){
        boolean validPasswordConfirmation = (verify.equals(user.getPassword()));
        model.addAttribute("name", user.getName());
        model.addAttribute("email", user.getEmail());
        model.addAttribute("password", user.getPassword());
        model.addAttribute("validPasswordConfirmation", validPasswordConfirmation);

        if (!user.getPassword().isEmpty() && !user.getPassword().isBlank() && validPasswordConfirmation){
            userData.add(user);
            model.addAttribute("users", userData.getAll());
            return "user/index";
        } else {
            return "user/add";
        }
    }

    @GetMapping("/add")
    public String displayAddUserForm(Model model){
        model.addAttribute("name", "");
        model.addAttribute("email", "");
        model.addAttribute("password", "");
        model.addAttribute("validPasswordConfirmation", true);
        return "user/add";
    }
    @GetMapping("/details/{id}")
    public String displayDetails(@PathVariable int id, Model model){
        User user = userData.getById(id);
        String formatedDate = user.getCreationDate().format(DateTimeFormatter.ofPattern("MM/dd/yyyy - HH:mm:ss Z"));

        model.addAttribute("user", userData.getById(id));
        model.addAttribute("formatedDate", formatedDate);
        return "user/details";
    }
}
