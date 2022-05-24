package com.rafath.CRM.controller;

import com.rafath.CRM.dao.CustomerDAO;
import com.rafath.CRM.entity.Customer;
import com.rafath.CRM.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    //need to inject our customer service
    @Autowired
    private CustomerService customerService;

    @GetMapping("/list")
    public  String listCustomers(Model theModel){

        //get customer from dao
        List<Customer> theCustomers = customerService.getCustomers();

        //add the customers to the model
        theModel.addAttribute("customers",theCustomers);

        return "list-customers";
    }
    @InitBinder
    public void  initBinder(WebDataBinder dataBinder){
        StringTrimmerEditor trimmer = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, trimmer);
    }

    @GetMapping("/showFormAdd")
    public String showFormAdd(Model theModel){

        //create model attribute to bind the form data
        Customer theCustomer = new Customer();

        theModel.addAttribute("customer",theCustomer);

        return "customer-form";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@Valid @ModelAttribute("customer") Customer theCustomer, BindingResult theBindingResult){

        //save the customer using our service
        if(theBindingResult.hasErrors()){
            System.out.println(theBindingResult);

            return "customer-form";
        }
        customerService.saveCustomer(theCustomer);

        return "redirect:/customer/list";
    }

    @RequestMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("customerId") int theId,
                                    Model theModel, BindingResult theBindingResult){

        //get the customer from service
        Customer theCustomer = customerService.getCustomer(theId);

        //set customer as a model attribute to pre-populate the form
        theModel.addAttribute("customer",theCustomer);

        if(theBindingResult.hasErrors()){
            System.out.println(theBindingResult);
            return "customer-form";
        }
        //send over to our form
        return "customer-form";
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("customerId") int theId){

        //delete the customer
        customerService.deleteCustomer(theId);

        return "redirect:/customer/list";
    }
}
