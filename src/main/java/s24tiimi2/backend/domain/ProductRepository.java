package s24tiimi2.backend.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends CrudRepository<Product, Long> {

	List<Product> findAllByType_Name(@Param("name") String name);
}
