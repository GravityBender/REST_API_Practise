package com.restpractise.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/api")
public class FetchController {

    @GetMapping("/FetchNextNumber")
    public Map<String, Integer> FetchNextNumber() {
        Map<String, Integer> dataMap = new HashMap<>();

        return dataMap;
    }

}
