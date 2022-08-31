package TodoList.backend.controller;

import TodoList.backend.model.Board;
import TodoList.backend.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// API Layer for Board (GET, POST, PUT DELETE)
@RestController
@RequestMapping(path = "api/v1/board")
public class BoardController {
    private final BoardService boardService;

    // Autowired: injects boardService dependency into constructor
    // (to avoid create new instance of boardService all the time)
    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping
    public List<Board> getLists() {
        return boardService.getLists();
    }

    @PostMapping
    public void registerNewBoard(@RequestBody Board board) {
        boardService.addNewBoard(board);
    }

    @DeleteMapping(path = "{board_id}")
    public void deleteBoard(@PathVariable("board_id") Long board_id) {
        boardService.deleteBoard(board_id);
    }
}
