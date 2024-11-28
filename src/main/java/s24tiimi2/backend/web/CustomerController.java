package s24tiimi2.backend.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import s24tiimi2.backend.domain.CustomerRepository;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/customerlist")
    public String getCustomerList(Model model) {
        model.addAttribute("customers", customerRepository.findAll());
        return "customers";
    }
}
