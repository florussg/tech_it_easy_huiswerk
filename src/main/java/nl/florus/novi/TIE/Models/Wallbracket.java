package nl.florus.novi.TIE.Models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Wallbracket {

    //attributen
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String size;

    private Boolean ajustable;

    private String name;

    private double price;

    @ManyToMany
    private List<Television> television;
}
