package br.frmurta.hrpayroll.services;

import br.frmurta.hrpayroll.feingclient.WorkerFeignClient;
import br.frmurta.hrpayroll.entities.Payment;
import br.frmurta.hrpayroll.entities.WorkerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private WorkerFeignClient workerFeignClient;


//    @Autowired
//    public PaymentServiceImpl(WorkerFeignClient workerFeignClient) {
//        this.workerFeignClient = workerFeignClient;
//    }


    public Payment getPayment(Long workerId, Integer days) {

        WorkerDTO worker = this.workerFeignClient.findById(workerId).getBody();

        return new Payment(worker, days);
    }
}
