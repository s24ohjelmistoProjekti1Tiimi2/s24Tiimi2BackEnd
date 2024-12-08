package s24tiimi2.backend.domain;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {


	@Query("SELECT c FROM Customer c WHERE c.deleted = false")
    List<Customer> findAllActive();

    @Query("SELECT c FROM Customer c WHERE c.deleted = true")
    List<Customer> findAllDeleted();
}