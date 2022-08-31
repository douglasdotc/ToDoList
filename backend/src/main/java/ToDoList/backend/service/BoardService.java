package TodoList.backend.service;

import TodoList.backend.model.Board;
import TodoList.backend.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// This class holds all the business logic for Board
@Service
public class BoardService {

    private final BoardRepository boardRepository; // Interface that use to access the database

    @Autowired
    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public List<Board> getLists() {
        return boardRepository.findAll();
    }

    public void addNewBoard(Board board) {
        Optional<Board> boardByTitle = boardRepository.findBoardByTitle(board.getTitle());
        if (boardByTitle.isPresent()) {
            throw new IllegalStateException("title taken");
        }
        boardRepository.save(board);
    }

    public void deleteBoard(Long board_id) {
        boolean isExist = boardRepository.existsById((board_id));
        if (!isExist) {
            throw new IllegalStateException("Board with id: " + board_id + "does not exist.");
        }
        boardRepository.deleteById(board_id);
    }
}
