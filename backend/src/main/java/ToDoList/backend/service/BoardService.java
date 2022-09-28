package TodoList.backend.service;

import TodoList.backend.model.Board;
import TodoList.backend.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static java.time.LocalDateTime.now;

// This class holds all the business logic for Board
@Service
@RequiredArgsConstructor // Constructor with Dependency injection
@Transactional // This annotation frees the function from calling queries (E.g. SELECT b from Board b WHERE ...)
@Slf4j // Logs
public class BoardService {

    private final BoardRepository boardRepository; // Interface that use to access the database

    public List<Board> getBoards() {
        log.info("Fetching all boards");
        return boardRepository.findAll();
    }

    public Optional<Board> getBoardByTitle(String title) {
        log.info("Fetching board by name: {}", title);
        return boardRepository.findBoardByTitle(title);
    }

    public Board createBoard(Board board) {
        log.info("Saving new board ID: {}", board.getBoardId());
        Optional<Board> boardByTitle = boardRepository.findBoardByTitle(board.getTitle());
        if (boardByTitle.isPresent()) {
            throw new IllegalStateException("[POST] Board title " + board.getTitle() + " taken");
        }
        LocalDateTime timeNow = now();
        board.setCreatedAt(timeNow);
        board.setLastEditedAt(timeNow);
        return boardRepository.save(board);
    }

    public Boolean updateBoard(Long boardId, String title, String information) {
        log.info("Updating board with ID: {}", boardId);
        Board board = boardRepository.findById(boardId).orElseThrow(
            () -> new IllegalStateException("[PUT] Board with id: " + boardId + " does not exist")
        );

        if (title != null && title.length() > 0 && !Objects.equals(board.getTitle(), title)) {
            board.setTitle(title);
        }

        if (information != null && information.length() > 0 && !Objects.equals(board.getInformation(), information)) {
            board.setInformation(information);
        }

        board.setLastEditedAt(now());
        return true;
    }

    public Boolean deleteBoard(Long boardId) {
        log.info("Deleting board with ID: {}", boardId);
        boolean isExist = boardRepository.existsById((boardId));
        if (!isExist) {
            throw new IllegalStateException("[DELETE] Board with id: " + boardId + " does not exist.");
        }
        boardRepository.deleteById(boardId);
        return true;
    }
}
