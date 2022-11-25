package one.pan.piper.resume.data.model.candidate;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * Simple domain class representing a {@link CandidateEntity}
 *
 *  @author Kalathil Ajay Menon
 */
@Entity
@Getter
@Setter
@Table(name = "resume_candidate")
public class CandidateEntity implements Serializable {

    @EmbeddedId
    private UserCompositeKey userCompositeKey;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(unique = true, name = "email_address")
    private EmailAddressEmbeddable emailAddress;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "candidate_userkey")
    private Set<AddressEntity> addresses = new HashSet<>();

    public CandidateEntity(String firstName, String lastName, LocalDate dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }

    protected CandidateEntity() {
    }

    public void add(AddressEntity addressEntity) {
        this.addresses.add(addressEntity);
    }
}
