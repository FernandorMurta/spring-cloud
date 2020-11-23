package br.frmurta.hrworker.resources;

import br.frmurta.hrworker.entities.WorkerDTO;
import br.frmurta.hrworker.repositories.WorkerRepository;
import net.bytebuddy.asm.Advice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/workers")
public class WorkerController {

    private final static Logger logger = LoggerFactory.getLogger(WorkerController.class);

    private final WorkerService workerService;

    private final Environment env;

    @Autowired
    public WorkerController(WorkerServiceImpl workerService,
                            Environment env) {
        this.workerService = workerService;
        this.env = env;
    }


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<WorkerDTO>> findAll() {
        return ResponseEntity.ok(this.workerService.getAll());
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<WorkerDTO> findById(@PathVariable(value = "id") Long id) {
        logger.info("PORT"+ env.getProperty("local.server.port"));
        return ResponseEntity.ok(this.workerService.findById(id));
    }
}
