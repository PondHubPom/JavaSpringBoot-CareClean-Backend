package com.Homie.Home_NotPro.test;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")

public class TestApi {

    @RequestMapping("/employees")
    public String TestMe(){
        return"id: 1 \n firstname: Luke \n lastname: Skywalker \n role: Jedi";
    }
}
