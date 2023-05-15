package com.university.controller;

import com.university.collection.Departments;
import com.university.entity.DepartmentEntity;
import com.university.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(path = "/department")
public class DepartmentController {
    @Autowired
    private DepartmentService service;
    @GetMapping(path = "/test")
    public String test(){
        return "Welcome To Java";
    }
    @PostMapping
    public ResponseEntity<Void> createDepartment(@RequestBody DepartmentEntity entity){
        service.createDepartment(entity);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
    @GetMapping
    public ResponseEntity<Departments> getAllDepartment(){
        Departments departments = service.getAllDepartment();
        return new ResponseEntity<Departments>(departments, HttpStatus.OK);
    }
//    @GetMapping
    @GetMapping(path = "/{id}")
    public ResponseEntity<DepartmentEntity> getDepartmentById(@PathVariable UUID id){
        Optional<DepartmentEntity> entity = service.getDepartmentById(id);
        if(entity.isEmpty()){
            return new ResponseEntity<DepartmentEntity>(HttpStatus.BAD_REQUEST);
        }else {
            return new ResponseEntity<DepartmentEntity>(entity.get(), HttpStatus.OK);
        }
    }
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteDepartmentById(@PathVariable UUID id) {
        service.deleteDepartmentById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping(path = "/{id}")
    public ResponseEntity<Void> updateDepartment(@PathVariable UUID id, @RequestBody DepartmentEntity entity){
        service.updateDepartment(entity);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
