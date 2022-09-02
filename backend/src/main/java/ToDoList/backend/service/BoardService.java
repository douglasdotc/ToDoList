package TodoList.backend.service;

import TodoList.backend.model.Board;
import TodoList.backend.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
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

    public void deleteBoard(Long boardId) {
        boolean isExist = boardRepository.existsById((boardId));
        if (!isExist) {
            throw new IllegalStateException("Board with id: " + boardId + "does not exist.");
        }
        boardRepository.deleteById(boardId);
    }

    @Transactional // This Annotation frees the function from calling queries (E.g. SELECT b from Board b WHERE ...)
    public void updateBoard(Long boardId, String title, String information) {
        Board board = boardRepository.findById(boardId).orElseThrow(() -> new IllegalStateException("Board with id: " + boardId + " does not exist"));

        if (title != null && title.length() > 0 && !Objects.equals(board.getTitle(), title)) {
            board.setTitle(title);
        }

        if (information != null && information.length() > 0 && !Objects.equals(board.getInformation(), information)) {
            board.setInformation(information);
        }
    }
}
