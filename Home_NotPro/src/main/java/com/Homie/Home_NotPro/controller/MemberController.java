package com.Homie.Home_NotPro.controller;

import com.Homie.Home_NotPro.model.domain.*;
import com.Homie.Home_NotPro.model.wrapper.*;
import com.Homie.Home_NotPro.services.UtilService;
import com.Homie.Home_NotPro.services.MembersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/member")
public class MemberController {


    @Autowired
    private MembersService membersService;
    @Autowired
    private UtilService utilService;

    @PostMapping("/login")
    public MemberDomain login(
            @RequestBody(required = false) MemberWrapper w) {
        return membersService.login(w);
    }

    @PostMapping("/register")
    public MemberDomain register(
            @RequestBody(required = false) MemberWrapper w) {

        return membersService.register(w);
    }
}