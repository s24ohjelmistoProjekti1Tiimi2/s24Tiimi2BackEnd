package s24tiimi2.backend.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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

    // Show deleted products and manufacturers
    @GetMapping("/deleted")
    public String getDeletedProducts(Model model) {
        model.addAttribute("products", productRepository.findAllDeleted());
        model.addAttribute("manufacturers", manufacturerRepository.findAllDeleted());
        return "deleted";
    }

    // Delete product
    @GetMapping("/delete-product/{id}")
    public String deleteProduct(@PathVariable("id") Long prodId, Model model) {
        // productRepository.deleteById(prodId);
        Product product = productRepository.findById(prodId).get();
        product.setDeleted(true);
        productRepository.save(product);
        return "redirect:/productlist";
    }

    // Delete manufacturer
    @GetMapping("/delete-manufacturer/{id}")
    public String deleteManufacturer(@PathVariable("id") Long manufacturerId, Model model) {
        if (productRepository.existsByManufacturerId(manufacturerId)) {
            model.addAttribute("error", "The manufacturer has products! Select one without products.");
            return "manufacturerlist";
        }
        // hard delete: manufacturerRepository.deleteById(manufacturerId);
        Manufacturer manufacturer = manufacturerRepository.findById(manufacturerId).get();
        manufacturer.setDeleted(true);
        manufacturerRepository.save(manufacturer);
        return "redirect:/manufacturerlist";
    }

}
