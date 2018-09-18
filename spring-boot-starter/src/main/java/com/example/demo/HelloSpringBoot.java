package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloSpringBoot {

//    @Value("${NBA.Rocket}")
//    private String rocket;
//
//    @Value("${NBA.Lakers}")
//    private String lakers;

    @Autowired
    NbaBean nbaBean;

    @Value(("${Conclusion}"))
    private String conclusion;


    @RequestMapping(value = {"/","hi"}, method = RequestMethod.GET)
    public String nba(){
//        return nbaBean.getLakers();
        return "index";
    }

//    @RequestMapping(value="/say/{id}", method = RequestMethod.GET)
//    public String say(@PathVariable("id") Integer id){
//        return "id" + id;
//    }

    @RequestMapping(value="/say", method = RequestMethod.GET)
    public String say(@RequestParam(value = "id", required = false, defaultValue = "0") Integer id){
        return "id" + id;
    }
}
