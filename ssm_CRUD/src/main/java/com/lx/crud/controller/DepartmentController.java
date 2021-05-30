package com.lx.crud.controller;

import com.lx.crud.bean.Department;
import com.lx.crud.bean.Msg;
import com.lx.crud.servlet.DepartmentServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author lixun Email:lx3027@126.com
 * @create 2021-05-12 16:25
 * 处理和部门有关的
 */
@Controller
public class DepartmentController {

    @Autowired
    private DepartmentServlet departmentServlet;

    /**
     * 返回所有的部门
     */
    @RequestMapping("/depts")
    @ResponseBody
    public Msg getDepts(){
        //查出所有的部门信息
        List<Department> list = departmentServlet.getDepts();
        return Msg.success().add("depts",list);
    }

}
