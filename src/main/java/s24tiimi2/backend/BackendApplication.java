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

	@Bean
	public CommandLineRunner products(ProductRepository productRepo, ManufacturerRepository manufRepo, TypeRepository typeRepo) {

		return (arg) -> {

			Manufacturer demo2 = new Manufacturer("Feel active");
			manufRepo.save(demo2);

			Type clothing = new Type("clothing");
			Type toy = new Type("toy");
			Type food = new Type("food");
			typeRepo.save(clothing);
			typeRepo.save(toy);
			typeRepo.save(food);

			Product demo1 = new Product("Padded collar", "black", "small", 14.49, demo2, clothing);
			productRepo.save(demo1);

			log.info("print demos");
			for (Product product : productRepo.findAll()) {
				System.out.println(product.toString());
			}
			for (Manufacturer manufacturer : manufRepo.findAll()) {
				System.out.println(manufacturer.toString());
			}

		};
	}
}
