package s24tiimi2.backend.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import s24tiimi2.backend.domain.Product;
import s24tiimi2.backend.domain.ProductRepository;



@RestController
public class ProductRestController {

	@Autowired
	private ProductRepository repository;

	// RESTful service to get all products
	@GetMapping("/api/products")
	public @ResponseBody List<Product> productListRest() {
		return (List<Product>) repository.findAll();
	}

}
