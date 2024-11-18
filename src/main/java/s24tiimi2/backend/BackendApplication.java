package s24tiimi2.backend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import s24tiimi2.backend.domain.Manufacturer;
import s24tiimi2.backend.domain.ManufacturerRepository;
import s24tiimi2.backend.domain.Product;
import s24tiimi2.backend.domain.ProductRepository;
import s24tiimi2.backend.domain.Type;
import s24tiimi2.backend.domain.TypeRepository;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	private static final Logger log = LoggerFactory.getLogger(BackendApplication.class);

	// @Bean
	// public CommandLineRunner products(ProductRepository productRepo, ManufacturerRepository manufRepo, TypeRepository typeRepo) {

	// 	return (arg) -> {

	// 		Manufacturer manufacturer1 = new Manufacturer("Feel active");
	// 		Manufacturer manufacturer2 = new Manufacturer("Little&Bigger");
	// 		Manufacturer manufacturer3 = new Manufacturer("Nutrima");
	// 		manufRepo.save(manufacturer1);
	// 		manufRepo.save(manufacturer2);
	// 		manufRepo.save(manufacturer3);

	// 		Type type1 = new Type("clothing");
	// 		Type type2 = new Type("toy");
	// 		Type type3 = new Type("food");
	// 		typeRepo.save(type1);
	// 		typeRepo.save(type2);
	// 		typeRepo.save(type3);

	// 		Product product1 = new Product("Padded collar", "black", 14.49, "S", manufacturer1, type1);
	// 		Product product2 = new Product("Shirt", "red", 9.99, "L", manufacturer1, type1 );
	// 		Product product3 = new Product("Shaggy aktivointimatto", "blue", 24.99, null, manufacturer2, type2);
	// 		Product product4 = new Product("Health Skin+ ankka, riista & peura", null, 2.59, null, manufacturer3, type3);
	// 		productRepo.save(product1);
	// 		productRepo.save(product2);
	// 		productRepo.save(product3);
	// 		productRepo.save(product4);

	// 		log.info("print demos");
	// 		for (Product product : productRepo.findAll()) {
	// 			System.out.println(product.toString());
	// 		}
	// 		for (Manufacturer manufacturer : manufRepo.findAll()) {
	// 			System.out.println(manufacturer.toString());
	// 		}

	// 	};
	// }
}
