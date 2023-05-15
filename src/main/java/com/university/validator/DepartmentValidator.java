package com.university.validator;

import com.university.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class DepartmentValidator {
    @Autowired
    private DepartmentService departmentService;

    public boolean validateDepartmentExists(UUID id){
        return departmentService.existById(id);
    }
}
