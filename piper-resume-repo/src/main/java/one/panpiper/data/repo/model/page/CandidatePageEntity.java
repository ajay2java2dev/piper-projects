package one.panpiper.data.repo.model.page;

import lombok.Getter;
import lombok.Setter;
import one.panpiper.data.repo.model.candidate.UserCompositeKey;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "candidate_page")
public class CandidatePageEntity {

    @EmbeddedId
    private UserCompositeKey userCompositeKey;

    @Column(name = "page_name", nullable = false)
    private String pageName;

    @Column(name = "title")
    private String title;

    //TODO: Add more

}
