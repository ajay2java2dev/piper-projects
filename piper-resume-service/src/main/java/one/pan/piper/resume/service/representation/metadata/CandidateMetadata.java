package one.pan.piper.resume.service.representation.metadata;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CandidateMetadata {
    private Long totalCandidateCount;
}
