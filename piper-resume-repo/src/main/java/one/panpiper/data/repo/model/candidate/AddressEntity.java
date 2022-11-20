package one.panpiper.data.repo.model.candidate;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author Kalathil Ajay Menon
 */
@Entity
@Getter
@Table(name = "resume_address")
public class AddressEntity implements Serializable {

    @EmbeddedId
    private UserCompositeKey userCompositeKey;

    @Column(name = "line_1")
    private String line1;

    @Column(name = "line_2")
    private String line2;

    @Column(name = "city")
    private String city;

    @Column(name = "county")
    private String country;

    @Column(name = "postal_code")
    private String postalCode;

    public AddressEntity(String line1, String line2, String city, String country, String postalCode) {
        this.line1 = line1;
        this.line2 = line2;
        this.city = city;
        this.country = country;
        this.postalCode = postalCode;
    }

    protected AddressEntity() {
    }

    public AddressEntity getCopy() {
        return new AddressEntity(this.line1, this.line2, this.city, this.country, this.postalCode);
    }
}
