package br.frmurta.hrpayroll.services;

import br.frmurta.hrpayroll.entities.Payment;
import br.frmurta.hrpayroll.entities.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final RestTemplate restTemplate;

    @Value("${br.frmurta.hr-worker.base_url}")
    private String workerBaseUrl;


    @Autowired
    public PaymentServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public Payment getPayment(Long workerId, Integer days) {

        Map<String, String> uriVariable = new HashMap<>();
        uriVariable.put("id", workerId.toString());

        Worker worker = this.restTemplate.getForObject(this.getWorkerUrl() + "/{id}", Worker.class, uriVariable);

        return new Payment(worker, days);
    }

    private String getWorkerUrl() {
        return this.workerBaseUrl + "/workers";
    }
}
