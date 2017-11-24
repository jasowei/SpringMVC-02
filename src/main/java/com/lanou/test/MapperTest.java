package com.lanou.test;

import com.lanou.domain.Department;
import com.lanou.domain.Post;
import com.lanou.mapper.DepartmentMapper;
import com.lanou.service.DepartmentService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by dllo on 17/11/9.
 */
public class MapperTest {

    private ApplicationContext context;
    private DepartmentMapper departmentMapper;
    private DepartmentService departmentService;

    @Before
    public void init(){
        /*启动Spring容器*/
        context = new ClassPathXmlApplicationContext("spring-config.xml");
        departmentMapper =context.getBean(DepartmentMapper.class);
        departmentService = context.getBean(DepartmentService.class);
    }

    @Test
    public void findPostByDeptID(){
        Department department = departmentMapper.findPostByDeptID("2c9090e85f56b56f015f56b5ba5f0000");
        System.out.println(department);
        for (Post post : department.getPostList()) {
            System.out.println(post);
        }
    }

    @Test
    public void testService(){
        List<Department> departments = departmentService.findAll();
        for (Department department : departments) {
            System.out.println(department);

            Department department1 = departmentService.findPostsByDeptID(department.getDepID());
            for (Post post : department1.getPostList()) {
                System.out.println(post);
            }
            System.out.println("***************");
        }
    }

}
