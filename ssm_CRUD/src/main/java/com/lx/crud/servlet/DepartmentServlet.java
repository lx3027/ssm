package com.lx.crud.servlet;

import com.lx.crud.bean.Department;
import com.lx.crud.dao.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lixun Email:lx3027@126.com
 * @create 2021-05-12 16:27
 */
@Service
public class DepartmentServlet {

    @Autowired
    private DepartmentMapper departmentMapper;

    public List<Department> getDepts() {
        List<Department> departments = departmentMapper.selectByExample(null);
        return departments;
    }
}
