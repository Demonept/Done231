package com.project.controller;

import com.project.model.User;
import com.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/")
public class UserController {

    private UserService userService;
    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }
    @GetMapping("/")
    public String getAllUsersPage(ModelMap model) {
        model.addAttribute("users", userService.listUsers());
        return "users";
    }
    @RequestMapping("/addNewUser")
    public String getAddUserPage(ModelMap model){
        User user = new User();
        model.addAttribute("user", user);
        return "adduser";
    }
    @PostMapping("/save")
    public String saveUser(@ModelAttribute("user") User user){
        userService.add(user);
        return "redirect:/";
    }
    @GetMapping("/user/{id}")
    public String getUserPage(@PathVariable Long id, ModelMap model){
        User user = userService.getUser(id);
        model.addAttribute("user", user);
        return "edituser";
    }
    @PatchMapping("{id}")
    public String updateUser(@ModelAttribute("user") User user){
        userService.update(user);
        return "redirect:/";
    }

    @GetMapping ("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/";
    }
}