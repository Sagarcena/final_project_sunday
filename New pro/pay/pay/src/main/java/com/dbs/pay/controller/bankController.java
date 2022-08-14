package com.dbs.pay.controller;

import com.dbs.pay.model.bank;
import com.dbs.pay.repository.bankRespository;

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
@RequestMapping("/")
public class bankController {
    @Autowired
 
    private final bankRespository bankrepository;
    public bankController(bankRespository bankrepository) {
        this.bankrepository = bankrepository;
    }
    @GetMapping
    public List<bank> getBanks() {
        return bankrepository.findAll();
    }
    @GetMapping("/{bic}")
    public bank getBanks(@PathVariable String bic) {
        return bankrepository.findById(bic).orElseThrow();
    }
}
