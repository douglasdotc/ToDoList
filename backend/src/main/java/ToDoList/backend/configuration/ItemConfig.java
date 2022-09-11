package TodoList.backend.configuration;

import TodoList.backend.model.Item;
import TodoList.backend.repository.ItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

// This class set the configuration for the table Board
@Configuration
public class ItemConfig {
    @Bean // CommandLineRunner: auto-run function when it is contained in Spring Boot container
    CommandLineRunner itemCommandLineRunner(ItemRepository itemRepository) {
        return args -> {
            Item item1 = new Item(
                "item1",
                "content1"
            );

            Item item2 = new Item(
                "item2",
                "content2"
            );

            // This following line is executed when Hibernate invoke the function saveAll()
            itemRepository.saveAll(
                List.of(item1, item2)
            );
        };
    }
}
