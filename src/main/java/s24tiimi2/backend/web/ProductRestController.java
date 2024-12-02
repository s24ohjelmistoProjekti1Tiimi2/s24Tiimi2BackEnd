package s24tiimi2.backend.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import s24tiimi2.backend.domain.Customer;
import s24tiimi2.backend.domain.CustomerRepository;
import s24tiimi2.backend.domain.Manufacturer;
import s24tiimi2.backend.domain.ManufacturerRepository;
import s24tiimi2.backend.domain.Product;
import s24tiimi2.backend.domain.ProductRepository;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;





//@CrossOrigin(origins = {"http://localhost:5173", "https://s24ohjelmistoprojekti1tiimi2.github.io"})
@CrossOrigin
@RestController
public class ProductRestController {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ManufacturerRepository manufacturerRepository;

	@Autowired
	private CustomerRepository customerRepository;

	//RESTful service to get all products
	@GetMapping("/api/products")
	public @ResponseBody List<Product> getAllProducts() {
		return (List<Product>) productRepository.findAll();
	}

	@GetMapping("/api/manufacturers")
	public @ResponseBody List<Manufacturer> getAllManufacturers() {
		return (List<Manufacturer>) manufacturerRepository.findAll();
	}
	
	@GetMapping("/api/customers")
	public @ResponseBody List<Customer> getAllCustomers() {
		return (List<Customer>) customerRepository.findAll();
	}

	// RESTful service to get all products by type name
	@GetMapping("/api/products/type/{typename}")
	public @ResponseBody List<Product> productsByTypeRest(@PathVariable String typename) {
		return (List<Product>) productRepository.findAllByType_Name(typename);
	}

	@PostMapping("/api/customers")
	public @ResponseBody Customer createCustomer(@RequestBody Customer customer) {
		return customerRepository.save(customer);
	}
	

}
