package br.frmurta.hrpayroll.services;

import br.frmurta.hrpayroll.entities.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    public Payment getPayment(Long workerId, Integer days) {
        return new Payment("Fernando", 200.0, days);
    }
}
