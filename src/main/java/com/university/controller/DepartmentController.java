package com.university.controller;

import com.university.entity.DepartmentEntity;
import com.university.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<List<DepartmentEntity>> getAllDepartment(){
        List<DepartmentEntity> entities =service.getAllDepartment();
        return new ResponseEntity<List<DepartmentEntity>>(entities.stream().toList(), HttpStatus.NO_CONTENT);
    }
    @GetMapping
    @RequestMapping(path = "/{id}")
    public ResponseEntity<DepartmentEntity> getDepartmentById(@RequestParam(name = "id") UUID id){
        Optional<DepartmentEntity> entity = service.getDepartmentById(id);
        if(entity.isEmpty()){
            return new ResponseEntity<DepartmentEntity>(HttpStatus.BAD_REQUEST);
        }else {
            return new ResponseEntity<DepartmentEntity>(entity.get(), HttpStatus.OK);
        }
    }
    @DeleteMapping
    @RequestMapping(path = "/deleteDepartment/{id}")
    public ResponseEntity<Void> deleteDepartmentById(@RequestParam(name = "id") UUID id){
        service.deleteDepartmentById(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
    @PutMapping
    @RequestMapping(path = "/updateDepartment")
    public ResponseEntity<Void> updateDepartment(DepartmentEntity entity){
        service.updateDepartment(entity);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
