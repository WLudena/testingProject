package com.demo.controllers;

import com.demo.entities.ModuleEntity;
import com.demo.services.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class ModuleController {
    @Autowired
    private ModuleService moduleService;

    @GetMapping("/module/getModules")
    public String getModules(Model model) {
        model.addAttribute("modules", moduleService.getAll());
        return "createCourse";
    }

    @GetMapping("/module/getModule/{id}")
    public String getModule(@PathVariable("id") int id, Model model) {
        model.addAttribute("modules", moduleService.getById(id));
        return "";
    }


    @PostMapping("/module/addModule")
    public String addModule(@Valid ModuleEntity newModule) {
        moduleService.addModule(newModule);
        return "";
    }

    @GetMapping("/module/editModule/{id}")
    public String editModule(@Valid ModuleEntity editedModule, @PathVariable("id") int id) {
        moduleService.editModule(editedModule, id);
        return "";
    }

    @GetMapping("/module/removeModule/{id}")
    public String removeModule(@PathVariable("id") int id) {
        moduleService.removeModule(id);
        return "";
    }
}
