package TodoList.backend.service;

import TodoList.backend.model.Lst;
import TodoList.backend.repository.LstRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// This class holds all the service functions for Lst
@Service
public class LstService {

    private final LstRepository listRepository; // Interface that use to access the database

    @Autowired
    public LstService(LstRepository listRepository) {
        this.listRepository = listRepository;
    }

    public List<Lst> getLists() {
        return listRepository.findAll();
    }
}
