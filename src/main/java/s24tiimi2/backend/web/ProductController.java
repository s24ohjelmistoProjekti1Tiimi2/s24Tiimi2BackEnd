package s24tiimi2.backend.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import s24tiimi2.backend.domain.Manufacturer;
import s24tiimi2.backend.domain.ManufacturerRepository;
import s24tiimi2.backend.domain.Product;
import s24tiimi2.backend.domain.ProductRepository;
import s24tiimi2.backend.domain.TypeRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController {

    @Autowired
    private ProductRepository repository;
    @Autowired
    private ManufacturerRepository manufRepo;
    @Autowired
    private TypeRepository typeRepo;

    @GetMapping("/productlist")
    public String getAllProductsList(Model model) {
        model.addAttribute("products", repository.findAll());
        return "productlist";
    }

    @GetMapping("/addproduct")
    public String addNewProduct(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("manufacturer", manufRepo.findAll());
        model.addAttribute("type", typeRepo.findAll());
        return "addproduct";
    }

    @PostMapping("/saveproduct")
    public String saveNewProduct(Product product) {
        repository.save(product);
        return "redirect:/productlist";
    }

    @GetMapping("/delete-product/{id}")
    public String deleteProduct(@PathVariable("id") Long productId, Model model) {
        repository.deleteById(productId);
        return "redirect:/productlist";
    }

    //Manufacturer endpoints
    @GetMapping("/addmanufacturer")
    public String addNewManufacturer(Model model) {
        model.addAttribute("manufacturer", new Manufacturer());
        return "addmanufacturer";
    }

    @PostMapping("/savemanufacturer")
    public String saveNewManufacturer(Manufacturer manufacturer) {
        manufRepo.save(manufacturer);
        return "redirect:/productlist";
    }

    // FUNCTIONS ACTIVATED DURING THE EDITING OF BOOKS IN BOOKLIST.HTML AND
    // EDITBOOK.HTML

    @RequestMapping(value = "/edit/{id}")
    public String editBook(@PathVariable("id") Long prodId, Model model) {
        model.addAttribute("selectedProduct", repository.findById(prodId));
        model.addAttribute("manufacturers", manufRepo.findAll());
        model.addAttribute("types", typeRepo.findAll());
        return "editproduct";
    }

    @PostMapping(value = "/savemodified")
    public String saveModified(Product newProd) {
        repository.save(newProd);
        return "redirect:/productlist";
    }

}
