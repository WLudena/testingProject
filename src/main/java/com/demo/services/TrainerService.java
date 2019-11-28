package com.demo.services;

import com.demo.entities.Trainer;
import com.demo.repositories.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrainerService {

    @Autowired
    private TrainerRepository trainerRepository;

    public void addTrainer(Trainer trainer){
        trainerRepository.save(trainer);
    }

    public void removeTrainer(int id){
        trainerRepository.deleteById(id);
    }

    public List<Trainer> listOfTrainers(){
        List<Trainer> trainerList = new ArrayList<>();
        trainerRepository.findAll().forEach(trainer -> trainerList.add(trainer));
        return trainerList;
    }

    public Trainer getTrainer(int id){
        return trainerRepository.findById(id).get();
    }

    public void updateTrainer(Trainer trainer, int id){
        trainer.setId(id);
        trainerRepository.save(trainer);
    }


}
