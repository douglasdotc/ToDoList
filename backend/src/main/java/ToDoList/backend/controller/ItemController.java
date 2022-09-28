package TodoList.backend.controller;

import TodoList.backend.model.Item;
import TodoList.backend.model.Response;
import TodoList.backend.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static java.time.LocalDateTime.now;
import static java.util.Map.of;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(path = "api/v1/item")
@RequiredArgsConstructor
public class ItemController {
    private final ItemService itemService;

    @GetMapping("/getItems")
    public ResponseEntity<Response> getItems() {

        return ResponseEntity.ok(
            Response.builder()
                .timeStamp(now())
                .data(of("items", itemService.getItems()))
                .message("Items retrieved")
                .httpStatus(OK)
                .statusCode(OK.value())
                .build()
        );
    }

    @PostMapping("/createItem")
    public ResponseEntity<Response> createItem(@RequestBody Item item) {
        ;
        return ResponseEntity.ok(
            Response.builder()
                .timeStamp(now())
                .data(of("item", itemService.createItem(item)))
                .message("Board with title: " + item.getTitle() + " created with ID:" + item.getItemId())
                .httpStatus(CREATED)
                .statusCode(CREATED.value())
                .build()
        );
    }

    @PutMapping(path = "/updateItem/{itemId}")
    public ResponseEntity<Response> updateItem(@PathVariable("itemId") Long itemId,
                           @RequestParam(required = false) String title,
                           @RequestParam(required = false) String content) {

        if (title.length() == 0 && content.length() == 0) {
            return ResponseEntity.ok(
                Response.builder()
                    .timeStamp(now())
                    .data(of("isBoardUpdated", false))
                    .message("Board with ID: " + itemId + " is not updated because there is no input")
                    .httpStatus(OK)
                    .statusCode(OK.value())
                    .build()
            );
        }

        return ResponseEntity.ok(
            Response.builder()
                .timeStamp(now())
                .data(of("isBoardUpdated", itemService.updateItem(itemId, title, content)))
                .message("Board with ID: " + itemId + " updated")
                .httpStatus(OK)
                .statusCode(OK.value())
                .build()
        );
    }

    @DeleteMapping(path = "/deleteItem/{itemId}")
    public ResponseEntity<Response> deleteItem(@PathVariable("itemId") Long itemId) {

        return ResponseEntity.ok(
            Response.builder()
                .timeStamp(now())
                .data(of("isBoardDeleted", itemService.deleteItem(itemId)))
                .message("Board with ID: " + itemId + " deleted")
                .httpStatus(OK)
                .statusCode(OK.value())
                .build()
        );
    }
}
