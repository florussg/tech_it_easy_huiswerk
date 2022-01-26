package nl.florus.novi.TIE.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
//@Table(name = "cimodules")
public class CiModule {

    //attributen
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String type;

    private double price;

    @OneToMany (mappedBy = "ciModule")
    @JsonIgnore
    List<Television> television;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<Television> getTelevision() {
        return television;
    }

    public void setTelevision(List<Television> television) {
        this.television = television;
    }
}



