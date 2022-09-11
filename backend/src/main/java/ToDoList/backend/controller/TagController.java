package TodoList.backend.controller;

import TodoList.backend.model.Item;
import TodoList.backend.model.Tag;
import TodoList.backend.service.TagService;
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

// API layer for Tag
@RestController
@RequestMapping(path = "api/v1/tag")
public class TagController {
    private final TagService tagService;

    @Autowired
    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @GetMapping
    public List<Tag> getTags(Item item) {
        if (item.getItemId() == null) {
            return tagService.getTags();
        } else {
            return tagService.getTagsByItemId(item);
        }
    }

    @PostMapping
    public void createTag(@RequestBody Tag tag) {
        tagService.createTag(tag);
    }

    @PutMapping(path = "{tagId}")
    public void updateTag(@PathVariable("tagId") Long tagId,
                          // TODO required = true since tags should depends on item
                          @RequestParam(required = false) Long itemId,
                          @RequestParam(required = false) String tagName) {
        tagService.updateTag(tagId, itemId, tagName);
    }

    @DeleteMapping(path = "{tagId}")
    public void deleteTag(@PathVariable("tagId") Long tagId) {
        tagService.deleteTag(tagId);
    }
}
