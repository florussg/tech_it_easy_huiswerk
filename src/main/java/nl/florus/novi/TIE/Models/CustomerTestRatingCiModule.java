package nl.florus.novi.TIE.Models;

import javax.persistence.*;

@Entity
public class CustomerTestRatingCiModule {

    @EmbeddedId
    CustomerTestRatingCiModuleKey id;

    @ManyToOne
    @MapsId("customertestId")
    @JoinColumn(name= "customer_test_id")
    CustomerTest customerTest;

    @ManyToOne
    @MapsId("cimoduleId")
    @JoinColumn(name="cimodule_id")
    CiModule ciModule;

    int rating;

    public CustomerTestRatingCiModuleKey getId() {
        return id;
    }

    public void setId(CustomerTestRatingCiModuleKey id) {
        this.id = id;
    }

    public CustomerTest getCustomerTest() {
        return customerTest;
    }

    public void setCustomerTest(CustomerTest customerTest) {
        this.customerTest = customerTest;
    }

    public CiModule getCiModule() {
        return ciModule;
    }

    public void setCiModule(CiModule ciModule) {
        this.ciModule = ciModule;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
