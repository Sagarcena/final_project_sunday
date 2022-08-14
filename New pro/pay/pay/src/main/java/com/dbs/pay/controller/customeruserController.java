package com.dbs.pay.controller;

//import com.dbs.pay.model.customer;
import com.dbs.pay.model.customeruser;
//import com.dbs.pay.repository.customerRespository;
import com.dbs.pay.repository.customeruserRespository;

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
@RequestMapping("/cuc")
public class customeruserController {
    @Autowired
    private final customeruserRespository customeruserrepository;
    public customeruserController(customeruserRespository customeruserrepository) {
        this.customeruserrepository = customeruserrepository;
    }
    @GetMapping
    public List<customeruser> getCustomeruser() {
        return customeruserrepository.findAll();
    }
    @GetMapping("/{userid}")
    public customeruser getCustomeruser(@PathVariable String userid) {
        return customeruserrepository.findById(userid).orElseThrow();
}
}
