package s24tiimi2.backend.web;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import s24tiimi2.backend.domain.Customer;
import s24tiimi2.backend.domain.CustomerRepository;
import s24tiimi2.backend.domain.Manufacturer;
import s24tiimi2.backend.domain.ManufacturerRepository;
import s24tiimi2.backend.domain.Product;
import s24tiimi2.backend.domain.ProductRepository;

@Controller
public class SoftDeleteController {

    @Autowired
    private ManufacturerRepository manufacturerRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CustomerRepository customerRepository;

    // Show deleted products and manufacturers
    @GetMapping("/deleted")
    public String getDeletedProducts(Model model) {
        model.addAttribute("products", productRepository.findAllDeleted());
        model.addAttribute("manufacturers", manufacturerRepository.findAllDeleted());
        model.addAttribute("customers", customerRepository.findAllDeleted());
        return "deleted";
    }

    // Soft delete product
    @GetMapping("/softdelete-product/{id}")
    public String deleteProduct(@PathVariable("id") Long prodId, Model model) {
        Product product = productRepository.findById(prodId).get();
        product.setDeleted(true);
        productRepository.save(product);
        return "redirect:/productlist";
    }

    // Soft delete manufacturer
    @GetMapping("/softdelete-manufacturer/{id}")
    public String deleteManufacturer(@PathVariable("id") Long manufacturerId, Model model) {
        if (productRepository.existsByManufacturerId(manufacturerId)) {
            model.addAttribute("error", "The manufacturer has products! Select one without products.");
            return "manufacturerlist";
        }
        Manufacturer manufacturer = manufacturerRepository.findById(manufacturerId).get();
        manufacturer.setDeleted(true);
        manufacturerRepository.save(manufacturer);
        return "redirect:/manufacturerlist";
    }

    // restore manufacturer
    @PostMapping("/restore-manufacturer/{id}")
    public String restoreDeletedManufacturer(@PathVariable("id") Long manufacturerId) {
        Manufacturer manufacturer = manufacturerRepository.findById(manufacturerId).get();
        manufacturer.setDeleted(false);
        manufacturerRepository.save(manufacturer);
        return "redirect:/manufacturerlist";
    }

    // restore product
    @PostMapping("/restore-product/{id}")
    public String restoreDeletedProduct(@PathVariable("id") Long productId) {
        Product product = productRepository.findById(productId).get();
        product.setDeleted(false);
        productRepository.save(product);
        return "redirect:/productlist";
    }

}
