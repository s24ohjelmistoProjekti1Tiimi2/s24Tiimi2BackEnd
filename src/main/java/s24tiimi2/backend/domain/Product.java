package s24tiimi2.backend.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Tuotteella täytyy olla nimi.")
    private String name;
    
    private String color;

    @NotNull(message = "Tuotteella täytyy olla hinta.")
    private Double price;

    private String size;

    @NotNull(message = "Tuotteella oltava varastomäärä")
    private Integer stock;

    @ManyToOne
    @JsonIgnoreProperties("products")
    @JoinColumn(name = "manufacturerId")
    @NotNull(message = "Tuotteella täytyy olla valmistaja")
    private Manufacturer manufacturer;

    @ManyToOne
    @JsonIgnoreProperties("products")
    @JoinColumn(name = "type_id")
    @NotNull(message = "Tuotteella täytyy olla tyyppi")
    private Type type;

    public Product(String name, String color, Double price, String size, Integer stock, Manufacturer manufacturer, Type type) {
        super();
        this.name = name;
        this.color = color;
        this.price = price;
        this.size = size;
        this.stock = stock;
        this.manufacturer = manufacturer;
        this.type = type;
    }

    public Product() {
    }

    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getColor() {
        return color;
    }
    
    public void setColor(String color) {
        this.color = color;
    }
    
    public Double getPrice() {
        return price;
    }
    
    public void setPrice(Double price) {
        this.price = price;
    }
    
    public String getSize() {
        return size;
    }
    
    public void setSize(String size) {
        this.size = size;
    }
    
    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
    
    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", color=" + color + ", price=" + price + ", size=" + size
                + ", manufacturer=" + manufacturer + ", type=" + type + ", stock=" + stock + "]";
    }

}
