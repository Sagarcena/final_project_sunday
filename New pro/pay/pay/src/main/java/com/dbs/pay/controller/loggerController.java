package com.dbs.pay.controller;


import com.dbs.pay.model.logger;
import com.dbs.pay.repository.loggerRespository;

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
@RequestMapping("/lc")
public class loggerController {
    @Autowired
    private final loggerRespository loggerrepository;
    public loggerController(loggerRespository loggerrespository) {
        this.loggerrepository = loggerrespository;
    }
    @GetMapping
    public List<logger> getLogger() {
        return loggerrepository.findAll();
    }
    @GetMapping("/{loggerid}")
    public logger getLogger(@PathVariable Long loggerid) {
        return loggerrepository.findById(loggerid).orElseThrow();
}
}
