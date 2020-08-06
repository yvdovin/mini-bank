package com.minibank.controller;

import com.minibank.service.MiniBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/minibank")
@RestController()
//@Controller
public class MiniBankController {

    @Autowired
    private MiniBankService service;

    @PostMapping(value = "/transferMoney", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void transferMoney(@RequestBody String body) throws Exception {
        service.transferMoney(body);
    }

    @GetMapping(value = "/get")
    public String get() {
        return "Hello";
    }

    @GetMapping(value = "/get1")
    public String get1() {
        return "Hello";
    }

}
