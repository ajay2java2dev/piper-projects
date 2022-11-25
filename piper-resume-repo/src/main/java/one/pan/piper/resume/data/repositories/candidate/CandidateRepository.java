package one.pan.piper.resume.data.repositories.candidate;

import one.pan.piper.resume.data.model.candidate.UserCompositeKey;
import one.pan.piper.resume.data.model.candidate.CandidateEntity;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;

public interface CandidateRepository extends CrudRepository<CandidateEntity, UserCompositeKey> {

    CandidateEntity findCandidateEntityByUserCompositeKey(UserCompositeKey userCompositeKey);
    Long countAllByDateOfBirthGreaterThan(LocalDate localDate);
}
