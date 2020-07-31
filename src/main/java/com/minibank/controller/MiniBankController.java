package com.minibank.controller;

import com.minibank.service.MiniBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping(value = "/minibank")
//@RestController(value = "/minibank") //todo
public class MiniBankController {

    @Autowired
    private MiniBankService service;

    @PostMapping(value = "/transferMoney", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void transferMoney(@RequestBody String body) throws Exception {
        service.transferMoney(body);
    }

}
