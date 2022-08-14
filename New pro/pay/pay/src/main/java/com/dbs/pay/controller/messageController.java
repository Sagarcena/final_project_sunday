package com.dbs.pay.controller;

//import com.dbs.pay.model.currency;
import com.dbs.pay.model.message;
//import com.dbs.pay.repository.currencyRespository;
import com.dbs.pay.repository.messageRespository;

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
@RequestMapping("/mc")
public class messageController {
    @Autowired
    private final messageRespository messagerepository;
    public messageController(messageRespository messagerespository) {
        this.messagerepository = messagerespository;
    }
    @GetMapping
    public List<message> getCurrencycode() {
        return messagerepository.findAll();
    }
    @GetMapping("/{messagecode}")
    public message getCurrencycode(@PathVariable String messagecode) {
        return messagerepository.findById(messagecode).orElseThrow();
}
}
