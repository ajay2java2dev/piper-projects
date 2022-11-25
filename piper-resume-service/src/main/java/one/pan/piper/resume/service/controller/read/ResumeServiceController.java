package one.pan.piper.resume.service.controller.read;

import one.pan.piper.resume.service.accessor.CandidateAccessor;
import one.pan.piper.resume.service.representation.metadata.CandidateMetadata;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResumeServiceController {

    private CandidateAccessor candidateAccessor;

    public ResumeServiceController(CandidateAccessor candidateAccessor) {
        this.candidateAccessor = candidateAccessor;
    }

    @GetMapping("/resumes/{resumeId}")
    public ResponseEntity<CandidateMetadata> getResume(@PathVariable String resumeId) {
        return new ResponseEntity<>(candidateAccessor.retrieveCandidateMetadata(10), HttpStatus.OK);
    }

}
