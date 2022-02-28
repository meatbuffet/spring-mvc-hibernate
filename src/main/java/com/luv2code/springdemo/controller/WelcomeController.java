package com.luv2code.springdemo.controller;

import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class WelcomeController {
    @Autowired
    private CustomerService customerService;

    @RequestMapping("/")
    public String listCustomers(Model model) {

        // get customers from the dao
        List<Customer> theCustomers = customerService.getCustomers();

        //add the customers to the model
        model.addAttribute("customers", theCustomers);

        return "list-customers";
    }
}
