package nl.florus.novi.TIE.Models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "customerstest")
public class CustomerTest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "customerTest")
    Set<CustomerTestRatingCiModule> ratings;
}
