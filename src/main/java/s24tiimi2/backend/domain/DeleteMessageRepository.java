package s24tiimi2.backend.domain;

import org.springframework.data.repository.CrudRepository;



public interface DeleteMessageRepository extends CrudRepository<DeleteMessage, Long> {
    DeleteMessage findByEmail(String email);
}
