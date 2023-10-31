//package com.Homie.Home_NotPro.controller;
//
//import com.Homie.Home_NotPro.model.domain.UtilDomain;
//import com.Homie.Home_NotPro.services.DeleteService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping(value = "/api/v1/secure/data")
//public class DeleteDataController {
//    @Autowired
//    DeleteService deleteService;
//    @DeleteMapping("/delete")
//    public UtilDomain remove(@RequestParam("id") String idLocker) {
//        return deleteService.remove(idLocker);
//    }
//}
