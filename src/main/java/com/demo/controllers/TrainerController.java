package com.demo.controllers;

import com.demo.entities.Trainer;
import com.demo.services.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
public class TrainerController {

    @Autowired
    private TrainerService trainerService;

    @RequestMapping("/trainerForm")
    public String trainerForm(){
        return "trainerForm";
    }

    @PostMapping("/add")
    public String addTrainer(@Valid Trainer trainer){
        trainerService.addTrainer(trainer);
        return "added";
    }

    @GetMapping("/delete/{id}")
    public String deleteTrainer(@PathVariable("id") int id) {
        trainerService.removeTrainer(id);
        return "displayTrainers";
    }

    @GetMapping("/trainers")
    public String findAllTrainer(Model model){
        model.addAttribute("trainers", trainerService.listOfTrainers());
        return "displayTrainers";
    }

    @GetMapping("/test")
    public String test(Model model){
        model.addAttribute("trainer", trainerService.getTrainer(1));
        return "updateTrainer";
    }


    @GetMapping("/find/{id}")
    public String findTrainer(@PathVariable("id") int id, Model model){
        model.addAttribute("trainer", trainerService.getTrainer(id));
        return "displayTrainer";
    }

    @GetMapping("/update/{id}")
    public String updateTrainer(@PathVariable("id") int id, @Valid Trainer trainer){
        trainerService.updateTrainer(trainer,id);
        return "updateTrainer";
    }

}
