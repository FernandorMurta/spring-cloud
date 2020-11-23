package br.frmurta.hrpayroll.services;

import br.frmurta.hrpayroll.entities.Payment;

public interface PaymentService {

    Payment getPayment(Long workerId, Integer days);
}
