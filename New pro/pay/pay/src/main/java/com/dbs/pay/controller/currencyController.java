package com.dbs.pay.controller;

import com.dbs.pay.model.currency;
import com.dbs.pay.repository.currencyRespository;

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
@RequestMapping("/cu")
public class currencyController {
    @Autowired
    private final currencyRespository currencyrepository;
    public currencyController(currencyRespository currencyrespository) {
        this.currencyrepository = currencyrespository;
    }
    @GetMapping
    public List<currency> getCurrencycode() {
        return currencyrepository.findAll();
    }
    @GetMapping("/{currencycode}")
    public currency getCurrencycode(@PathVariable String currencycode) {
        return currencyrepository.findById(currencycode).orElseThrow();
    }
}
