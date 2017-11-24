package com.lanou.controller;

import com.lanou.domain.Department;
import com.lanou.domain.Post;
import com.lanou.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @RequestMapping("/hr")  : 在类上面定义的注解, 代表该类中的所有方法前都需要加的路径
 *                          相当于struts2中的package
 */

@RequestMapping("/hr")
@Controller
public class DeptController {

    @Autowired
    @Qualifier("departmentService")
    private DepartmentService departmentService;


    /**
     * 查询部门集合, 返回json数据
     * 访问地址:  /hr/findAll
     */
    @ResponseBody
    @RequestMapping(value = "/findAll")
    public List<Department> findAll(){

        //业务层获取部门集合
        return departmentService.findAll();
    }

    /**
     * 根据部门id查职务集合, 返回json数据
     * 访问地址: /hr/findPostByDeptID
     * @param deptID
     * @return
     */
    @ResponseBody
    @RequestMapping("/findPostByDeptID")
    public List<Post> findPostByDepiID(String deptID){
        Department department = departmentService.findPostsByDeptID(deptID);
        if (department != null){
            List<Post> postList = department.getPostList();
            return postList;
        }
        return null;
    }

}
