package s24tiimi2.backend.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import s24tiimi2.backend.domain.Customer;
import s24tiimi2.backend.domain.CustomerRepository;

import jakarta.validation.Valid;

@Controller
public class CustomerController implements ErrorController {

    @Autowired
    private CustomerRepository customerRepository;

    // Show customer-list
    @GetMapping("/customerlist")
    public String getCustomerList(Model model) {
        model.addAttribute("customers", customerRepository.findAllActive());
        return "customerlist";
    }

    // Add new customer
    @GetMapping("/addcustomer")
    public String addCustomer(Model model) {
        model.addAttribute("customer", new Customer());
        return "addcustomer";
    }

    // Save new customer
    @PostMapping("/savecustomer")
    public String saveCustomer(@Valid Customer customer, BindingResult bindingResult,
            Model model) {
        if (bindingResult.hasErrors()) {
            return "addcustomer";
        } else {
            customerRepository.save(customer);
            return "redirect:customerlist";
        }
    }

    // Permanently delete customer
    @GetMapping("/delete-customer/{id}")
    public String deleteCustomer(@PathVariable("id") Long customerId, Model model) {
        customerRepository.deleteById(customerId);
        return "redirect:/customerlist";
    }

    // Edit customer
    @GetMapping("/edit-customer/{id}")
    public String editCustomer(@PathVariable("id") Long customerId, Model model) {
        model.addAttribute("customer", customerRepository.findById(customerId));
        return "editcustomer";
    }

    // Save edited customer
    @PostMapping("/saveupdate")
    public String saveEditedCustomer(@Valid Customer customer, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "editcustomer";
        } else {
            customerRepository.save(customer);
            return "redirect:/customerlist";
        }
    }
}
