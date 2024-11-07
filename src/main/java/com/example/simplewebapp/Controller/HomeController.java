package com.example.simplewebapp.Controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@Controller
public class HomeController {

    @RequestMapping("/")
//    @ResponseBody
    public String home() {
        System.out.println("Hey do you see me ?");
        return "Hello Joice";
    }

    @RequestMapping("/about")
    public String aboutPage() {
        return "This is a about page.";
    }
}
