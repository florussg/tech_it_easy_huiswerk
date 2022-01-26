package nl.florus.novi.TIE.Models;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;

@Embeddable
public class CustomerTestRatingCiModuleKey implements Serializable {

    @Column (name = "customertest_id")
    Long customertestId;

    @Column (name = "cimodule_id")
    Long cimoduleId;


    //getters and setters


    public Long getCustomertestId() {
        return customertestId;
    }

    public void setCustomertestId(Long customertestId) {
        this.customertestId = customertestId;
    }

    public Long getCimoduleId() {
        return cimoduleId;
    }

    public void setCimoduleId(Long cimoduleId) {
        this.cimoduleId = cimoduleId;
    }

}
