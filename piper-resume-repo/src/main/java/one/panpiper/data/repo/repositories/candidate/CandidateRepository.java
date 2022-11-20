package one.panpiper.data.repo.repositories.candidate;

import one.panpiper.data.repo.model.candidate.CandidateEntity;
import one.panpiper.data.repo.model.candidate.UserCompositeKey;
import org.springframework.data.repository.CrudRepository;

public interface CandidateRepository extends CrudRepository<CandidateEntity, UserCompositeKey> {

    CandidateEntity findCandidateEntityByUserCompositeKey(UserCompositeKey userCompositeKey);
}
