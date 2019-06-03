package com.zhh.crud.service;

import com.zhh.crud.bean.Department;
import com.zhh.crud.dao.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author zhh
 * @Date 2019/5/29 0:55
 * @Version 1.0
 **/
@Service
public class DepartmentService {
    @Autowired
    private DepartmentMapper departmentMapper;

    public List<Department> getDepts() {
        // TODO Auto-generated method stub
        List<Department> list = departmentMapper.selectByExample(null);
        return list;
    }

}
