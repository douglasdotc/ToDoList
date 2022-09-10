package TodoList.backend.configuration;

import TodoList.backend.model.Tag;
import TodoList.backend.repository.TagRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

// This class set the config for the table tag
@Configuration
public class TagConfig {
    @Bean
    CommandLineRunner tagCommandLineRunner(TagRepository tagRepository) {
        return args -> {
            Tag tag1 = new Tag(
                1L,
                "name1"
            );

            Tag tag2 = new Tag(
                1L,
                "name2"
            );

            tagRepository.saveAll(
                List.of(tag1, tag2)
            );
        };
    }
}
