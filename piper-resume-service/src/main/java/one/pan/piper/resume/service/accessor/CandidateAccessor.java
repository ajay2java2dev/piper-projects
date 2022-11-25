package one.pan.piper.resume.service.accessor;

import one.pan.piper.resume.data.repositories.candidate.CandidateRepository;
import one.pan.piper.resume.service.representation.metadata.CandidateMetadata;
import one.pan.piper.resume.service.transformer.MetadataTransformer;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class CandidateAccessor {

    CandidateRepository candidateRepository;
    MetadataTransformer metadataTransformer;

    public CandidateAccessor (CandidateRepository candidateRepository, MetadataTransformer metadataTransformer) {
        this.candidateRepository = candidateRepository;
        this.metadataTransformer = metadataTransformer;
    }

    private Long getTotalNumberOfCandidatesYearsBefore (Integer yearsBefore) {
        return candidateRepository.countAllByDateOfBirthGreaterThan(LocalDate.now().minusYears(yearsBefore));
    }

    //Metadata
    public CandidateMetadata retrieveCandidateMetadata (Integer yearsBefore) {
        var totalNumYears = getTotalNumberOfCandidatesYearsBefore(yearsBefore);
        return metadataTransformer.candidateMetadataTransform(totalNumYears);
    }
}
