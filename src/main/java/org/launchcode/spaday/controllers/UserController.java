package org.launchcode.spaday.controllers;

import org.launchcode.spaday.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("user")
public class UserController {
    @PostMapping
    public String user(Model model, @ModelAttribute User user, String verify){
        model.addAttribute("name", user.getName());
        model.addAttribute("email", user.getEmail());
        model.addAttribute("password", user.getPassword());
        model.addAttribute("validationFailed", (verify.equals(user.getPassword())));

        return (verify.equals(user.getPassword()))? "user/index" : "user/add";
    }

    @GetMapping("add")
    public String displayAddUserForm(Model model){
        model.addAttribute("name", "");
        model.addAttribute("email", "");
        model.addAttribute("password", "");
        return "user/add";
    }
}
