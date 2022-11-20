package one.panpiper.data.repo.model.candidate;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.Id;
import java.io.Serializable;

@Getter
@Setter
@Embeddable
public class UserCompositeKey implements Serializable {

    @Id
    private String username;

    //TODO: Add more in future.
}
