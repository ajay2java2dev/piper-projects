package one.panpiper.data.repo.repositories.page;

import one.panpiper.data.repo.model.candidate.UserCompositeKey;
import one.panpiper.data.repo.model.page.CandidatePageEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.awt.print.Pageable;
import java.util.List;

public interface CandidatePageRepository extends PagingAndSortingRepository<CandidatePageEntity, UserCompositeKey> {

    List<CandidatePageEntity> findCandidatePagesByUserCompositeKey(UserCompositeKey userCompositeKey, Pageable pageable);
}
