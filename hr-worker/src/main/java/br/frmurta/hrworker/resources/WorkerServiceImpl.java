package br.frmurta.hrworker.resources;

import br.frmurta.hrworker.entities.WorkerDTO;
import br.frmurta.hrworker.repositories.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WorkerServiceImpl implements WorkerService {

    private final WorkerRepository workerRepository;

    @Autowired
    public WorkerServiceImpl(WorkerRepository workerRepository){
        this.workerRepository = workerRepository;
    }

    @Override
    public List<WorkerDTO> getAll(){
        return this.workerRepository.findAll().stream().map(WorkerDTO::new).collect(Collectors.toList());
    }

    @Override
    public WorkerDTO findById(Long id){
        return new WorkerDTO(this.workerRepository.findById(id).get());
    }
}
