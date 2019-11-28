package com.demo.repositories;

import com.demo.entities.Trainer;
import org.springframework.data.repository.CrudRepository;

public interface TrainerRepository extends CrudRepository<Trainer,Integer> {
}
