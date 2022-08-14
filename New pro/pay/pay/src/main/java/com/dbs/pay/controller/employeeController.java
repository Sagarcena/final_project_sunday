package com.dbs.pay.controller;

//import com.dbs.pay.model.customeruser;
import com.dbs.pay.model.employee;
//import com.dbs.pay.repository.customeruserRespository;
import com.dbs.pay.repository.employeeRespository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@CrossOrigin("*")
@Controller
@ResponseBody
@RequestMapping("/ec")
public class employeeController {
    @Autowired
    private final employeeRespository employeerepository;
    public employeeController(employeeRespository employeerepository) {
        this.employeerepository = employeerepository;
    }
    @GetMapping
    public List<employee> getEmployee() {
        return employeerepository.findAll();
    }
    @GetMapping("/{employeeid}")
    public employee getEmployee(@PathVariable Long employeeid) {
        return employeerepository.findById(employeeid).orElseThrow();
}
}
