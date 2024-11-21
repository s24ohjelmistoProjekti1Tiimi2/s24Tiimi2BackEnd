package s24tiimi2.backend.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;
import s24tiimi2.backend.domain.Manufacturer;
import s24tiimi2.backend.domain.ManufacturerRepository;
import s24tiimi2.backend.domain.Product;
import s24tiimi2.backend.domain.ProductRepository;

@Controller
public class ManufacturerController {

    @Autowired
    private ManufacturerRepository manufacturerRepository;

    @Autowired
    private ProductRepository productRepository;

    // Show manufacturer-list
    @GetMapping("/manufacturerlist")
    public String getAllManufacturersList(Model model) {
        model.addAttribute("manufacturers", manufacturerRepository.findAll());
        return "manufacturerlist";
    }

    // Add new manufacturer
    @GetMapping("/addmanufacturer")
    public String addNewManufacturer(Model model) {
        model.addAttribute("manufacturer", new Manufacturer());
        return "addmanufacturer";
    }

    // Save new manufacturer
    @PostMapping("/savemanufacturer")
    public String saveNewManufacturer(@Valid @ModelAttribute("manufacturer") Manufacturer manufacturer,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "addmanufacturer";
        } else {
            manufacturerRepository.save(manufacturer);
            return "redirect:/manufacturerlist";
        }
    }

    // Delete manufacturer
    @GetMapping("/delete-manufacturer/{id}")
    public String deleteManufacturer(@PathVariable("id") Long manufacturerId, Model model) {
        manufacturerRepository.deleteById(manufacturerId);
        return "redirect:/manufacturerlist";
    }

    // Edit manufacturer
    @GetMapping("/edit-manufacturer/{id}")
    public String editManufacturer(@PathVariable("id") Long manufacturerId, Model model) {
        model.addAttribute("manufacturers", manufacturerRepository.findById(manufacturerId));
        return "editmanufacturer";
    }

    @GetMapping("/saveedit/{id}")
    public String saveEditedManufacturer(@Valid @ModelAttribute("manufacturer") Manufacturer manufacturer,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "editmanufacturer";
        } else {
            manufacturerRepository.save(manufacturer);
            return "redirect:/manufacturerlist";
        }
    }

    // Products by a manufacturer endpoints

    // Find all manufacturers
    @GetMapping("/productsbymanufacturer")
    public String showSearch(Model model) {
        model.addAttribute("manufacturers", manufacturerRepository.findAll());
        return "manufacturersproducts";
    }

    // Search and show products by manufacturer
    @PostMapping("/productsbymanufacturer")
    public String searchProductsByManufacturer(@RequestParam("manufacturerId") Long manufacturerId, Model model) {
        Manufacturer manufacturer = manufacturerRepository.findById(manufacturerId).orElse(null);
        List<Product> products = productRepository.findByManufacturer_Id(manufacturerId);
        model.addAttribute("products", products);
        model.addAttribute("manufacturer", manufacturer);
        model.addAttribute("manufacturers", manufacturerRepository.findAll());
        return "manufacturersproducts";
    }
}
