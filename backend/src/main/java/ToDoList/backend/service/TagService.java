package TodoList.backend.service;

import TodoList.backend.model.Item;
import TodoList.backend.model.Tag;
import TodoList.backend.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

// This class holds all the business logic for Tag
@Service
public class TagService {
    private final TagRepository tagRepository; // Interface that use to access the database

    @Autowired
    public TagService(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    public List<Tag> getTags() {
        return tagRepository.findAll();
    }

    public List<Tag> getTagsByItemId(Item item) {
        // return the tags belongs to specified itemId
        return tagRepository.findTagsByItemId(item.getItemId());
    }

    public void createTag(Tag tag) {
        tagRepository.save(tag);
    }

    @Transactional
    public void updateTag(Long tagId, Long itemId, String tagName) {
        Tag tag = tagRepository.findById(tagId).orElseThrow(
            () -> new IllegalStateException("[PUT] Tag with id: " + " does not exist.")
        );

        if (itemId != null && itemId > 0 && !Objects.equals(tag.getItemId(), itemId)) {
            tag.setItemId(itemId);
        }

        if (tagName != null && tagName.length() > 0 && !Objects.equals(tag.getTagName(), tagName)) {
            tag.setTagName(tagName);
        }
    }

    public void deleteTag(Long tagId) {
        boolean isExist = tagRepository.existsById(tagId);
        if (!isExist) {
            throw new IllegalStateException("[DELETE] Tag with id: " + tagId + " does not exist.");
        }
        tagRepository.deleteById(tagId);
    }
}
