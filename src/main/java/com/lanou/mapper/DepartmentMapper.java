package com.lanou.mapper;

import com.lanou.domain.Department;

import java.util.List;

/**
 * Created by dllo on 17/11/9.
 */
public interface DepartmentMapper {

    List<Department> findAll();

    Department findById(String deptID);

    /**
     * 根据部门id查询带职务集合的部门对象
     * @param deptID
     * @return
     */
    Department findPostByDeptID(String deptID);
}
