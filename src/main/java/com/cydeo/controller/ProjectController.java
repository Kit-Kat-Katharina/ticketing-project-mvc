package com.cydeo.controller;

import com.cydeo.dto.RoleDTO;
import com.cydeo.service.ProjectService;
import com.cydeo.service.RoleService;
import com.cydeo.service.impl.AbstractMapService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/project")
public class ProjectController {
@GetMapping("/create")
    public String createProject(){
        return "/project/create";
    }
}
