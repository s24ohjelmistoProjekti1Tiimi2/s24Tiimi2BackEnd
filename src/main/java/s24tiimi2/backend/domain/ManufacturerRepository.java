package s24tiimi2.backend.domain;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ManufacturerRepository extends CrudRepository<Manufacturer, Long> {
    
    @Query("SELECT m FROM Manufacturer m WHERE m.deleted = false")
    List<Manufacturer> findAllActive();

    @Query("SELECT m FROM Manufacturer m WHERE m.deleted = true")
    List<Manufacturer> findAllDeleted();
    
}
