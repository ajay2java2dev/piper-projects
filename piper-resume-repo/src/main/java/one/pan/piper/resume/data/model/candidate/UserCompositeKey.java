package one.pan.piper.resume.data.model.candidate;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter
@EqualsAndHashCode
public class UserCompositeKey implements Serializable {

    private String username;

}
