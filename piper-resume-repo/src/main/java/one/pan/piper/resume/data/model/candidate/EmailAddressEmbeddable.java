package one.pan.piper.resume.data.model.candidate;

import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.regex.Pattern;

@Embeddable
public class EmailAddressEmbeddable {

    private static final String EMAIL_REGEX = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private static final Pattern PATTERN = Pattern.compile(EMAIL_REGEX);

    @Column(name = "email")
    private String value;

    public EmailAddressEmbeddable(String emailAddress) {
        this.value = emailAddress;
    }

    protected EmailAddressEmbeddable() {
    }

    public static boolean isValid(String candidateValue) {
        return candidateValue != null && PATTERN.matcher(candidateValue).matches();
    }
}
