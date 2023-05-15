package com.university.collection;

import com.university.entity.DepartmentEntity;

import java.util.ArrayList;
import java.util.Collection;

public class Departments extends ArrayList<DepartmentEntity> {
    public Departments(int initialCapacity) {
        super(initialCapacity);
    }

    public Departments() {
    }

    public Departments(Collection<? extends DepartmentEntity> departmentCollection) {
        super(departmentCollection);
    }
}
