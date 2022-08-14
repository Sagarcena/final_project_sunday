package com.dbs.pay.controller;

import com.dbs.pay.model.customer;
import com.dbs.pay.repository.customerRespository;

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
@RequestMapping("/cc")
public class customerController {
    @Autowired
    private final customerRespository customerrepository;
    public customerController(customerRespository customerrepository) {
        this.customerrepository = customerrepository;
    }
    @GetMapping
    public List<customer> getCustomer() {
        return customerrepository.findAll();
    }
    @GetMapping("/{customerid}")
    public customer getCustomer(@PathVariable String customerid) {
        return customerrepository.findById(customerid).orElseThrow();
    }
}
