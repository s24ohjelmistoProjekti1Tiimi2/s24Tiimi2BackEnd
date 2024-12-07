package s24tiimi2.backend.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import s24tiimi2.backend.domain.Customer;
import s24tiimi2.backend.domain.CustomerRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;

@Controller
public class CustomerController implements ErrorController {

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/customerlist")
    public String getCustomerList(Model model) {
        model.addAttribute("customers", customerRepository.findAll());
        return "customerlist";
    }

    @GetMapping("/addcustomer")
    public String addCustomer(Model model) {
        model.addAttribute("customer", new Customer());
        return "addcustomer";
    }

    @PostMapping("/savecustomer")
    public String saveCustomer(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult,
            Model model) {
        if (bindingResult.hasErrors()) {
            return "addcustomer";
        } else {
            customerRepository.save(customer);
            return "redirect:customerlist";
        }
    }

    @GetMapping("/delete-customer/{id}")
    public String deleteCustomer(@PathVariable("id") Long customerId, Model model) {
        customerRepository.deleteById(customerId);
        return "redirect:/customerlist";
    }

    @GetMapping("/edit-customer/{id}")
    public String editCustomer(@PathVariable("id") Long customerId, Model model) {
        model.addAttribute("customer", customerRepository.findById(customerId));
        return "editcustomer";
    }

    @PostMapping("/saveupdate")
    public String saveEditedCustomer(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult,
            Model model) {
        if (bindingResult.hasErrors()) {
            return "editcustomer";
        } else {
            customerRepository.save(customer);
            return "redirect:/customerlist";
        }
    }
}
