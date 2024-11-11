package s24tiimi2.backend.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
//import jakarta.validation.constraints.NotNull;
//import jakarta.validation.constraints.Pattern;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String color;

    private Double price;

    //@Pattern(regexp = "S|M|L|-")
    private String size;

    @ManyToOne
    @JsonIgnoreProperties("products")
    @JoinColumn(name = "manufacturerId")
    //@NotNull
    private Manufacturer manufacturer;

    @ManyToOne
    @JsonIgnoreProperties("products")
    @JoinColumn(name = "typeId")
    //@NotNull
    private Type type;

    public Product(String name, String color, Double price, String size, Manufacturer manufacturer, Type type) {
        super();
        this.name = name;
        this.color = color;
        this.price = price;
        this.size = size;
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
                + ", manufacturer=" + manufacturer + ", type=" + type + "]";
    }

}
