package com.lanou.service;

import com.lanou.domain.Department;

import java.util.List;

/**
 * Created by dllo on 17/11/9.
 */
public interface DepartmentService {

    List<Department> findAll();

    Department findPostsByDeptID(String id);

}
