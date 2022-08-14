package com.dbs.pay.controller;

//import com.dbs.pay.model.currency;
import com.dbs.pay.model.transfertypes;
//import com.dbs.pay.repository.currencyRespository;
import com.dbs.pay.repository.transfertypesRespository;

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
@RequestMapping("/ttc")

public class transfertypesController {
    @Autowired
    private final transfertypesRespository transfertypesrepository;
    public transfertypesController(transfertypesRespository transfertypesrespository) {
        this.transfertypesrepository = transfertypesrespository;
    }
    @GetMapping
    public List<transfertypes> getTransfertypes() {
        return transfertypesrepository.findAll();
    }
    @GetMapping("/{transfercode}")
    public transfertypes getTransfertypes(@PathVariable String transfercode) {
        return transfertypesrepository.findById(transfercode).orElseThrow();
}
}
