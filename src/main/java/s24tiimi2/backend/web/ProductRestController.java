package s24tiimi2.backend.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import s24tiimi2.backend.domain.Manufacturer;
import s24tiimi2.backend.domain.ManufacturerRepository;
import s24tiimi2.backend.domain.Product;
import s24tiimi2.backend.domain.ProductRepository;



@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class ProductRestController {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ManufacturerRepository manufacturerRepository;

	//RESTful service to get all products
	@GetMapping("/api/products")
	public @ResponseBody List<Product> getAllProducts() {
		return (List<Product>) productRepository.findAll();
	}

	@GetMapping("/api/manufacturers")
	public @ResponseBody List<Manufacturer> getAllManufacturers() {
		return (List<Manufacturer>) manufacturerRepository.findAll();
	}
	
	

	// RESTful service to get all products by type name
	@GetMapping("/api/products/type/{typename}")
	public @ResponseBody List<Product> productsByTypeRest(@PathVariable String typename) {

		return (List<Product>) productRepository.findAllByType_Name(typename);
	}

}
