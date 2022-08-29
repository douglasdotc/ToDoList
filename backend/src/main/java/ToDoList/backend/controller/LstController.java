package TodoList.backend.controller;

import TodoList.backend.model.Lst;
import TodoList.backend.service.LstService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/list")
public class LstController {
    private final LstService listService;

    // Autowired: injects listService dependency into constructor
    // (to avoid create new instance of listService all the time)
    @Autowired
    public LstController(LstService listService) {
        this.listService = listService;
    }

    @GetMapping
    public List<Lst> getLists() {
        return listService.getLists();
    }
}
