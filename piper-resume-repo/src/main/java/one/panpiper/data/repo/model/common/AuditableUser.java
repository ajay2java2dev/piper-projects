package one.panpiper.data.repo.model.common;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

/**
 * User domain class that uses auditing functionality of Spring Data that can either be acquired implementing
 * {@link AuditableUser} or extend {@link org.springframework.data.jpa.domain.AbstractAuditable}.
 *
 * @author Oliver Gierke
 * @author Thomas Darimont
 */
@Entity
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class AuditableUser extends AbstractEntity{

    private String username;

    @Column(name = "created_date", nullable = false, updatable = false)
    @CreatedDate
    private LocalDateTime createdDate;

    @Column(name = "modified_date")
    @LastModifiedDate
    private LocalDateTime lastModifiedDate;

    @Column(name = "created_by")
    @ManyToOne
    @CreatedBy
    private AuditableUser createdBy;

    @Column(name = "modified_by")
    @ManyToOne
    @LastModifiedBy
    private AuditableUser lastModifiedBy;
}
