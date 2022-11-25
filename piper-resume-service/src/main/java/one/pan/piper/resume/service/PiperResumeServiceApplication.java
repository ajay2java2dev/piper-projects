package one.pan.piper.resume.service;

import one.pan.piper.resume.data.model.NoopModelMarker;
import one.pan.piper.resume.data.repositories.NoopRepositoryMarker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = {NoopRepositoryMarker.class, NoopModelMarker.class})
@EntityScan(basePackages = "one.pan.piper.resume.data")
public class PiperResumeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PiperResumeServiceApplication.class, args);
	}

}
