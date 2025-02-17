package com.acai.acaibackend.model;

import jakarta.persistence.*;

@Entity
@Table
public class Complement {

    @Id
    @SequenceGenerator(
        name = "complement_sequence", sequenceName = "complement_sequence", allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "complement_sequence"
    )
    private Long id;
    private String name;
    private float price;

    public Complement(Long id, String name, float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Complement{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
