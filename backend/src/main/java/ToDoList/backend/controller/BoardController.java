package TodoList.backend.controller;

import TodoList.backend.model.Board;
import TodoList.backend.model.Response;
import TodoList.backend.service.BoardService;
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

// API Layer for Board (GET, POST, PUT DELETE)
@RestController
@RequestMapping(path = "api/v1/board")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/getBoards")
    public ResponseEntity<Response> getBoards() {

        return ResponseEntity.ok(
            Response.builder()
                .timeStamp(now())
                .data(of("boards", boardService.getBoards()))
                .message("Boards retrieved")
                .httpStatus(OK)
                .statusCode(OK.value())
                .build()
        );
    }

    @GetMapping("/getBoardByTitle/{title}")
    public ResponseEntity<Response> getBoardByTitle(@PathVariable("title") String title) {

        return ResponseEntity.ok(
            Response.builder()
                .timeStamp(now())
                .data(of("boards", boardService.getBoardByTitle(title)))
                .message("Board " + title + " retrieved")
                .httpStatus(OK)
                .statusCode(OK.value())
                .build()
        );
    }

    @PostMapping("/createBoard")
    public ResponseEntity<Response> createBoard(@RequestBody Board board) {

        return ResponseEntity.ok(
            Response.builder()
                .timeStamp(now())
                .data(of("boards", boardService.createBoard(board)))
                .message("Board with title: " + board.getTitle() + " created with ID:" + board.getBoardId())
                .httpStatus(CREATED)
                .statusCode(CREATED.value())
                .build()
        );
    }

    @PutMapping(path = "/updateBoard/{boardId}")
    public ResponseEntity<Response> updateBoard(@PathVariable("boardId") Long boardId,
                            @RequestParam(required = false) String title, // Optional
                            @RequestParam(required = false) String information) { // Optional

        if (title.length() == 0 && information.length() == 0) {
            return ResponseEntity.ok(
                Response.builder()
                    .timeStamp(now())
                    .data(of("isBoardUpdated", false))
                    .message("Board with ID: " + boardId + " is not updated because there is no input")
                    .httpStatus(OK)
                    .statusCode(OK.value())
                    .build()
            );
        }

        return ResponseEntity.ok(
            Response.builder()
                .timeStamp(now())
                .data(of("isBoardUpdated", boardService.updateBoard(boardId, title, information)))
                .message("Board with ID: " + boardId + " updated")
                .httpStatus(OK)
                .statusCode(OK.value())
                .build()
        );
    }

    @DeleteMapping(path = "/deleteBoard/{boardId}")
    public ResponseEntity<Response> deleteBoard(@PathVariable("boardId") Long boardId) {

        return ResponseEntity.ok(
            Response.builder()
                .timeStamp(now())
                .data(of("isBoardDeleted", boardService.deleteBoard(boardId)))
                .message("Board with ID: " + boardId + " deleted")
                .httpStatus(OK)
                .statusCode(OK.value())
                .build()
        );
    }
}
