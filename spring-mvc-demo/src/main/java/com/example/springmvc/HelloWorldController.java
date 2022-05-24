package com.example.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {

    // add controller to show the form

    @RequestMapping("/showForm")
    public String showForm(){
        return "helloworld-form";
    }

    // add controller to process the form and add the data to the model
    @RequestMapping("/processForm")
    public String processForm(){
        return "helloworld";
    }

    //new acontroller method to read form data and
    //add data to the model


    @RequestMapping("/processFormVersionTwo")
    public String letShoutDude(HttpServletRequest request, Model model) {

        //read the reques parameter from the HTML form
        String theName = request.getParameter("studentName");
        theName = theName.toUpperCase();
        String result = "Yo, wass up !" + theName;
        model.addAttribute("message", result);

        return "helloworld";
    }

    @RequestMapping("/three")
    public String three(
            @RequestParam("studentName") String theName,
            Model model) {

        //read the reques parameter from the HTML form
        //String theName = request.getParameter("studentName");
        theName=theName.toUpperCase();
        String result="Hey, good evening!" + theName;
        model.addAttribute("message",result);

        return "helloworld";
    }
}