package br.frmurta.hrpayroll.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment implements Serializable {

    private String name;

    private Double dailyIncome;

    private Integer days;

    public Payment(WorkerDTO worker, Integer days){
        this.name = worker.getName();
        this.dailyIncome = worker.getDailyIncome();
        this.days = days;
    }

    public Double getTotal() {
        return this.days * this.dailyIncome;
    }
}
