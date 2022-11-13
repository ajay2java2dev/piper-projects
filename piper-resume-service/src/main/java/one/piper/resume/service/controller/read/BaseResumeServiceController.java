package one.piper.resume.service.controller.read;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseResumeServiceController {

    @GetMapping("/resumes/{accountId}")
    public ResponseEntity<String> getResume(@PathVariable String accountId) {
        return new ResponseEntity<>("Welcome to resume services. Your accountID :" + accountId, HttpStatus.OK);
    }

}
