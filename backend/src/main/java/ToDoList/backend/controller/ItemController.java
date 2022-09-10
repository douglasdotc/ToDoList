package TodoList.backend.controller;

import TodoList.backend.model.Item;
import TodoList.backend.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/item")
public class ItemController {
    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    public List<Item> getLists() {
        return itemService.getItems();
    }

    @PostMapping
    public void createItem(@RequestBody Item item) {
        itemService.createItem(item);
    }

    @PutMapping(path = "{itemId}")
    public void updateItem(@PathVariable("itemId") Long itemId,
                           @RequestParam(required = false) String title,
                           @RequestParam(required = false) String content) {
        itemService.updateItem(itemId, title, content);
    }

    @DeleteMapping(path = "{itemId}")
    public void deleteItem(@PathVariable("itemId") Long itemId) {
        itemService.deleteItem(itemId);
    }
}
