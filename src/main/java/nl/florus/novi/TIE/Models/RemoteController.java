package nl.florus.novi.TIE.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RemoteController {

    //attributen
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String compatibleWith;

    private String batteryType;

    private String name;

    private String brand;

    private double price;

    private int originalStock;

}

