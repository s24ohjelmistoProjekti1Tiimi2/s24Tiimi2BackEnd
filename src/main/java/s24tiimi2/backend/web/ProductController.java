package s24tiimi2.backend.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import s24tiimi2.backend.domain.Manufacturer;
import s24tiimi2.backend.domain.ManufacturerRepository;
import s24tiimi2.backend.domain.Product;
import s24tiimi2.backend.domain.ProductRepository;
import s24tiimi2.backend.domain.TypeRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ProductController {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ManufacturerRepository manufacturerRepository;
    @Autowired
    private TypeRepository typeRepository;

    @GetMapping({ "/home", "/" })
    public String getHomePage() {
        return "index";
    }

    // Show product-list
    @GetMapping("/productlist")
    public String getAllProductsList(Model model) {
        model.addAttribute("products", productRepository.findAllActive());
        return "productlist";
    }

    // Add new product
    @GetMapping("/addproduct")
    public String addNewProduct(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("manufacturers", manufacturerRepository.findAll());
        model.addAttribute("types", typeRepository.findAll());
        return "addproduct";
    }

    // Save new product
    @PostMapping("/saveproduct")
    public String saveNewProduct(@Valid @ModelAttribute("product") Product product, BindingResult bindingResult,
            Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("manufacturers", manufacturerRepository.findAll());
            model.addAttribute("types", typeRepository.findAll());
            return "addproduct";
        } else {
            productRepository.save(product);
            return "redirect:/productlist";
        }
    }

    // Edit product
    @GetMapping("/edit-product/{id}")
    public String editProduct(@PathVariable("id") Long prodId, Model model) {
        model.addAttribute("product", productRepository.findById(prodId));
        model.addAttribute("manufacturers", manufacturerRepository.findAll());
        model.addAttribute("types", typeRepository.findAll());
        return "editproduct";
    }

    // Edit stock on product
    @GetMapping("/edit-stock/{id}")
    public String editStock(@PathVariable("id") Long prodId, Model model) {
        model.addAttribute("product", productRepository.findById(prodId));
        return "editstock";
    }

    // Save edited product
    @PostMapping("/savemodified")
    public String saveModified(@Valid @ModelAttribute("product") Product product, BindingResult bindingResult,
            Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("manufacturers", manufacturerRepository.findAll());
            model.addAttribute("types", typeRepository.findAll());
            return "editproduct";
        } else {
            productRepository.save(product);
            return "redirect:/productlist";
        }
    }

    // Save edited stock on product
    @PostMapping("/savestock")
    public String saveStock(@Valid @ModelAttribute("product") Product product, BindingResult bindingResult,
            Model model) {
        if (bindingResult.hasErrors()) {
            return "editstock";
        } else {
            productRepository.save(product);
            return "redirect:/productlist";
        }
    }
}
