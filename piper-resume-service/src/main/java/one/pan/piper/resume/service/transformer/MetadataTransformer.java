package one.pan.piper.resume.service.transformer;

import one.pan.piper.resume.service.representation.metadata.CandidateMetadata;
import org.springframework.stereotype.Component;

@Component
public class MetadataTransformer {

    public CandidateMetadata candidateMetadataTransform (Long totalCandidates) {
        return CandidateMetadata.builder()
                .totalCandidateCount(totalCandidates)
                .build();
    }
}
