package TodoList.backend.controller;

import TodoList.backend.model.Board;
import TodoList.backend.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// API Layer for Lst (GET, POST, PUT DELETE)
@RestController
@RequestMapping(path = "api/v1/board")
public class BoardController {
    private final BoardService listService;

    // Autowired: injects listService dependency into constructor
    // (to avoid create new instance of listService all the time)
    @Autowired
    public BoardController(BoardService listService) {
        this.listService = listService;
    }

    @GetMapping
    public List<Board> getLists() {
        return listService.getLists();
    }
}
