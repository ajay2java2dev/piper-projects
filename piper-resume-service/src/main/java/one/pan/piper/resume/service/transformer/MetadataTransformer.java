package one.pan.piper.resume.service.transformer;

import one.pan.piper.resume.service.openapi.model.CandidateMetadata;
import org.springframework.stereotype.Component;

@Component
public class MetadataTransformer {
    public CandidateMetadata candidateMetadataTransform (Long totalCandidates) {
        return CandidateMetadata.builder()
                .totalNumberOfCandidates(totalCandidates)
                .build();
    }
}
