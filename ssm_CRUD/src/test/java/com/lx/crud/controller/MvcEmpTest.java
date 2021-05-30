package com.lx.crud.controller;

import com.github.pagehelper.PageInfo;
import com.lx.crud.bean.Employee;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

/**
 * @author lixun Email:lx3027@126.com
 * @create 2021-05-11 19:38
 * 使用Spring测试模块提供的测试请求功能，测试CRUD请求的正确性
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:applicationContext.xml","file:src/main/webapp/WEB-INF/dispatcherServlet-servlet.xml"})
public class MvcEmpTest {

    //传入SpringMVC的IOC
    @Autowired
    WebApplicationContext context;

    //虚拟MVC请求，获取到处理请求
    MockMvc mockMvc;

    @Before
    public void initMockMvc(){
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void testPage() throws Exception {
        //模拟请求拿到返回值
        MvcResult pn = mockMvc.perform(MockMvcRequestBuilders.get("/emps")
                .param("pn", "5")).andReturn();
        //请求成功以后，请区域中会有pag'eInfo，我们可以取出pageInfo进行验证
        MockHttpServletRequest request = pn.getRequest();
        PageInfo pageInfo = (PageInfo) request.getAttribute("pageInfo");
        System.out.println("当前页码：" + pageInfo.getPageNum());
        System.out.println("总页码：" + pageInfo.getPages());
        System.out.println("总记录数：" + pageInfo.getTotal());
        System.out.println("在页面需要显示的页码：");
        int[] nums = pageInfo.getNavigatepageNums();
        for (int num : nums) {
            System.out.print(" "+num);
        }
        //获取员工数据
        List<Employee> list = pageInfo.getList();
        for (Employee employee : list) {

            System.out.println("员工ID："+employee.getEmpId()+"-->姓名："+employee.getEmpName());

        }
    }


}
