package s24tiimi2.backend;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import s24tiimi2.backend.domain.Product;
import s24tiimi2.backend.domain.ProductRepository;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Bean
	public CommandLineRunner products(ProductRepository productRepo) {

		return (arg) -> {

			Product collar1 = new Product("collar", "green", "small", 12.49);
			productRepo.save(collar1);

			for (Product product : productRepo.findAll()) {
				System.out.println(product.toString());
			}

		};
	}
}
