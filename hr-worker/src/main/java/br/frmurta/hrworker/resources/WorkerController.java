package br.frmurta.hrworker.resources;

import br.frmurta.hrworker.entities.WorkerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/workers")
public class WorkerController {

    private final WorkerService workerService;


    @Autowired
    public WorkerController(WorkerServiceImpl workerService) {
        this.workerService = workerService;
    }


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<WorkerDTO>> findAll() {
        return ResponseEntity.ok(this.workerService.getAll());
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<WorkerDTO> findById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(this.workerService.findById(id));
    }

}
