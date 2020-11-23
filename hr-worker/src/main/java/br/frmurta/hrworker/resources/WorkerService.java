package br.frmurta.hrworker.resources;

import br.frmurta.hrworker.entities.WorkerDTO;

import java.util.List;

public interface WorkerService {

    List<WorkerDTO> getAll();

    WorkerDTO findById(Long id);
}
