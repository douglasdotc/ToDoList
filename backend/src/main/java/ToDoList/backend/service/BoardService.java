package TodoList.backend.service;

import TodoList.backend.model.Board;
import TodoList.backend.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// This class holds all the service functions for Lst
@Service
public class BoardService {

    private final BoardRepository listRepository; // Interface that use to access the database

    @Autowired
    public BoardService(BoardRepository listRepository) {
        this.listRepository = listRepository;
    }

    public List<Board> getLists() {
        return listRepository.findAll();
    }
}
