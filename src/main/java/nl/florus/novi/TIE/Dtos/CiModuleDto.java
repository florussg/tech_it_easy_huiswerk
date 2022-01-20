package nl.florus.novi.TIE.Dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CiModuleDto {

    //attributen
    //@NotBlank
    private String name;

    //@NotBlank
    private String type;

    //@NotBlank
    private double price;

    //GETTERS

    public String getName() {
        return name;
    }
    public String getType() {
        return type;
    }
    public double getPrice() {
        return price;
    }

    //SETTERS
    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}






