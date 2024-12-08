package s24tiimi2.backend.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class DeleteMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    
    @NotEmpty
    private String email;


    public DeleteMessage(long id, @NotEmpty String email) {
        this.id = id;
        this.email = email;
    }


    public DeleteMessage() {
    }


    public long getId() {
        return id;
    }


    public void setId(long id) {
        this.id = id;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public String toString() {
        return "DeleteMessage [id=" + id + ", email=" + email + "]";
    }


    

}
