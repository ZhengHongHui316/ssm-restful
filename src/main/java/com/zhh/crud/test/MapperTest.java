package com.zhh.crud.test;


import com.zhh.crud.bean.Employee;
import com.zhh.crud.dao.DepartmentMapper;
import com.zhh.crud.dao.EmployeeMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

/**
 * 测试dao层的工作
 * @Author zhh
 * @Date 2019/5/28 18:27
 * @Version 1.0
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class MapperTest {
    @Autowired
    DepartmentMapper departmentMapper;

    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    SqlSession sqlSession;
    /** 
    * @Author zhh
    * @Description //TODO 测试DepartmentMapper
    * @Date 18:28 2019/5/28 
    * @Param [] 
    * @return void 
    **/ 
    @Test
    public void testCrud(){
        /*	//1、创建SpringIOC容器
		ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
		//2、从容器中获取mapper
		DepartmentMapper bean = ioc.getBean(DepartmentMapper.class);*/
        System.out.println(departmentMapper);
        //1、插入几个部门
//		departmentMapper.insertSelective(new Department(null, "开发部"));
//		departmentMapper.insertSelective(new Department(null, "测试部"));
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        for(int i = 0;i<1000;i++){
            String uid = UUID.randomUUID().toString().substring(0,5)+i;
            mapper.insertSelective(new Employee(null,uid, "M", uid+"@atguigu.com", 1));
        }
        System.out.println("批量完成");
    }
}
