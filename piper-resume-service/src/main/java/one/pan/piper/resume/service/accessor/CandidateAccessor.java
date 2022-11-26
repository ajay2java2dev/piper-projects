package one.pan.piper.resume.service.accessor;

import one.pan.piper.resume.data.repositories.candidate.CandidateRepository;
import one.pan.piper.resume.service.openapi.model.CandidateMetadata;
import one.pan.piper.resume.service.transformer.MetadataTransformer;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;

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
    public CandidateMetadata retrieveCandidateMetadata (MultiValueMap<String, Object> metaKeys) {
        //TODO: Validate keys.
        var totalNumYears = getTotalNumberOfCandidatesYearsBefore(metaKeys.containsKey("years_before") ?
                (Integer) metaKeys.getFirst("years_before"): Integer.valueOf(0));
        return metadataTransformer.candidateMetadataTransform(totalNumYears);
    }
}
