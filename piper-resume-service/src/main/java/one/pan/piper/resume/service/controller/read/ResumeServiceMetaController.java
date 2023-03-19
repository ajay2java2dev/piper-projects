package one.pan.piper.resume.service.controller.read;

import one.pan.piper.resume.service.accessor.CandidateAccessor;
import one.pan.piper.resume.service.openapi.api.MetaApi;
import one.pan.piper.resume.service.openapi.model.CandidateMetadata;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Optional;

@RestController
public class ResumeServiceMetaController implements MetaApi {

    private CandidateAccessor candidateAccessor;

    public ResumeServiceMetaController(CandidateAccessor candidateAccessor) {
        this.candidateAccessor = candidateAccessor;
    }
}
