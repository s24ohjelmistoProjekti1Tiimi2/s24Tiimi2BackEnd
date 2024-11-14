package s24tiimi2.backend.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import s24tiimi2.backend.domain.ManufacturerRepository;
import s24tiimi2.backend.domain.Product;
import s24tiimi2.backend.domain.ProductRepository;
import s24tiimi2.backend.domain.TypeRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ProductController {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ManufacturerRepository manufacturterRepository;
    @Autowired
    private TypeRepository typeRepository;

    // Show product-list
    @GetMapping("/productlist")
    public String getAllProductsList(Model model) {
        model.addAttribute("products", productRepository.findAll());
        return "productlist";
    }

    // Add new product
    @GetMapping("/addproduct")
    public String addNewProduct(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("manufacturer", manufacturterRepository.findAll());
        model.addAttribute("type", typeRepository.findAll());
        return "addproduct";
    }

    // Save new product
    @PostMapping("/saveproduct")
    public String saveNewProduct(Product product) {
        productRepository.save(product);
        return "redirect:/productlist";
    }

    // Delete product
    @GetMapping("/delete-product/{id}")
    public String deleteProduct(@PathVariable("id") Long productId, Model model) {
        productRepository.deleteById(productId);
        return "redirect:/productlist";
    }

    // Edit product
    @GetMapping("/edit/{id}")
    public String editProduct(@PathVariable("id") Long prodId, Model model) {
        model.addAttribute("product", productRepository.findById(prodId));
        model.addAttribute("manufacturers", manufacturterRepository.findAll());
        model.addAttribute("types", typeRepository.findAll());
        return "editproduct";
    }

    // Save edited product
    @PostMapping(value = "/savemodified")
    public String saveModified(Product product) {
        productRepository.save(product);
        return "redirect:/productlist";
    }

}
