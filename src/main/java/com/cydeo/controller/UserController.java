package com.cydeo.controller;

import com.cydeo.dto.RoleDTO;
import com.cydeo.dto.UserDTO;
import com.cydeo.service.RoleService;
import com.cydeo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {
    RoleService roleService;
    UserService userService;

    public UserController(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @GetMapping("/create")
    public String createUser(Model model) {
        model.addAttribute("user", new UserDTO());
        model.addAttribute("roles", roleService.findAll());
        model.addAttribute("users", userService.findAll());//bring me all roles from dataBase
        return "user/create";
    }

    @PostMapping("/create")
    public String insertUser(UserDTO user, Model model) {
        //  model.addAttribute("user", new UserDTO());
        // model.addAttribute("roles", roleService.findAll());
        userService.save(user);
        // model.addAttribute("users", userService.findAll());//bring me all roles from dataBase


        return "redirect:/user/create"; //user attribute, roles attribute, users
    }

    //pathVariable - use to bring from browser {username}
    @GetMapping("/update/{username}")
    public String editUser(@PathVariable("username") String username, Model model) {
        // need to bring this username from pathvariable
        //what attribiutes i need to define -> (model.addAttribute)
        //user
        //roles
        //users

        model.addAttribute("user", userService.findById(username));
        model.addAttribute("roles", roleService.findAll());
        model.addAttribute("users", userService.findAll());//bring me all roles from dataBase
        return "/user/update";
    }

    @PostMapping("/update")
    public String updateUser(UserDTO userDTO) {
        userService.update(userDTO);
        return "redirect:/user/create";
    }

    @GetMapping("/delete/{username}")
    public String deleteUser(@PathVariable("username") String username) {
        userService.deleteById(username);
        return "redirect:/user/create";
    }
}
