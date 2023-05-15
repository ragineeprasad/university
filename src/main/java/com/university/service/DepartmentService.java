package com.university.service;

import com.university.collection.Departments;
import com.university.entity.DepartmentEntity;
import com.university.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository repository;

    public void createDepartment(DepartmentEntity entity){
        repository.save(entity);
    }
    public Departments getAllDepartment(){
        List<DepartmentEntity> departmentEntities = repository.findAll();
        return new Departments(departmentEntities);
    }
    public Optional<DepartmentEntity> getDepartmentById(UUID id){
        return repository.findById(id);
    }
    public void deleteDepartmentById(UUID id){
        repository.deleteById(id);
    }
    public void updateDepartment(DepartmentEntity entity){
        repository.save(entity);
    }
    public boolean existById(UUID id){
        return repository.existsById(id);
    }

}
