package TodoList.backend.service;

import TodoList.backend.model.Item;
import TodoList.backend.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

// This class holds all the business logic for Item
// TODO: CRUD an item in a board require updating the last edited entry in Board
@Service
public class ItemService {
    private final ItemRepository itemRepository; // Interface that use to access the item database

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> getItems() {
        return itemRepository.findAll();
    }

    public void createItem(Item item) {
        // Different board can have item with the same title and content
        itemRepository.save(item);
    }

    @Transactional
    public void updateItem(Long itemId, String title, String content) {
        Item item = itemRepository.findById(itemId).orElseThrow(
            () -> new IllegalStateException("[PUT] Item with id: " + itemId + " does not exist")
        );

        if (title != null && title.length() > 0 && !Objects.equals(item.getTitle(), title)) {
            item.setTitle(title);
        }

        if (content != null && content.length() > 0 && !Objects.equals(item.getContent(), content)) {
            item.setContent(content);
        }
    }

    public void deleteItem(Long itemId) {
        boolean isExist = itemRepository.existsById(itemId);
        if (!isExist) {
            throw new IllegalStateException("[DELETE] Item with id: " + itemId + " does not exist.");
        }
        itemRepository.deleteById(itemId);
    }
}
