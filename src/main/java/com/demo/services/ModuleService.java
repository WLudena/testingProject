package com.demo.services;

import com.demo.entities.ModuleEntity;
import com.demo.repositories.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ModuleService {
    @Autowired
    private ModuleRepository moduleRepository;

    public List<ModuleEntity> getAll(){
        ArrayList<ModuleEntity> modules = new ArrayList<>();
        moduleRepository.findAll().forEach(m->modules.add(m));
        return modules;
    }

    public ModuleEntity getById(int id){
        return moduleRepository.findById(id).get();
    }

    public void addModule(ModuleEntity newModule){
        moduleRepository.save(newModule);
    }

    public void removeModule(int id){
        moduleRepository.deleteById(id);
    }

    public void removeModule(ModuleEntity module){
        moduleRepository.delete(module);
    }

    public ModuleEntity editModule(ModuleEntity editedModule, int id){
        editedModule.setModuleId(id);
        moduleRepository.save(editedModule);
        return editedModule;
    }

}
