package br.frmurta.hrworker.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WorkerDTO implements Serializable {

    private Long id;

    private String name;

    private Double dailyIncome;

    @Builder
    public WorkerDTO(Worker worker){
        this.id = worker.getId();
        this.name = worker.getName();
        this.dailyIncome = worker.getDailyIncome();
    }
}
