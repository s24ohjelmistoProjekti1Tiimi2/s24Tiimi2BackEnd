package s24tiimi2.backend.domain;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends CrudRepository<Product, Long> {

	List<Product> findAllByType_Name(@Param("name") String name);

	List<Product> findByManufacturer_Id(Long manufacturerId);

	boolean existsByManufacturerId(Long manufacturerId);

	@Query("SELECT p FROM Product p WHERE p.deleted = false")
    List<Product> findAllActive();

	@Query("SELECT p FROM Product p WHERE p.deleted = true")
	List<Product> findAllDeleted();
	
}
