package com.university.controller;

import com.university.entity.DepartmentEntity;
import com.university.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
