package one.pan.piper.resume.service.controller.read;

import one.pan.piper.resume.service.accessor.CandidateAccessor;
import one.pan.piper.resume.service.representation.metadata.CandidateMetadata;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("meta")
public class ResumeServiceMetaController {

    private CandidateAccessor candidateAccessor;

    public ResumeServiceMetaController(CandidateAccessor candidateAccessor) {
        this.candidateAccessor = candidateAccessor;
    }

    @GetMapping(value = "/candidates", produces = "application/json")
    public ResponseEntity<CandidateMetadata> getCandidateMeta(@RequestParam MultiValueMap<String, Object> metaKeys) {
        return new ResponseEntity<>(candidateAccessor.retrieveCandidateMetadata(metaKeys), HttpStatus.OK);
    }

}
